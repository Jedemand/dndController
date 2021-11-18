package com.example.dndcontroller.repos.services.Impl;

import com.example.dndcontroller.Exceptions.FieldNotFoundException;
import com.example.dndcontroller.Exceptions.ItemNotFoundException;
import com.example.dndcontroller.models.Weapon;
import com.example.dndcontroller.repos.WeaponRepo;
import com.example.dndcontroller.repos.services.WeaponService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class WeaponServiceImpl implements WeaponService {

    WeaponRepo weaponRepo;

    public WeaponServiceImpl(WeaponRepo weaponRepo) {
        this.weaponRepo = weaponRepo;
    }

    @Override
    public Iterable<Weapon> findByName(String name) {
        return weaponRepo.findAllByNameContains(name);
    }

    @Override
    public Iterable<Weapon> findByRarity(String rarity) {
        return weaponRepo.findByRarity(rarity);
    }

    @Override
    public Iterable<Weapon> findAll() {
        return weaponRepo.findAll();
    }

    @Override
    public Weapon findById(Integer id) {
        return weaponRepo.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(String.valueOf(id)));
    }

    @Override
    public Weapon saveWeapon(Weapon weapon) {
        return weaponRepo.save(weapon);
    }

    @Override
    public Weapon updateWeapon(Weapon weapon) {
        return weaponRepo.save(weapon);
    }

    @Override
    public Weapon patchWeapon(Map<String, Object> updates, Integer id) {

        Weapon patchedWeapon = weaponRepo.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(String.valueOf(id)));

        updates.forEach((k, o) -> {
            try{
                //Create Lists of this and super fields
                Field[] fields = patchedWeapon.getClass().getDeclaredFields();
                Field[] superFields = patchedWeapon.getClass().getSuperclass().getDeclaredFields();

                //Combine into a single List
                List<Field> combinedFields = new ArrayList<>(Arrays.asList(fields));
                combinedFields.addAll(Arrays.asList(superFields));

                //Cycle through combinedFields
                for(int i = 0; i < combinedFields.size(); i++)
                {
                    //check to see if the field = k
                    if(combinedFields.get(i).getName().equals(k)){
                        combinedFields.get(i).setAccessible(true);
                        combinedFields.get(i).set(patchedWeapon, o);
                    }

                }
            }catch( IllegalAccessException ex){
                throw  new FieldNotFoundException(k);
            }
        });

        return weaponRepo.save(patchedWeapon);
    }

    @Override
    public void deleteWeapon(Weapon weapon) {
        weaponRepo.delete(weapon);
    }

    @Override
    public void deleteWeapon(Integer weapon) {
        weaponRepo.deleteById(weapon);
    }
}
