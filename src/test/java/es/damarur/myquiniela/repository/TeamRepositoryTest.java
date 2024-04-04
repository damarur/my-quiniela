package es.damarur.myquiniela.repository;

import es.damarur.myquiniela.domain.Team;
import es.damarur.myquiniela.domain.TeamId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = TeamRepository.class)
class TeamRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private TeamRepository teamRepository;

    private static final TeamId teamId1 = TeamId.builder().value(UUID.randomUUID().toString()).build();

    @BeforeEach
    void setUp() {
        Team team = Team.builder()
                .id(teamId1)
                .name("NEW TEAM")
                .build();
        teamRepository.save(team);
    }

    @Test
    void findById() {
        Optional<Team> team = teamRepository.findById(teamId1);
        assertThat(team).isPresent();
    }

    @Test
    void findTeamsByNameIsLikeIgnoreCase() {
        List<Team> teams = teamRepository.findTeamsByNameIsLikeIgnoreCase("VALENCIA");
        assertThat(teams).hasSize(1);
    }

}
