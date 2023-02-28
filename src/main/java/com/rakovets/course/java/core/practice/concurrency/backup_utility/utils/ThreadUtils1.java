package com.rakovets.course.java.core.practice.concurrency.backup_utility.utils;

import com.rakovets.course.java.core.practice.concurrency.backup_utility.job.ThreadCopier;

import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtils1 {
    private final Path source;
   // private Integer nThreads;
    private final  Path destination;

    public ThreadUtils1(Path source, Path destination) {
        this.source = source;
        this.destination = destination;
        //this.nThreads = nThreads;
    }

    public void start() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        ThreadCopier threadCopier = new ThreadCopier(source,destination);
        executor.execute(threadCopier);
/*
        if (source != null) {
            Future<?> future = executor.submit(threadCopier);
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e.getMessage());
            }
        }

        for (; nThreads > 0; nThreads--) {
            if (destination != null) {
                executor.execute(threadCopier);
            }
        }*/

        executor.shutdown();
    }
}
