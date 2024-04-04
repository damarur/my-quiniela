package es.damarur.myquiniela.domain;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Game {

    @Column(name = "order")
    private Integer order;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "local_team_id")
    private Team local;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visitor_team_id")
    private Team visitor;

    @Column(name = "local_goals")
    private Integer localGoals;

    @Column(name = "visitor_goals")
    private Integer visitorGoals;

}
