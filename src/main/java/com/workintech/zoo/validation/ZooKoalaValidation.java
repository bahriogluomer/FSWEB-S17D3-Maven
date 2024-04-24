package com.workintech.zoo.validation;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ZooKoalaValidation {
    public static void isValid(Integer id){
        if (id==null || id<0) {
            throw new ZooException("Invalid ID" + id,HttpStatus.BAD_REQUEST );
        }
    }

    public static void checkKoalaExistence(Map<Integer, Koala> koalas, int id , boolean doesExist) {
        if (doesExist) {
            if(!koalas.containsKey(id)) {
                throw new ZooException("Koala with ID " + id + " does not exist", HttpStatus.NOT_FOUND);
            }
        }
    }

    public static void checkKoalaWeight(Double weight) {
        if (weight<0 || weight == null) {
            throw new ZooException("Invalid weight" + weight,HttpStatus.BAD_REQUEST );
        }
    }
}
