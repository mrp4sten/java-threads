package com.mrp4sten.java.threads.executorexample;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorFutureExample {
  public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
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

    Future<?> result = executor.submit(task);
    executor.shutdown();
    System.out.println("Result is done: " + result.isDone());
    System.out.println("Result get: " + result.get(5, TimeUnit.SECONDS));
    System.out.println("Result is done: " + result.isDone());
  }
}
