package javaSE.section11_Collections;

import java.util.HashSet;

public class Lecture27 {
    public static void main(String[] args) {
        //set prevents duplicates, not ordered
        //LinkedHashSet maintains about order
        HashSet<Integer> values = new HashSet<>();
        values.add(12);
        values.add(43);
        values.add(15);
        values.add(67);
        values.add(43);
        values.add(12);

        for (Integer value : values) {
            System.out.println(value);
        }

        System.out.println();

        HashSet<Vehicle> vehicles = new HashSet<>();
        vehicles.add(new Vehicle("Honda", "accord", 1300, false));
        vehicles.add(new Vehicle("Honda", "accord", 1300, false));
        vehicles.add(new Vehicle("Jeep", "Wrangler", 25000, true));
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}
