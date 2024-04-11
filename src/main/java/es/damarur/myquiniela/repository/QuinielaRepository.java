package es.damarur.myquiniela.repository;

import es.damarur.myquiniela.domain.Quiniela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuinielaRepository extends JpaRepository<Quiniela, Integer> {
}
