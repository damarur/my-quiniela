package es.damarur.myquiniela.repository;

import es.damarur.myquiniela.domain.Game;
import es.damarur.myquiniela.domain.Quiniela;
import es.damarur.myquiniela.domain.QuinielaId;
import es.damarur.myquiniela.domain.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ContextConfiguration(classes = QuinielaRepository.class)
public class QuinielaRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private QuinielaRepository quinielaRepository;
    @Autowired
    private TeamRepository teamRepository;

    private static final QuinielaId quinielaId = QuinielaId.builder().value(UUID.randomUUID().toString()).build();
    private List<Team> teams = new ArrayList<>();

    @BeforeEach
    void setUp() {
        teams = StreamSupport
                .stream(teamRepository.findAll().spliterator(), false)
                .toList();
    }

    @Test
    void save() {
        Quiniela quiniela = Quiniela.builder()
                .id(quinielaId)
                .title("My first Quiniela")
                .description("Jornada 1 - 01/09/2024 - 14:00")
                .dateTime(LocalDateTime.of(2024, 9, 1, 14, 0))
                .game(Game.builder()
                        .local(teams.get(0))
                        .visitor(teams.get(1))
                        .secuenceOrder(1)
                        .build())
                .build();
        Quiniela storedQuiniela = quinielaRepository.saveAndFlush(quiniela);
        assertThat(storedQuiniela.getId()).isEqualTo(quiniela.getId());
    }
}
