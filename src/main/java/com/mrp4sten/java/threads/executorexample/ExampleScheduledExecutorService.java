package com.mrp4sten.java.threads.executorexample;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExampleScheduledExecutorService {
  public static void main(String[] args) {
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
    System.out.println("Some Task from Main...");

    executor.schedule(() -> {
      try {
        TimeUnit.MILLISECONDS.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
        Thread.currentThread().interrupt();
      }
      System.out.println("Hello world task...");
    }, 0, TimeUnit.MILLISECONDS);

    System.out.println("Some other Task from Main...");
    executor.shutdown();
  }
}
