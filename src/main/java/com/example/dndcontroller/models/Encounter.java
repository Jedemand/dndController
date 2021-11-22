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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    List<ComplexChar> characterList;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    List<SimpleChar> mobList;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    List<SpellChar> spellcasterList;

}
