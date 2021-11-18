package com.example.dndcontroller.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer actorId;

    String name;

    Integer initiative;
    Integer armor;
    Integer health;
    Integer minMod;
    Integer maxMod;
    String speed;
    Double challenge;
    String size;
    String alignment;
    String race;

    Integer strength;
    Integer dexterity;
    Integer constitution;
    Integer intelligence;
    Integer wisdom;
    Integer charisma;

    @ElementCollection
    Map<String, Integer> savingThrows;
    @ElementCollection
    Map<String, Integer> skills;
    @ElementCollection
    List<String> damageResist;
    @ElementCollection
    List<String> damageImmune;
    @ElementCollection
    List<String> conditionalImmune;
    @ElementCollection
    List<String> languages;

    @ElementCollection
    Map<String, Integer> senses;

    @ElementCollection
    Map<String, String> specialAbility;

    @ElementCollection
    Map<String, String> actions;
}
