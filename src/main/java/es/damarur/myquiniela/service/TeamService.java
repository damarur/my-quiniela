package es.damarur.myquiniela.service;

import es.damarur.myquiniela.domain.Team;
import es.damarur.myquiniela.exception.NotFoundException;
import es.damarur.myquiniela.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public Team findTeamByName(String name) {
        List<Team> teams = teamRepository.findTeamsByNameIsLikeIgnoreCase(name);
        return teams.stream().findFirst().orElseThrow(() -> NotFoundException.teamName(name));
    }

}
