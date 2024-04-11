package es.damarur.myquiniela.repository;

import es.damarur.myquiniela.domain.UserBet;
import es.damarur.myquiniela.domain.UserBetId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBetRepository extends CrudRepository<UserBet, UserBetId> {
}
