package com.test.thread.concurrency;

import com.test.thread.concurrency.forkjoinpool.FolderProcessor;

import java.io.PrintStream;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ConcurrencyTester {
    public static void main(String[] args) {

        //testForkJoinPool();
    }

//    private static void testForkJoinPool(){
//        System.out.println("Test");
//        ForkJoinPool pool = new ForkJoinPool();
//        var allCps = new FolderProcessor("C:\\Users\\kotiys\\workspace\\all-cps", "java");
//        var osb = new FolderProcessor("C:\\Users\\kotiys\\workspace\\OSB", "java");
//        pool.execute(allCps);
//        pool.execute(osb);
//        do{
//            System.out.printf("******************************************\n");
//            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
//            System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
//            System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
//            System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
//            System.out.printf("******************************************\n");
//            try
//            {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
//        }while (!allCps.isDone() || !osb.isDone());
//
//        pool.shutdown();
//        List<String> results = allCps.join();
//        System.out.println("Test");
//        System.out.printf("all-cps: %d files found.\n", results.size());
//        results = osb.join();
//        System.out.printf("osb: %d files found.\n", results.size());
//    }
}
