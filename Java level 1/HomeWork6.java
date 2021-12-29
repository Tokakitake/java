/**
 * Java level 1 HomeWork 6
 * @author Muratov Nail
 * @version 29.12.2021
 */

class HomeWork6 {

    public static void main(String[] args) {
        Cat cat = new Cat(200);
        Dog dog = new Dog(500, 10);
        IAnimal[] animals = {cat, dog};
        for (IAnimal a : animals) {
            System.out.println(a);
            System.out.println(a.run(100));
            System.out.println(a.run(200));
            System.out.println(a.run(700));
            System.out.println(a.swim(5));
            System.out.println(a.swim(10));
        }
    }
}

class Cat extends Animal {
    Cat(int runLimit, int swimLimit) {
        super(runLimit, swimLimit);
    }

    Cat(int runLimit) {
        super(runLimit, -1);
    }

    @Override
    public String swim(int distance) {
        return getClassName() + " can't swim ";
    }
}

class Dog extends Animal {
    Dog(int runLimit, int swimLimit) {
        super(runLimit, swimLimit);
    }
}

interface IAnimal {
    String run(int distance);
    String swim(int distance);
}

abstract class Animal implements IAnimal {
    private int runLimit;
    private int swimLimit;
    private String className;

    Animal(int runLimit, int swimLimit) {
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        className = getClass().getSimpleName();
    }

    public String getClassName() {
        return className;
    }

    @Override
    public  String swim(int distance) {
        if(distance > swimLimit) {
            return className + " couldn't swim " + distance;
        } else {
            return className + " can swim " + distance;
        }
    }

    @Override
    public  String run(int distance) {
        if(distance > runLimit) {
            return className + " couldn't run " + distance;
        } else {
            return className + " can run " + distance;
        }
    }

    @Override
    public String toString() {
        return className + " runLimit: " + runLimit + ", swimLimit: " + swimLimit;
    }
}