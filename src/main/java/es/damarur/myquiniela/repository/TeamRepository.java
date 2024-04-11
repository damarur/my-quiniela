package es.damarur.myquiniela.repository;

import es.damarur.myquiniela.domain.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {

    List<Team> findTeamsByNameIsLikeIgnoreCase(String name);
}
