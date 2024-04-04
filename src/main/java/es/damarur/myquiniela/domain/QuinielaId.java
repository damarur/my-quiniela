package es.damarur.myquiniela.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

@Embeddable
@Builder
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class QuinielaId implements Serializable {

    @Column(name = "id")
    String value;
}
