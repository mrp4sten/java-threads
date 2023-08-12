package com.mrp4sten.java.threads.syncexamples;

public class Bakery {
  private String bread;
  private boolean available;

  public synchronized void bake(String mass) {
    while (available) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
        Thread.currentThread().interrupt();
      }
    }

    this.bread = mass;
    System.out.println("BAKING:" + this.bread);
    this.available = true;
    notifyAll();
  }

  public synchronized String eat() {
    while (!available) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
        Thread.currentThread().interrupt();
      }
    }

    System.out.println("EATING BREAD DELICIOUS");
    this.available = false;
    notifyAll();
    return bread;
  }
}
