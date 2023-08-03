package com.mrp4sten.java.threads.examples;

import com.mrp4sten.java.threads.examples.threads.NameThread;

public class ExampleThreadExtends {
  public static void main(String[] args) throws InterruptedException {

    Thread thread = new NameThread("Jhon Doe");
    Thread threadTwo = new NameThread("Leonardo Davinci");

    thread.start();
    threadTwo.start();

    // Thread.sleep(100);

    System.out.println(thread.getState());
    System.out.println(threadTwo.getState());

  }
}
