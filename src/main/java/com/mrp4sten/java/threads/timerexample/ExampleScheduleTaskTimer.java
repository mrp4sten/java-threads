package com.mrp4sten.java.threads.timerexample;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class ExampleScheduleTaskTimer {
  public static void main(String[] args) {

    AtomicInteger counterAtomic = new AtomicInteger(3);
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {

      @Override
      public void run() {
        int i = counterAtomic.getAndDecrement();
        if (i > 0) {
          System.out.println(
              "Task" + i + " do it at: " + new Date() +
                  "Thread name: " + Thread.currentThread().getName());
        } else {
          System.out.println("Time ends");
          timer.cancel();
        }

      }

    }, 5000, 10000);

    System.out.println("We schedule a task for 5 more minutes");
  }
}
