package com.onmywayzhi.designpattern.statemachine;

public class GenericsFruits {

    public static void main(String[] args) {
        Apple apple = new Apple();
        People people = new People();

        MyGenericsTest<Fruit> genericsTest = new MyGenericsTest<>();
        //apple是Fruit的子类，所以这里可以
        genericsTest.show1(apple);
        //编译器会报错，因为泛型类型实参指定的是Fruit，而传入的实参类是People
        //genericsTest.show1(people);

        //使用这两个方法都可以成功
        genericsTest.show2(apple);
        genericsTest.show2(people);

        //使用这两个方法也都可以成功
        genericsTest.show3(apple);
        genericsTest.show3(people);

    }
}

class Fruit {
    public String toString() {
        return "fruit";
    }
}

class Apple extends Fruit {
    public String toString() {
        return "apple";
    }
}

class People implements Comparable {
    private int age;

    public People(int age) {
        this.age = age;
    }

    public String toString() {
        return "people";
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Integer) {
            return ((Integer) o).compareTo(age);
        }
        throw new RuntimeException("error");
    }
}

class MyGenericsTest<T>  {
    public void show1(T t) {
        System.out.println(t.toString());
    }

    //在泛型类中声明了一个泛型方法，使用泛型E，这种泛型E可以为任意类型。可以类型与T相同，也可以不同。
    //由于泛型方法在声明的时候会声明泛型<E>，因此即使在泛型类中并未声明泛型，编译器也能够正确识别泛型方法中识别的泛型。
    public <E> void show2(E t) {
        System.out.println(t.toString());
    }

    //在泛型类中声明了一个泛型方法，使用泛型T，注意这个T是一种全新的类型，可以与泛型类中声明的T不是同一种类型。
    public <T> void show3(T t){
        System.out.println(t.toString());
    }

    public <T> void printMsg( T... args){
        for(T t : args){
            System.out.println("Generics test, t is " + t);
        }
    }

    public static <T extends Comparable<T>> int compare(T t1, T t2){
        return t1.compareTo(t2);
    }

    public static void main(String[] args) {
        People
        compare()
    }
}
