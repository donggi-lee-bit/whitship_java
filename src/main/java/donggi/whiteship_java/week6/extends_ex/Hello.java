package donggi.whiteship_java.week6.extends_ex;

public class Hello extends HelloParents {

    public int plusAge() {
        Hello h = new Hello();
        return ++h.age;
    }

}
