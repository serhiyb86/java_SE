package javaSE.section11_Collections;

import java.util.*;

public class Lecture28 {
    public static void main(String[] args) {
        System.out.println("Some method for collections");
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(100);
        numbers.add(200);
        numbers.add(45);
        numbers.add(1000);
        numbers.add(1000);
        numbers.add(1000);
        numbers.add(1000);
        numbers.add(10);
        numbers.add(1000);


        ArrayList<Integer> numbers2 = new ArrayList<>();
        numbers2.add(10);
        numbers2.add(1000);


numbers.removeAll(numbers2);
       // numbers.addAll(numbers2);


        System.out.println(numbers);
        System.out.println(numbers.isEmpty());
        numbers2.clear();
        System.out.println(numbers2);
        System.out.println();

        System.out.println("HashSet to List and Sort");

        HashSet<Integer> numbersHashset = new HashSet<>();
        numbersHashset.add(100);
        numbersHashset.add(200);
        numbersHashset.add(45);
        numbersHashset.add(1000);
        numbersHashset.add(1000);
        numbersHashset.add(1000);
        numbersHashset.add(1000);
        numbersHashset.add(10);
        numbersHashset.add(1000);

        ArrayList<Integer> list = new ArrayList<>(numbersHashset);

        Collections.sort(list);
        System.out.println(list);
        System.out.println();
        System.out.println("Sort strings");

        HashSet<String> strings = new HashSet<>();

        strings.add("Random");
        strings.add("Tooth Brush");
        strings.add("Computer");
        strings.add("Cloth");
        strings.add("Hello");
ArrayList<String> stringArrayList = new ArrayList<>(strings);
        System.out.println("Not sorted strings -> "+stringArrayList);
        Collections.sort(stringArrayList);
        System.out.println("Sorted strings -> "+stringArrayList);
        System.out.println();

        System.out.println("Sorting of objects");
        HashSet<Employee> employees = new HashSet<>();
        employees.add(new Employee("Mike", 3500,"Accounting"));
        employees.add(new Employee("Paul", 3000,"Admin"));
        employees.add(new Employee("Peter", 4000,"IT"));
        employees.add(new Employee("Angel", 2000,"Maintain"));

        ArrayList<Employee> employeesList = new ArrayList<>(employees);

        System.out.println("Not sorted employees -> "+employeesList);
        Collections.sort(employeesList);
        System.out.println("Sorted employees -> "+employeesList);

Collections.sort(employeesList, new Comparator<Employee>() {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getSalary()< o2.getSalary())
                    return -1;
        if (o1.getSalary()== o2.getSalary())
            return 0;
        return 1;
    }
});

        System.out.println("Sorted salary -> "+employeesList);

    }
}
