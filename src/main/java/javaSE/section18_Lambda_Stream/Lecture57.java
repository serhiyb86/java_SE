package javaSE.section18_Lambda_Stream;

public class Lecture57 {
    public static void main(String[] args) {

        Walkable walkable = () -> System.out.println("walking robot");
        walkable.walk();

        walker(walkable);

        Walkable aBlockOfCode = () -> {
            System.out.println("Custom object walking ....");
            System.out.println("the object tripped...");
        };
        System.out.println();
        walker(aBlockOfCode);
        System.out.println();
        walker(() -> System.out.println("Hello world!!!!"));

    }

    public static void walker(Walkable walkable) {
        walkable.walk();
    }
}

interface Walkable {
    void walk();
}

