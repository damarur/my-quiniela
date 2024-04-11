package es.damarur.myquiniela.repository;

import es.damarur.myquiniela.domain.Usuario;
import es.damarur.myquiniela.util.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = UserRepository.class)
public class UsuarioRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        Usuario usuario = TestData.getUsuario();
        userRepository.save(usuario);
    }

    @Test
    void findUserByEmailLikeIgnoreCase() {
        Optional<Usuario> user = userRepository.findUserByEmailLikeIgnoreCase(TestData.EMAIL);
        assertThat(user).isPresent();
    }
}
