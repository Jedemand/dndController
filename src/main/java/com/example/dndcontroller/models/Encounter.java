package com.example.dndcontroller.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity()
@Data
public class Encounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<ComplexChar> mainCharacters;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<SpellChar> spellMonsters;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<SimpleChar> monsters;

}
