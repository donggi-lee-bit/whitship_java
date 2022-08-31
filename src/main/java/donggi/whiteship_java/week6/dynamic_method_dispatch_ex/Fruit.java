package donggi.whiteship_java.week6.dynamic_method_dispatch_ex;

public class Fruit {
    void m1() {
        System.out.println("Eat some Fruit");
    }
}

class Apple extends Fruit {
    @Override
    void m1() {
        System.out.println("Eat some Apple");
    }
}

class Banana extends Fruit {
    @Override
    void m1() {
        System.out.println("Eat some Banana");
    }
}

class Dispatch {
    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        Apple apple = new Apple();
        Banana banana = new Banana();


        Fruit ref;
        ref = fruit;
        ref.m1();

        ref = apple;
        ref.m1();

        ref = banana;
        ref.m1();
    }
}
