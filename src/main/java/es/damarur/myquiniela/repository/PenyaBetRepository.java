package es.damarur.myquiniela.repository;

import es.damarur.myquiniela.domain.PenyaBet;
import es.damarur.myquiniela.domain.PenyaBetId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenyaBetRepository extends CrudRepository<PenyaBet, PenyaBetId> {
}
