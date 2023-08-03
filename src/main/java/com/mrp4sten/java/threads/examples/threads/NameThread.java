package com.mrp4sten.java.threads.examples.threads;

public class NameThread extends Thread {

  public NameThread(String name) {
    super(name);
  }

  @Override
  public void run() {
    System.out.println("Start thread method <run> from thread: " + getName());

    for (int i = 0; i < 10; i++) {
      System.out.println(this.getName());
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
        Thread.currentThread().interrupt();
      }
    }

    System.out.println("Thread ending");
  }

}
