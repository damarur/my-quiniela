package es.damarur.myquiniela.repository;

import es.damarur.myquiniela.domain.*;
import es.damarur.myquiniela.util.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ContextConfiguration(classes = PenyaQuinielaRepository.class)
public class PenyaQuinielaRepositoryTest extends BaseRepositoryTest {

    private static final String EMAIL = "test@test.com";

    @Autowired
    private PenyaQuinielaRepository penyaQuinielaRepository;

    private Penya penya;
    private Quiniela quiniela;

    @BeforeEach
    void setUp() {
        List<Team> teams = new ArrayList<>();
        teams.add(entityManager.persistAndFlush(TestData.getTeam("REAL MADRID")));
        teams.add(entityManager.persistAndFlush(TestData.getTeam("VALENCIA")));
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
