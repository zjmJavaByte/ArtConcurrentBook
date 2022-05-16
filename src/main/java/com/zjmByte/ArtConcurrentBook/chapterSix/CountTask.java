package com.zjmByte.ArtConcurrentBook.chapterSix;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Long> {


    private static final int THRESHOLD = 200000; // 阈值
    private int              start;
    private int              end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;

        // 如果任务足够小就计算任务
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //等待子任务执行完，并得到其结果
            long leftResult = leftTask.join();
            long rightResult = rightTask.join();
            //合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 生成一个计算任务，负责计算
        CountTask task = new CountTask(1, 400000000);

        // 执行一个任务
        Future<Long> result = forkJoinPool.submit(task);
        //判断是否有异常
        if (task.isCompletedAbnormally()){
            System.out.println(task.getException().getMessage());
        }
        try {
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
        }
    }
}
