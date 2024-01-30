package ru.test.psychology.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "maniacs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Maniac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "maniac")
    private EManiac name;
}
