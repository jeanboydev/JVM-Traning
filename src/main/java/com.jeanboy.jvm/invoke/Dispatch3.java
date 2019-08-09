package com.jeanboy.jvm.invoke;

public class Dispatch3 {

    static class Ball {
    }

    static class Water {
    }


    static class Father {
        public void play(Ball ball) {
            System.out.println("Father play ball");
        }

        public void play(Water water) {
            System.out.println("Father play water");
        }
    }

    static class Son extends Father {
        @Override
        public void play(Ball ball) {
            System.out.println("Son play ball");
        }

        @Override
        public void play(Water water) {
            System.out.println("Son play water");
        }
    }


    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.play(new Ball());
        son.play(new Water());
    }
}
