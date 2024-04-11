package es.damarur.myquiniela.util;

import es.damarur.myquiniela.domain.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

public class TestData {

    public static final String EMAIL = "test@test.com";

    public static Penya getPenya(Usuario admin, Usuario user) {
        return Penya.builder()
                .name("QUINIELISTAS FROM VALENCIA")
                .doubles(3)
                .triples(1)
                .admin(admin.getId())
                .user(user.getId())
                .build();
    }

    public static Quiniela getQuiniela(List<Team> teams) {
        return Quiniela.builder()
                .title("My first Quiniela")
                .description("Jornada 1 - 01/09/2024 - 14:00")
                .dateTime(LocalDateTime.of(2024, 9, 1, 14, 0))
                .game(Game.builder()
                        .sequenceOrder(1)
                        .local(teams.get(0))
                        .visitor(teams.get(1))
                        .build())
                .build();
    }

    public static Team getTeam(String name) {
        return Team.builder().name(name).build();
    }

    public static Usuario getUsuario() {
        return Usuario.builder()
                .email(EMAIL)
                .passwordHash("some-hash")
                .active(true)
                .lastLogin(Instant.now())
                .build();
    }
}
