package javaSE.section18_Lambda_Stream;





        import java.util.Arrays;
        import java.util.List;
        import java.util.Objects;
        import java.util.function.Consumer;
        import java.util.function.Function;
        import java.util.function.Predicate;

public class Lecture59 {

    public static void main(String[] args) {

        List<Car> cars = Arrays.asList(
                new Car("Honda", "Accord", "Red", 22300),
                new Car("Honda", "Civic", "Blue", 17700),
                new Car("Toyota", "Land Cruiser", "White", 48500),
                new Car("Toyota", "Corolla", "Black", 19200),
                new Car("Toyota", "Camry", "Blue", 24000),
                new Car("Nissan", "Sentra", "White", 17300),
                new Car("Mitsubishi", "Lancer", "White", 20000),
                new Car("Jeep", "Wrangler", "Red", 24500)
        );


        printCarsPriceRange(cars, 18000, 22000);
        System.out.println();
        printCarByColor(cars, "Red");
        System.out.println();

        Consumer<Car> carConsumer = (c)-> System.out.println(c);
        carConsumer.accept(new Car("Test","Test2", "t3", 5555));

//        System.out.println("Printing cars between price 18000 and 22000");
//        printCars(cars, new CarCondition() {
//
//            @Override
//            public boolean test(Car c) {
//                return c.getPrice() >= 18000 && c.getPrice() <= 22000;
//            }
//        });
//        System.out.println();
//        System.out.println("Printing cars that are blue");
//        printCars(cars, new CarCondition() {
//
//            @Override
//            public boolean test(Car c) {
//                return c.getColor().equals("Blue");
//            }
//
//        });
//        System.out.println();
        ////////////////////////////////////////////////////////////////////
        System.out.println();
        System.out.println("Function interface");
        Function<Car, String> priceAndColor = (c) -> " price = " + c.getPrice() + " color = " + c.getColor();
        String stringCar = priceAndColor.apply(cars.get(0));
        System.out.println(stringCar);




        System.out.println("Printing cars between price 18000 and 22000");
        printCars(cars, (c) ->
            c.getPrice() >= 18000 && c.getPrice() <= 22000
        );

        System.out.println("Print blue cars");
        printCars(cars, (c) -> c.getColor().equals("Blue"));

        System.out.println("My invoke using interface");
        printCars(cars, c -> c.getPrice() < 18000 & c.getPrice() > 10000);


    }

//    public static void printCars(List<Car> cars, CarCondition condition) {
//        for(Car c: cars) {
//            if(condition.test(c)) {
//                c.printCar();
//            }
//        }
//    }


        public static void printCarsPriceRange (List < Car > cars,int low, int high){
            for (Car c : cars) {
                if (low <= c.getPrice() & c.getPrice() <= high) {
                    c.printCar();
                }
            }
        }


        public static void printCarByColor (List < Car > cars, String color){
            for (Car c : cars) {
                if ( c.getColor().equals(color)) {
                    c.printCar();
                }
            }
        }







    public static void printCars(List<Car> cars, Predicate<Car> predicate) {
        for(Car c: cars) {
            if(predicate.test(c)) {
                c.printCar();
            }
        }
    }
    }

@FunctionalInterface
interface CarCondition {
     boolean test(Car c);
}

class Car{
    String make, model, color;
    int price;

    public Car(String make, String model, String color, int price) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getPrice() == car.getPrice() && Objects.equals(getMake(), car.getMake()) && Objects.equals(getModel(), car.getModel()) && Objects.equals(getColor(), car.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMake(), getModel(), getColor(), getPrice());
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

    public void printCar() {
        System.out.println(this);
    }
}

