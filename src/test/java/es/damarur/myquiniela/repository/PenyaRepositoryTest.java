package es.damarur.myquiniela.repository;

import es.damarur.myquiniela.domain.Penya;
import es.damarur.myquiniela.domain.Usuario;
import es.damarur.myquiniela.util.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ContextConfiguration(classes = PenyaRepository.class)
public class PenyaRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private PenyaRepository penyaRepository;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = entityManager.persistAndFlush(TestData.getUsuario());
    }

    @Test
    void savePenya() {
        Penya penya = TestData.getPenya(usuario, usuario);
        penya = penyaRepository.save(penya);
        assertThat(penya.getId()).isNotNull();
    }
}
