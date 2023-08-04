package com.mrp4sten.java.threads.examples;

public class ExampleThreadImplementsJava8 {
  public static void main(String[] args) throws InterruptedException {

    Thread main = Thread.currentThread();

    Runnable travel = () -> {
      for (int i = 0; i < 10; i++) {
        System.out.println(i + "-" + Thread.currentThread().getName());
        try {
          Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
          e.printStackTrace();
          Thread.currentThread().interrupt();
        }
      }
      System.out.println("Finally I'm going to travet to: " + Thread.currentThread().getName());
      System.out.println("Main State: " + main.getState());
    };

    Thread t1 = new Thread(travel, "Mauricio Island");
    Thread t2 = new Thread(travel, "New Zeland");
    Thread t3 = new Thread(travel, "Mexico");
    Thread t4 = new Thread(travel, "Canada");

    t1.start();
    t2.start();
    t3.start();
    t4.start();

    t1.join();
    t2.join();
    t3.join();
    t4.join();

    // Thread.sleep(10000);
    System.out.println("Continuing with main method execution: " + main.getName());
  }
}
