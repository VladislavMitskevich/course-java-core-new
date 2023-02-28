package com.rakovets.course.java.core.practice.concurrency.producer_queue_consumer.utils;

import com.rakovets.course.java.core.practice.concurrency.producer_queue_consumer.publisher.Producer;
import com.rakovets.course.java.core.practice.concurrency.producer_queue_consumer.subscriber.Consumer;

import java.util.Queue;
import java.util.concurrent.*;

public class TreadUtils {
    private Integer threadsAmount;
    private final Queue<Integer> queue;

    public TreadUtils(Integer threadsAmount) {
        this.threadsAmount = threadsAmount;
        this.queue = new PriorityBlockingQueue<>();
    }

    public void start() {
        ExecutorService executor = Executors.newFixedThreadPool(threadsAmount);

        Future<?> future = executor.submit(new Producer(queue)); //extends
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        for (; threadsAmount > 0; threadsAmount--) {
            executor.execute(new Consumer(queue));
        }

        executor.shutdown();
    }
}
