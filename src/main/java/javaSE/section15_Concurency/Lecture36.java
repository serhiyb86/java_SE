package javaSE.section15_Concurency;

public class Lecture36 {
    public static void main(String[] args) {
        System.out.println("Starting Thread1");
        MyThread task = new MyThread();
        task.setName("Thread A");
        task.start();

        System.out.println("Starting Thread2");
        MyThread task2 = new MyThread();
        task2.setName("Thread B");
        task2.start();

        System.out.println();
        System.out.println("Interface Runnable");
        System.out.println("Starting Runnable Thread1");
        Thread thread = new Thread(new MyThreadRunnable("Runnable Thread A"));
        thread.start();


        System.out.println("Starting Runnable Thread2");
        Thread thread1 = new Thread(new MyThreadRunnable("Runnable Thread B"));
        thread1.start();

        System.out.println("Starting Runnable AnonymousClass Thread1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() + " - number: " + i);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                }
            }
        }});
        thread2.setName("Runnable Anonymous class Thread ");
        thread2.start();

    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - number: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class MyThreadRunnable implements Runnable {

    private String threadName;

    public MyThreadRunnable(String threadName) {
        this.threadName=threadName;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(threadName);
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - number: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
