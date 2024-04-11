package es.damarur.myquiniela.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserBet {

    @EmbeddedId
    private UserBetId id;

    @Column(name = "bet")
    private String bet;

}
