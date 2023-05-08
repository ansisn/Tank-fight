package com.hspjy.Thread;

public class ThreadMethodExercise {
    public static void main(String[] args) {
         Thread thread = new Thread(new Thread_());
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("hi");
                Thread.sleep(1000);
                if (i == 4){
                    thread.start();
                    thread.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
class Thread_ implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("hello");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
