package es.damarur.myquiniela.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Audit {

    @Column(name = "created_date", updatable = false)
    private Instant createdDate;

    @Column(name = "modified_date")
    private Instant modifiedDate;

    @PrePersist
    public void prePersist() {
        if (this.createdDate == null) {
            createdDate = Instant.now();
        }
        if (this.modifiedDate == null) {
            modifiedDate = Instant.now();
        }
    }

    @PreUpdate
    public void preUpdate() {
        modifiedDate = Instant.now();
    }

}
