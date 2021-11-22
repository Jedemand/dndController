package com.example.dndcontroller.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;
import java.util.Map;


@Entity(name="complexchar")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ComplexChar extends Actor {

    String charClass;

    @ElementCollection
    Map<String, String> classAbilities;
    @ElementCollection
    Map<String, String> raceAbilities;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Item> inventory;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Armor> armory;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Weapon> arsenal;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Spell> spellBook;

}
