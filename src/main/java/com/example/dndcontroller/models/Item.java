package com.example.dndcontroller.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity(name="item")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Item extends PickUp{
}
