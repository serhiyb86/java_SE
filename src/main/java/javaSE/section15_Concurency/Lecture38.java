package javaSE.section15_Concurency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Lecture38 {
    public static void main(String[] args) throws InterruptedException {
        InventoryManager manager = new InventoryManager();
        Thread task1 = new Thread(new Runnable() {
            @Override
            public void run() {
                manager.populateSoldProducts();
            }
        });

        Thread task2 = new Thread(new Runnable() {
            @Override
            public void run() {
                manager.displaySoldProducts();
            }
        });

        task1.start();
        Thread.sleep(2000);
        //wait until task1 thread joins the main thread and only then it's going to start task2
       // task1.join();

        task2.start();



    }
}


class Product{
    int id;
    String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class InventoryManager{
    //ThreadSafe CopyOnWriteArrayList collection
    List<Product> soldProductList = new CopyOnWriteArrayList<>();
List<Product> purchaseProductList = new ArrayList<>();

public void populateSoldProducts() {
    for (int i = 0; i < 1000; i++) {
        Product prod = new Product(i, "product_"+i);
        soldProductList.add(prod);
        System.out.println("ADDED: "+prod);
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public void displaySoldProducts(){
        for (Product product : soldProductList) {
            System.out.println("Print the sold "+product);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}