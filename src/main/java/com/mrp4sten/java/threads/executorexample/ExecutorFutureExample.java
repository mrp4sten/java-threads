package com.mrp4sten.java.threads.executorexample;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorFutureExample {
  public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
    ExecutorService executor = Executors.newFixedThreadPool(3);

    Callable<String> task = () -> {
      System.out.println("Starting Task");
      try {
        System.out.println("Thread name: " + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(3);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        e.printStackTrace();
      }
      System.out.println("Task ends");
      return "Some important result from the task";
    };

    Callable<Integer> taskTwo = () -> {
      System.out.println("Starting Task two");
      TimeUnit.SECONDS.sleep(3);
      return 10;
    };

    Future<String> result = executor.submit(task);
    Future<String> resultTwo = executor.submit(task);
    Future<Integer> resultThree = executor.submit(taskTwo);

    executor.shutdown();

    System.out.println("Continuing with main execution");

    while (!(result.isDone() && resultTwo.isDone() && resultThree.isDone())) {
      System.out.println(String.format("Result 1: %s, Resutl 2: %s, Result 3: %s",
          result.isDone() ? "Ends" : "In progress",
          resultTwo.isDone() ? "Ends" : "In progress",
          resultThree.isDone() ? "Ends" : "In progress"));
      TimeUnit.MILLISECONDS.sleep(1000);
    }

    System.out.println("Get result from task: " + result.get(5, TimeUnit.SECONDS));
    System.out.println("Ending Tasks: " + result.isDone());
  }
}
