package es.damarur.myquiniela.repository;

import es.damarur.myquiniela.domain.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.time.Instant;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = UserRepository.class)
public class UsuarioRepositoryTest extends BaseRepositoryTest {

    private static final String EMAIL = "test@test.com";

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        Usuario usuario = Usuario.builder()
                .email(EMAIL)
                .passwordHash("some-hash")
                .active(true)
                .lastLoginDate(Instant.now())
                .build();
        userRepository.save(usuario);
    }

    @Test
    void findUserByEmailLikeIgnoreCase() {
        Optional<Usuario> user = userRepository.findUserByEmailLikeIgnoreCase(EMAIL);
        assertThat(user).isPresent();
    }
}
