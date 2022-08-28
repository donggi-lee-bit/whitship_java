package donggi.whiteship_java.week6.extends_ex;

public class Tv {
    boolean power;
    int channel;

    void power() {
        power = !power;

    }
    void channelUp() {
        ++channel;
    }
    void channelDown() {
        --channel;
    }

    static class CaptionTv extends Tv {
        boolean caption;

        void displayCation(String text) {
            if (caption) {
                System.out.println(text);
            }
        }
    }
}
