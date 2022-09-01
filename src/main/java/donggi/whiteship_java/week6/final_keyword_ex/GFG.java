package donggi.whiteship_java.week6.final_keyword_ex;

// Java Program to demonstrate Different
// Ways of Initializing a final Variable

// Main class
public class GFG {

    final int THRESHOLD = 5;
    final int CAPACITY;
    final int MINIMUM;
    static final double PI = 3.141592653589793;
    static final double EULERCONSTANT;

    {
        CAPACITY = 25;
    }

    // static initializer block for
    // initializing EULERCONSTANT
    static {
        EULERCONSTANT = 2.3;
    }

    public GFG() {
        MINIMUM = -1;
    }

    public static void main(String[] args) {
        final int a;
        a = 10;
        System.out.println(a);

        int[] arr = new int[]{1, 2, 3};
        for (final int i : arr) {
            System.out.println(i);
        }
    }
}
