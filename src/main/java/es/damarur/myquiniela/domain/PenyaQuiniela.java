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
public class PenyaQuiniela {

    @EmbeddedId
    private PenyaQuinielaId id;

    @Column(name = "doubles")
    private Integer doubles;

    @Column(name = "triples")
    private Integer triples;

    @Column(name = "hits")
    private Integer hits;

    @Column(name = "result")
    private Double result;
}
