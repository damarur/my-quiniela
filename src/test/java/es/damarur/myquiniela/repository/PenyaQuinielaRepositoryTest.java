package es.damarur.myquiniela.repository;

import es.damarur.myquiniela.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ContextConfiguration(classes = PenyaQuinielaRepository.class)
public class PenyaQuinielaRepositoryTest extends BaseRepositoryTest {

    private static final String EMAIL = "test@test.com";

    @Autowired
    private PenyaQuinielaRepository penyaQuinielaRepository;
    @Autowired
    private TeamRepository teamRepository;

    private List<Team> teams = new ArrayList<>();
    private Penya penya;
    private Quiniela quiniela;

    @BeforeEach
    void setUp() {
        entityManager.persistAndFlush(Team.builder().name("REAL MADRID").build());
        entityManager.persistAndFlush(Team.builder().name("VALENCIA").build());
        teams = StreamSupport
                .stream(teamRepository.findAll().spliterator(), false)
                .toList();
        Usuario usuario = entityManager.persistAndFlush(Usuario.builder()
                .email(EMAIL)
                .passwordHash("some-hash")
                .active(true)
                .lastLogin(Instant.now())
                .build());
        penya = Penya.builder()
                .name("QUINIELISTAS FROM VALENCIA")
                .doubles(3)
                .triples(1)
                .admin(usuario.getId())
                .user(usuario.getId())
                .build();
        quiniela = Quiniela.builder()
                .title("My first Quiniela")
                .description("Jornada 1 - 01/09/2024 - 14:00")
                .dateTime(LocalDateTime.of(2024, 9, 1, 14, 0))
                .game(Game.builder()
                        .sequenceOrder(1)
                        .local(teams.get(0))
                        .visitor(teams.get(1))
                        .build())
                .build();
        penya = entityManager.persistAndFlush(penya);
        quiniela = entityManager.persistAndFlush(quiniela);
    }

    @Test
    void savePenyaQuiniela() {
        PenyaQuiniela penyaQuiniela = PenyaQuiniela.builder()
                .id(PenyaQuinielaId.builder()
                        .penyaId(penya.getId())
                        .quinielaId(quiniela.getId())
                        .build())
                .doubles(penya.getDoubles())
                .triples(penya.getTriples())
                .build();
        penyaQuiniela = penyaQuinielaRepository.save(penyaQuiniela);
        assertThat(penyaQuiniela).isNotNull();
    }
}
