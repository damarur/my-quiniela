package es.damarur.myquiniela.repository;

import es.damarur.myquiniela.domain.PenyaQuiniela;
import es.damarur.myquiniela.domain.PenyaQuinielaId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenyaQuinielaRepository extends CrudRepository<PenyaQuiniela, PenyaQuinielaId> {
}
