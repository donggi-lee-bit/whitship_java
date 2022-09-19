package donggi.whiteship_java.week10.multithread_ex;

public class TestThread {

    public static void main(String[] args) {
        HelloWorld obj1 = new HelloWorld("Thread-1");
        obj1.start();

        HelloWorld obj2 = new HelloWorld("Thread-2");
        obj2.start();
    }

}
