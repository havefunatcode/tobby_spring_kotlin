package com.example.tobby_spring_kotlin.user.dao;

public class SingleTonTest {
    private static SingleTonTest INSTANCE;
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private SingleTonTest() {

    }
    private SingleTonTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static synchronized SingleTonTest getInstance() {
        if (INSTANCE == null) INSTANCE = new SingleTonTest();
        return INSTANCE;
    }

}
