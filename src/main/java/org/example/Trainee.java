package org.example;

public class Trainee {
    private String id;
    private String name;
    private String gender;
    private byte age;


    public Trainee() {};

    public Trainee(String id, String name, String gender, byte age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%-8s | %-20s | %-6s | %3d", id, name, gender, (int) age);
    }
}