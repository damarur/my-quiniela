package es.damarur.myquiniela.repository;

import es.damarur.myquiniela.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Usuario, Integer> {

    Optional<Usuario> findUserByEmailLikeIgnoreCase(String email);
}
