package es.damarur.myquiniela.repository;

import es.damarur.myquiniela.domain.Penya;
import es.damarur.myquiniela.domain.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.time.Instant;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ContextConfiguration(classes = PenyaRepository.class)
public class PenyaRepositoryTest extends BaseRepositoryTest {

    private static final String EMAIL = "test@test.com";

    @Autowired
    private PenyaRepository penyaRepository;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = entityManager.persistAndFlush(Usuario.builder()
                .email(EMAIL)
                .passwordHash("some-hash")
                .active(true)
                .lastLogin(Instant.now())
                .build());
    }

    @Test
    void savePenya() {
        Penya penya = Penya.builder()
                .name("QUINIELISTAS FROM VALENCIA")
                .doubles(3)
                .triples(1)
                .admin(usuario.getId())
                .user(usuario.getId())
                .build();
        penya = penyaRepository.save(penya);
        assertThat(penya.getId()).isNotNull();
    }
}
