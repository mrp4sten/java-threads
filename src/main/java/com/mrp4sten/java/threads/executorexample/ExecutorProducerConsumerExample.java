package com.mrp4sten.java.threads.executorexample;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.mrp4sten.java.threads.syncexamples.Bakery;
import com.mrp4sten.java.threads.syncexamples.runnable.Consumer;
import com.mrp4sten.java.threads.syncexamples.runnable.Producer;

public class ExecutorProducerConsumerExample {
  public static void main(String[] args) {
    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

    System.out.println("=== Pool Size: " + executor.getPoolSize() + " ===");
    System.out.println("=== Task Queue Size: " + executor.getQueue().size() + " ===");

    Bakery bakery = new Bakery();
    Producer producer = new Producer(bakery);
    Consumer consumer = new Consumer(bakery);

    Future<?> producerFuture = executor.submit(producer);
    Future<?> consumerFuture = executor.submit(consumer);

    System.out.println("=== Pool Size: " + executor.getPoolSize() + " ===");
    System.out.println("=== Task Queue Size: " + executor.getQueue().size() + " ===");

    executor.shutdown();

    System.out.println("Continuing with main execution");
  }
}
