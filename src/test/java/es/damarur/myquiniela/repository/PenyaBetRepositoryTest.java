package es.damarur.myquiniela.repository;

import es.damarur.myquiniela.domain.*;
import es.damarur.myquiniela.util.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ContextConfiguration(classes = PenyaBetRepository.class)
public class PenyaBetRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private PenyaBetRepository penyaBetRepository;

    private Penya penya;
    private Quiniela quiniela;

    @BeforeEach
    void setUp() {
        List<Team> teams = new ArrayList<>();
        teams.add(entityManager.persistAndFlush(TestData.getTeam("REAL MADRID")));
        teams.add(entityManager.persistAndFlush(TestData.getTeam("VALENCIA")));
        Usuario usuario = entityManager.persistAndFlush(TestData.getUsuario());
        penya = entityManager.persistAndFlush(TestData.getPenya(usuario, usuario));
        quiniela = entityManager.persistAndFlush(TestData.getQuiniela(teams));
    }

    @Test
    void saveGroupBet() {
        PenyaBet penyaBet = PenyaBet.builder()
                .id(PenyaBetId.builder()
                        .penyaId(penya.getId())
                        .quinielaId(quiniela.getId())
                        .gameId(quiniela.getGames().get(0).getGameId())
                        .build())
                .bet("X2")
                .build();
        penyaBet = penyaBetRepository.save(penyaBet);
        assertThat(penyaBet).isNotNull();
    }
}
