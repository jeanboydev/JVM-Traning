package com.jeanboy.jvm.invoke;

public class Dispatch {

    static class Animal { }

    static class Dog extends Animal { }

    static class Cat extends Animal { }

    public void sound(Animal a) {
        System.out.println("Animal...");
    }

    public void sound(Dog a) {
        System.out.println("Dog wang...");
    }

    public void sound(Cat a) {
        System.out.println("Cat miao...");
    }

    public static void main(String[] args) {
        Animal a = new Dog();
        Animal b = new Cat();
        Dog c = new Dog();
        Dispatch dispatch = new Dispatch();
        dispatch.sound(a);
        dispatch.sound(b);
        dispatch.sound((Animal) c);
    }
}
