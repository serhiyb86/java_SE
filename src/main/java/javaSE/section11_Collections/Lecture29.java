package javaSE.section11_Collections;

import java.util.Map;
import java.util.TreeMap;

public class Lecture29 {
    public static void main(String[] args) {
        //Hashmap or LinkedHashMap(Ordered) or TreeMap(Sorted)
       // LinkedHashMap<String, String> dictionary = new LinkedHashMap<>();
        TreeMap<String, String> dictionary = new TreeMap<>();
        dictionary.put("Brave", "111111111111111  1111111111 1111");
        dictionary.put("Brilliant", "222222222 222222 2222222 2222");
        dictionary.put("Joy", "33 33 3333333333333333  333 3333");
        dictionary.put("Confidence", "444444 44 44 44444444444444");

        dictionary.put("Brilliant", "XXXXXXX");

        System.out.println("Keys from nap:");
        for (String s : dictionary.keySet()) {
            System.out.println(s);
        }
        System.out.println();
        System.out.println("Values from nap:");
        for (String s : dictionary.keySet()) {
            System.out.println(dictionary.get(s));
        }
        System.out.println();

        System.out.println("EntrySet from nap:");
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            System.out.println(entry);
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }


    }
}
