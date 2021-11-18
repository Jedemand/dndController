package com.example.dndcontroller.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name="simpleChar")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SimpleChar extends Actor{



}
