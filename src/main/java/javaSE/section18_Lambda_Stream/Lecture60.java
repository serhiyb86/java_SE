package javaSE.section18_Lambda_Stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lecture60 {
    public static void main(String[] args) throws IOException {
        IntStream
                .range(1, 10)
                .skip(5) //skip 5 elements
                .forEach((x) -> System.out.println(x));

        System.out.println();

        String[] items = {"car", "computer", "toothpaste", "box", "pencil", "tent", "door", "toy"};
        Stream.of(items)
                .filter((x) -> x.startsWith("t"))
                .sorted()
                .forEach((x) -> System.out.print(x + " "));
        System.out.println();

        Arrays.stream(new int[]{2, 4, 6, 8, 10})
                .map((x) -> x * x)
                //      .forEach(System.out::println);
                .average()
                .ifPresent((n) -> System.out.println(n));
        System.out.println();

        Arrays.asList("Car", "Computer", "Toothpaste", "Box", "Pencil", "Tent", "Door", "Toy")
                .stream()
                .map(x -> x.toLowerCase())
                .filter(x -> x.startsWith("c"))
                .sorted()
                .forEach(System.out::println);
        System.out.println();
        System.out.println("Stream from file:");

        Files.lines(Paths.get("file/wordFile.txt"))
                .sorted()
                .filter(x -> x.length() > 6)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Stream from file2:");

        List<String> list = Files.lines(Paths.get("file/wordFile.txt"))
                .sorted()
                .filter(x -> x.contains("th"))
                .collect(Collectors.toList());

        list.forEach(x -> System.out.print(x + " "));
        System.out.println();

        System.out.println("Stream from file3:");
        Stream<String> lines = Files.lines(Paths.get("file/stockDataCsv.txt"));

        long count = lines
                .map(x -> x.split(", "))
                .filter(x -> x.length > 3)

                .count();
        System.out.println(count + " good rows.");
        lines.close();
        System.out.println();
        System.out.println("Stream from file4:");
        Stream<String> lines2 = Files.lines(Paths.get("file/stockDataCsv.txt"));

         lines2
                .map(x -> x.split(", "))
                .filter(x -> x.length > 3)
                 .filter(x->Integer.parseInt(x[1].trim())>15)
                 .forEach(x-> System.out.println(x[0].trim()+" "+x[2].trim()+" "+x[3].trim()));




    }


}
