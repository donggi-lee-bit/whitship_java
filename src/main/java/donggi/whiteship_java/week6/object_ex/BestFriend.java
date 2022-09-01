package donggi.whiteship_java.week6.object_ex;

// Java program to Illustrate
// working of toString() method

// Main class
class BestFriend {

    // Member attributes of this class
    String name;
    int age;
    String college;
    String course;
    String address;

    // Constructor of this class
    BestFriend(String name, int age, String college,
        String course, String address)
    {
        // This variable refers to current instance itself
        this.name = name;
        this.age = age;
        this.college = college;
        this.course = course;
        this.address = address;
    }

    // Method of this class
    // Main driver method
    public static void main(String[] args)
    {

        // Creating an object of this class
        // Custom attributes been passed as in arguments
        BestFriend b = new BestFriend(
            "Gulpreet Kaur", 21, "BIT MESRA", "M.TECH",
            "Kiriburu");

        // Print and display commands to illustrate
        // toString() method as both will print the same
        // Print the object
        System.out.println(b);
        // Print the object but implicitly using toString()
        // method
        System.out.println(b.toString());
    }
}
