package es.damarur.myquiniela.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class PenyaBetId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "penya_id")
    private Integer penyaId;

    @Column(name = "quiniela_id")
    private Integer quinielaId;

    @Column(name = "game_id")
    private Integer gameId;
}
