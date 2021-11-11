package com.example.dndcontroller.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Spell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String spellName;

    Integer level;
    String school;
    String castingTime;
    String castRange;
    String components;
    String duration;

    String spellDescription;
}
