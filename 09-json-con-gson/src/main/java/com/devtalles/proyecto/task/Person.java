package com.devtalles.proyecto.task;

import java.util.List;

public class Person {
    private String name;
    private Integer age;
    private boolean active;
    private List<String> hobbies;

    public Person(String name, Integer age, boolean active, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.active = active;
        this.hobbies = hobbies;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", active=" + active +
                ", hobbies=" + hobbies +
                '}';
    }
}
