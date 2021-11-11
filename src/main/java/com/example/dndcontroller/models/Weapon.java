package com.example.dndcontroller.models;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@Data
@Entity(name="weapon")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Weapon extends PickUp {
    String dice;
    String dmgType;

    @ElementCollection
    List<String> properties;

}
