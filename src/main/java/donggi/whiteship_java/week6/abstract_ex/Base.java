package donggi.whiteship_java.week6.abstract_ex;

abstract class Base {

    public Base() {
        System.out.println("Base class constructor");
    }

    abstract void fun();
}

class Derived extends Base {

    public Derived() {
        System.out.println("Derived class constructor");
    }

    void fun() {
        System.out.println("Derived fun() called");
    }
    
}

class Main {

    public static void main(String[] args) {
        Base b = new Derived();
        b.fun();
    }
}
