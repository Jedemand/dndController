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

    @ElementCollection
    List<String> encounterList;

}
