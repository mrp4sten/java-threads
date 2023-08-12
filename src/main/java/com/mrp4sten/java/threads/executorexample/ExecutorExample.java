package com.mrp4sten.java.threads.executorexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {
  public static void main(String[] args) {
    ExecutorService executor = Executors.newSingleThreadExecutor();

    Runnable task = () -> {
      System.out.println("Starting Task");
      try {
        System.out.println("Thread name: " + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(3);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        e.printStackTrace();
      }
      System.out.println("Task ends");
    };

    executor.submit(task);
    executor.shutdown();
  }

}
