package es.damarur.myquiniela.repository;

import es.damarur.myquiniela.domain.Penya;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenyaRepository extends CrudRepository<Penya, Integer> {
}
