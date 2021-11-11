package com.example.dndcontroller.repos;

import com.example.dndcontroller.models.Spell;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SpellRepo extends CrudRepository<Spell, Integer> {

   Iterable<Spell> findAllBySchool(String school);
   Iterable<Spell> findAllByLevel(Integer level);
   Iterable<Spell> findBySpellNameContains(String name);
}
