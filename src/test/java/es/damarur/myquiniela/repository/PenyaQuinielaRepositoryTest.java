package es.damarur.myquiniela.repository;

import es.damarur.myquiniela.domain.*;
import es.damarur.myquiniela.util.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

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

    private Penya penya;
    private Quiniela quiniela;

    @BeforeEach
    void setUp() {
        entityManager.persistAndFlush(TestData.getTeam("REAL MADRID"));
        entityManager.persistAndFlush(TestData.getTeam("VALENCIA"));
        List<Team> teams = StreamSupport
                .stream(teamRepository.findAll().spliterator(), false)
                .toList();
        Usuario usuario = entityManager.persistAndFlush(TestData.getUsuario());
        penya = entityManager.persistAndFlush(TestData.getPenya(usuario, usuario));
        quiniela = entityManager.persistAndFlush(TestData.getQuiniela(teams));
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
