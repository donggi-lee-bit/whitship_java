package donggi.whiteship_java.week6.super_ex;

public class Person {

    int age;

    Person() {
        System.out.println("Person class Constructor");
    }

    public Person(int age) {
        this.age = age;
        System.out.println("Person class Constructor with age");
    }
}

class Student extends Person {
    Student() {
        super(10);
//        super();
        System.out.println("Student class Constructor");
    }
}

class Test {
    public static void main(String[] args) {
        Student s = new Student();
        System.out.println("super class variable age is : " + s.age);
    }
}
