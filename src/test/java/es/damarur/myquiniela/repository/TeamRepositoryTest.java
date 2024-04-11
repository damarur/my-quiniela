package es.damarur.myquiniela.repository;

import es.damarur.myquiniela.domain.Team;
import es.damarur.myquiniela.util.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = TeamRepository.class)
class TeamRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private TeamRepository teamRepository;

    @BeforeEach
    void setUp() {
        Team team = TestData.getTeam("VALENCIA");
        teamRepository.save(team);
    }

    @Test
    void findTeamsByNameIsLikeIgnoreCase() {
        List<Team> teams = teamRepository.findTeamsByNameIsLikeIgnoreCase("VALENCIA");
        assertThat(teams).hasSize(1);
    }

}
