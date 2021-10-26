package javaSE.section15_Concurency;

public class Lecture35 {
    public static void main(String[] args) {

        Task task = new Task();
        task.start();

        System.out.println("Hello world...");
        Task task2 = new Task();
        task2.start();
    }
}
class Task extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.print(Thread.currentThread().getName());
            System.out.println(" number: "+i);
        }
    }
}