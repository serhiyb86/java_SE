package javaSE.section15_Concurency;

import java.util.ArrayList;
import java.util.List;

public class Lecture39 {

    public static void main(String[] args) {

        List<Integer> questionList = new ArrayList<>();
        Thread t1 =new Thread(new Producer(questionList));
        Thread t2 =new Thread(new Consumer(questionList));
        t1.start();
        t2.start();

    }
}

class Consumer implements Runnable{

    List<Integer> questionList =null;
    final int LIMIT = 5;
    private int questionNo;


    public Consumer(List<Integer> questionList) {
        this.questionList = questionList;
    }

    public void answerQuestion() throws InterruptedException {
        synchronized (questionList){
            while (questionList.isEmpty()){
                System.out.println("No question to answer... Waiting for producer to get questions");
                questionList.wait();
            }
        }
        synchronized (questionList){
            Thread.sleep(2000);
            System.out.println("Answered Question: "+questionList.remove(0));
            questionList.notify();
        }
    }



    @Override
    public void run() {
        while (true){
            try {
                answerQuestion();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Producer implements Runnable{

    List<Integer> questionList =null;
    final int LIMIT = 5;
    private int questionNo;


    public Producer(List<Integer> questionList) {
        this.questionList = questionList;
    }

    public void readQuestion(int questionNo) throws InterruptedException {
        synchronized (questionList){
            while (questionList.size() == LIMIT){
                System.out.println("Question have piled up.. wait for answers");
                questionList.wait();
            }
        }
        synchronized (questionList){
            System.out.println("New Question: "+questionNo);
            questionList.add(questionNo);
            Thread.sleep(100);
            questionList.notify();
        }
    }



    @Override
    public void run() {
        while (true){
            try {
                readQuestion(questionNo++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}