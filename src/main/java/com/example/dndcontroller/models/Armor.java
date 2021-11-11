package com.example.dndcontroller.models;


import lombok.Data;

import javax.persistence.Entity;

@Entity(name="armor")
@Data
public class Armor extends PickUp {

    String armorClass;
    String strength;
    String stealth;
    String category;
    String donTime;
    String doffTime;
}
