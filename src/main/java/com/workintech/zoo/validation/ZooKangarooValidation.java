package com.workintech.zoo.validation;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ZooKangarooValidation {
    public static void isValid(Integer id){
        if (id==null || id<0) {
            throw new ZooException("Invalid ID" + id,HttpStatus.BAD_REQUEST );
        }
    }

    public static void checkKangarooExistence(Map<Integer, Kangaroo> kangaroos, int id , boolean doesExist) {
        if (doesExist) {
            if(!kangaroos.containsKey(id)) {
                throw new ZooException("Kangaroo with ID " + id + " does not exist", HttpStatus.NOT_FOUND);
            }
        }
    }

    public static void checkKangarooWeight(Double weight) {
        if (weight<0 || weight == null) {
            throw new ZooException("Invalid weight" + weight,HttpStatus.BAD_REQUEST );
        }
    }
}
