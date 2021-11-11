package com.example.dndcontroller.helpers;

import com.example.dndcontroller.Exceptions.FieldNotFoundException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class classPatch {
    public static Object patchClass(Map<String, Integer> updates, Object object){
        updates.forEach((k, o) -> {
            System.out.println(k + ":" + o);

            try{
                //use reflection to get accessor
                Field nameField = object.getClass().getDeclaredField(k);
                nameField.setAccessible(true);
                nameField.set(object, o);
            }catch (NoSuchFieldException | IllegalAccessException e){
                //handle problems
                throw new FieldNotFoundException(k);
            }
        });

        return object;
    }

    public static Object patchSuper(Map<String, Integer> updates, Object object){
        updates.forEach((k, o) -> {
            try{
                //get class and super fields
                Field[] classFields = object.getClass().getDeclaredFields();
                Field[] superFields = object.getClass().getSuperclass().getDeclaredFields();

                //combo!
                List<Field> combinedFields = new ArrayList<>(Arrays.asList(classFields));
                combinedFields.addAll(Arrays.asList(superFields));

                //check each item
                for (Field combinedField : combinedFields) {
                    //check to see if the field = k
                    if (combinedField.getName().equals(k)) {
                        combinedField.setAccessible(true);
                        combinedField.set(object, o);
                    }
                }
            }catch (IllegalAccessException | FieldNotFoundException ex){
                throw new FieldNotFoundException(k);
            }
        });
        return object;
    }
}
