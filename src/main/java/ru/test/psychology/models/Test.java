package ru.test.psychology.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tests")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date")
    private long date;

    @Column(name = "a")
    private int a;

    @Column(name = "b")
    private int b;

    @Column(name = "c")
    private int c;

    @Column(name = "d")
    private int d;

    @Column(name = "e")
    private int e;

    @Column(name = "f")
    private int f;

    @Column(name = "g")
    private int g;

    @Column(name = "h")
    private int h;

    @Column(name = "i")
    private int i;

    @Column(name = "j")
    private int j;

    @ManyToMany(
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "tests_maniacs",
            joinColumns = @JoinColumn(name = "test_id"),
            inverseJoinColumns = @JoinColumn(name = "maniac_id")
    )
    private List<Maniac> maniacs;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
