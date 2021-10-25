package javaSE.section11;

import java.util.ArrayList;
import java.util.LinkedList;


public class Lecture25 {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("world");
        words.add("50");

        String word = words.get(2);
        System.out.println(word);

        System.out.println();

        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(100);
        numbers.add(200);
        numbers.add(45);
        numbers.add(1000);
        numbers.removeFirst();

        for (Integer number : numbers) {
            System.out.println(number);
        }

    }
}
