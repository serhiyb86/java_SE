package javaSE.section15_Concurency;

import java.util.concurrent.ArrayBlockingQueue;

public class Lecture40 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> questionQueue = new ArrayBlockingQueue<Integer>(5);
        Thread t1 = new Thread(new Producer1(questionQueue));
        Thread t2 = new Thread(new Consumer1(questionQueue));
        t1.start();
        t2.start();
    }

}

class Producer1 implements Runnable {
    ArrayBlockingQueue<Integer> questionQueue;
    int questionNo;

    public Producer1(ArrayBlockingQueue<Integer> questionQueue) {
        this.questionQueue = questionQueue;
    }

    @Override
    public void run() {
while (true){
    try {
        synchronized (this){
            int nextQuestion= questionNo++;
            System.out.println("Got new Question: "+ nextQuestion);
            questionQueue.put(nextQuestion);
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

    }


}

class Consumer1 implements Runnable {

    ArrayBlockingQueue<Integer> questionQueue;

    public Consumer1(ArrayBlockingQueue<Integer> questionQueue) {
        this.questionQueue = questionQueue;
    }

    @Override
    public void run() {
while (true){
    try {
        Thread.sleep(1000);
        System.out.println("Answered question: "+ questionQueue.take());
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
    }
}