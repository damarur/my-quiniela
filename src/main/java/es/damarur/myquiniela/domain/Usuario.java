package es.damarur.myquiniela.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "active")
    private boolean active;

    @Embedded
    @Builder.Default
    private Audit audit = new Audit();

    @Column(name = "last_login")
    private Instant lastLogin;

}
