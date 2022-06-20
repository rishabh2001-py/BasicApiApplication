package com.customerManager.demo.entities;

import javax.persistence.*;

@Entity

public class Customer {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;
    @Column(name = "FirstN")
    private String FirstName;

    private int age;
    private char gender;
    private Boolean isActive;
    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

//    public String getLastName() {
//        return lastName;
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
//    public void setLastName(String lastName) {
//        this.lastName = this.lastName;
//    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }


}
