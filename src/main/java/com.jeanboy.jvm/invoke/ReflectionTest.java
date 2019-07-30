package com.jeanboy.jvm.invoke;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

    static class Test {
        public String haha;

        public String hello(int a) {
            System.out.println("hello...");
            return "haha";
        }
    }

    public static void main(String[] args) {
        try {
            Class<?> clazz = Test.class;
            Object obj = clazz.newInstance();
            // 获取某个类或接口声明的所有方法，
            // 包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法
            Method[] declaredMethods = clazz.getDeclaredMethods();
            // 获取某个类的所有公用（public）方法，包括其继承类的公用方法
            Method[] methods = clazz.getMethods();
            // 获取某个类一个特定的方法，其中第一个参数为方法名称，
            // 后面的参数为方法的参数对应 Class 的对象
            Method helloMethod = clazz.getMethod("hello", int.class);
            helloMethod.invoke(obj,1);
            System.out.println("=====getDeclaredMethods====");
            for (Method method : declaredMethods) {
                System.out.println(method);
            }
            System.out.println("=====getMethods====");
            for (Method method : methods) {
                System.out.println(method);
            }
            System.out.println("=====getMethod====");
            System.out.println(helloMethod);

            // 访问所有已声明的成员变量，但不能得到其父类的成员变量
            Field[] declaredFields = clazz.getDeclaredFields();
            // 访问公有的成员变量
            Field[] publicFields = clazz.getFields();
            // 访问特定的成员变量
            Field field = clazz.getField("haha");
            System.out.println(declaredFields);
            System.out.println(publicFields);
            System.out.println(field);

        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | NoSuchFieldException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
