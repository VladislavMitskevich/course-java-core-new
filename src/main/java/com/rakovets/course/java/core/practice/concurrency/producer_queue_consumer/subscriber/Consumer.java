package com.rakovets.course.java.core.practice.concurrency.producer_queue_consumer.subscriber;

import com.rakovets.course.java.core.practice.concurrency.producer_queue_consumer.utils.FileCreator;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable, ISleep {
    private final Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        FileCreator newFile = new FileCreator("output.txt");
        System.out.println("Working...");

        while (queue.peek() != null) {
            int time = queue.poll();

            threadGoToSleep(time);
            newFile.write("I slept " + time + " second(s)");
        }

        newFile.write("...");
        threadGoToSleep(1);
    }

    @Override
    public void threadGoToSleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
