package es.damarur.myquiniela.repository;

import es.damarur.myquiniela.domain.Team;
import es.damarur.myquiniela.domain.TeamId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends CrudRepository<Team, TeamId> {

    List<Team> findTeamsByNameIsLikeIgnoreCase(String name);
}
