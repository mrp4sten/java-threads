package com.mrp4sten.java.threads.examples.runnable;

public class TaskTravel implements Runnable {

  private String name;

  public TaskTravel(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(i + "-" + name);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
        Thread.currentThread().interrupt();
      }
    }
    System.out.println("Finally I'm going to travet to: " + name);
  }
}
