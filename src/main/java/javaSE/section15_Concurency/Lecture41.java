package javaSE.section15_Concurency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Lecture41 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Runnable processor = new MessageProcessor(2);
        executorService.execute(processor);
        Runnable processor1 = new MessageProcessor(3);
        executorService.execute(processor1);
        Runnable processor2 = new MessageProcessor(4);
        executorService.execute(processor2);
        Runnable processor3 = new MessageProcessor(5);
        executorService.execute(processor3);

        executorService.shutdown();

        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Submitted all task...");
    }

}


class MessageProcessor implements Runnable {
    private int message;

    public MessageProcessor(int message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " [RECEIVED] Message = " + message);
        respondToMessage();//make thread sleep to simulate doing work
        System.out.println(Thread.currentThread().getName() + " (DONE) Processing Message = " + message);
    }

    private void respondToMessage(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Unable to process message "+message);
        }
    }
}