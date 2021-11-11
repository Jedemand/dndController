package com.example.dndcontroller.models;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Data
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer actorId;

    String name;

    Integer initiative;
    Integer armor;
    Integer health;
    String speed;
    Integer challenge;
    String size;
    String alignment;
    String race;
    String charClass;

    Integer strength;
    Integer dexterity;
    Integer constitution;
    Integer intelligence;
    Integer wisdom;
    Integer charisma;

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

    String senses;

    @ElementCollection
    Map<String, String> specialAbility;

    @ElementCollection
    Map<String, String> actions;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Item> inventory;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Armor> armory;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Weapon> arsenal;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Spell> spellBook;





}
