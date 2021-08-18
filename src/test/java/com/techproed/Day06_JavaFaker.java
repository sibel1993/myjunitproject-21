package com.techproed;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day06_JavaFaker {
    @Test
    public  void javaFakerTest(){
        //create faker object
        Faker faker=new Faker();
        String Fname =faker.name().firstName();
        String lname =faker.name().lastName();

        System.out.println(Fname);
        System.out.println(lname);
        System.out.println(faker.name().fullName());
        System.out.println(faker.name().title());
        System.out.println(faker.address().city());
    }
}
