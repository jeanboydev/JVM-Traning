package com.jeanboy.jvm.invoke;

public class Dispatch {

    static class Animal {

    }

    static class Dog extends Animal {

    }

    static class Cat extends Animal {

    }

    public static void sound(Animal a) {
        System.out.println("Animal...");
    }

    public static void sound(Dog a) {
        System.out.println("Dog wang...");
    }

    public static void sound(Cat a) {
        System.out.println("Cat miao...");
    }

    public static void main(String[] args) {
        Animal a = new Dog();
        Animal b = new Cat();
        sound(a);
        sound(b);
    }
}
