package es.damarur.myquiniela.repository;

import es.damarur.myquiniela.domain.Quiniela;
import es.damarur.myquiniela.domain.Team;
import es.damarur.myquiniela.util.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ContextConfiguration(classes = QuinielaRepository.class)
public class QuinielaRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private QuinielaRepository quinielaRepository;
    @Autowired
    private TeamRepository teamRepository;

    private List<Team> teams = new ArrayList<>();

    @BeforeEach
    void setUp() {
        entityManager.persistAndFlush(TestData.getTeam("REAL MADRID"));
        entityManager.persistAndFlush(TestData.getTeam("VALENCIA"));
        teams = StreamSupport
                .stream(teamRepository.findAll().spliterator(), false)
                .toList();
    }

    @Test
    void save() {
        Quiniela quiniela = TestData.getQuiniela(teams);
        Quiniela storedQuiniela = quinielaRepository.saveAndFlush(quiniela);
        assertThat(storedQuiniela.getId()).isEqualTo(quiniela.getId());
    }
}
