package donggi.whiteship_java.week6;

interface one {

    void print_geek();

}

interface two {

    void print_for();

}

interface three extends one, two {
}

class Child implements three {

    @Override
    public void print_geek() {

    }

    @Override
    public void print_for() {

    }
}

public class Main {

    public static void main(String[] args) {
        Child child = new Child();
        child.print_geek();
        child.print_for();
        child.print_geek();
    }
}
