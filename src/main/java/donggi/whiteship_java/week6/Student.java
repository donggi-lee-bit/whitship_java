package donggi.whiteship_java.week6;

class Person
{
    void message()
    {
        System.out.println("This is person class");
    }
}

/* Subclass Student */
public class Student extends Person
{
    void message()
    {
        System.out.println("This is student class");
    }
    void display()
    {
        message();
        super.message();
    }
}

class Test
{
    public static void main(String args[])
    {
        Student s = new Student();
        s.display();
    }
}
