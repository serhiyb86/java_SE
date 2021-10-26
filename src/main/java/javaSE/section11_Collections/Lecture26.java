package javaSE.section11_Collections;

import java.util.ArrayList;
import java.util.List;

public class Lecture26 {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        animals.add("Lion");
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Bird");

        List<Vehicle> vehicles = new ArrayList<>(100);
        Vehicle vehicle = new Vehicle("Toyota", "camry", 15000, false);
        vehicles.add(new Vehicle("Honda", "accord", 1300, false));
        vehicles.add(vehicle);
        vehicles.add(new Vehicle("Jeep", "Wrangler", 25000, true));

        printElement(vehicles);
        System.out.println();
        printElement(animals);

    }

    public static void printElement(List list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
