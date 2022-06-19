package com.customerManager.demo.entities;

import javax.persistence.*;

@Entity

public class customer {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;
    @Column(name = "FirstN")
    private String FirstName;
    @Column(name = "LastN")
    private String lastName;
    private int age;
    private char gender;
    private Boolean isActive;
    public customer() {
    }
    public customer(int id, String firstName, String lastName, int age, char gender, Boolean isActive) {
        this.id = id;
        this.FirstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.isActive = isActive;
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

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setLastName(String lastName) {
        this.lastName = this.lastName;
    }

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
