package donggi.whiteship_java.week10.multithread_ex;

public class ThreadEx {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();

        int cnt = 1;
        int sum = 1;
        while(cnt <= 10) {
            System.out.println("main thread: " + sum * cnt);
            cnt++;
        }
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        int cnt = 0;
        char x = 'a';
        while(cnt <= 25) {
            System.out.println("new thread: " + (char) (x + cnt));
            cnt++;
        }

    }
}
