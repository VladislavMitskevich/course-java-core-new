package com.rakovets.course.java.core.practice.concurrency;

import com.rakovets.course.java.core.practice.concurrency.producer_queue_consumer.publisher.Producer;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class Demo {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityBlockingQueue<>();
        Producer producer = new Producer(queue);
    }
}
