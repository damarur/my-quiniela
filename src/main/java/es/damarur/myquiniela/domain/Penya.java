package es.damarur.myquiniela.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Penya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ElementCollection(targetClass = Integer.class)
    @CollectionTable(name = "penya_admins", joinColumns = @JoinColumn(name = "penya_id"))
    @Singular
    private List<Integer> admins;

    @ElementCollection(targetClass = Integer.class)
    @CollectionTable(name = "penya_users", joinColumns = @JoinColumn(name = "penya_id"))
    @Singular
    private List<Integer> users;

    @Column(name = "doubles")
    private Integer doubles;

    @Column(name = "triples")
    private Integer triples;
}
