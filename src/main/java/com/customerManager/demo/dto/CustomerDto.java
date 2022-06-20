package com.customerManager.demo.dto;


import org.springframework.stereotype.Component;

@Component
public class CustomerDto {

        private int userId;
        private String firstName;
//        private String lastName;
        private int age;
        private char gender;



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

//    public String getLastName() {
//        return lastName;
//    }

//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "customerDto{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
