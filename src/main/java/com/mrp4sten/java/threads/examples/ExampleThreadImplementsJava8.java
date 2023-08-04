package com.mrp4sten.java.threads.examples;

public class ExampleThreadImplementsJava8 {
  public static void main(String[] args) {

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
    };

    new Thread(travel, "Mauricio Island").start();
    new Thread(travel, "New Zeland").start();
    new Thread(travel, "Mexico").start();
    new Thread(travel, "Canada").start();
  }
}
