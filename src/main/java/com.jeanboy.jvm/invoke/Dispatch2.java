package com.jeanboy.jvm.invoke;

/**
 * 重写
 */
public class Dispatch2 {

    static class Animal {
        public void sound() {
            System.out.println("Animal...");
        }
    }

    static class Dog extends Animal {
        @Override
        public void sound() {
            System.out.println("Dog wang...");
        }
    }

    static class Cat extends Animal {
        @Override
        public void sound() {
            System.out.println("Cat miao...");
        }

    }


    public static void main(String[] args) {
        Animal a = new Dog();
        Animal b = new Cat();
        a.sound();
        b.sound();
    }
}
