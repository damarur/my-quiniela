package es.damarur.myquiniela.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Quiniela {

    @EmbeddedId
    private QuinielaId id;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ElementCollection(targetClass = Game.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "quiniela_games", joinColumns = @JoinColumn(name = "quiniela_id"))
    @Column(name = "games")
    private List<Game> games;
}
