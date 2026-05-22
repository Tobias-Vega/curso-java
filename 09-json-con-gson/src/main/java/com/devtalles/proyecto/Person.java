package com.devtalles.proyecto;

public class Person {
    private String name;
    private Integer age;
    private String email;
    private boolean student;

    public Person(String name, Integer age, boolean student) {
        this.name = name;
        this.age = age;
        this.student = student;
    }

    public Person(String name, Integer age, String email, boolean student) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.student = student;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isStudent() {
        return student;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", student=" + student +
                '}';
    }
}
