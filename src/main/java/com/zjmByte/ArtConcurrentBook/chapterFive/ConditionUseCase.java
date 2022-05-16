package com.zjmByte.ArtConcurrentBook.chapterFive;

import com.zjmByte.ArtConcurrentBook.chapterFour.SleepUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 10-20
 */
public class ConditionUseCase {
    static Lock      lock      = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static CountDownLatch count = new CountDownLatch(2);

    public static void conditionWait() throws InterruptedException {
        lock.lock();
        try {
            condition.await();
        } finally {
            lock.unlock();
        }
    }

    public static void conditionSignal() throws InterruptedException {
        lock.lock();
        try {
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("conditionWait-开始");
                    conditionWait();
                    System.out.println("conditionWait-结束");
                    count.countDown();
                } catch (Exception e) {

                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("conditionSignal-开始");
                    conditionSignal();
                    System.out.println("conditionSignal-结束");
                    count.countDown();
                } catch (Exception e) {

                }
            }
        });
        thread1.start();
        SleepUtils.second(2);
        thread2.start();
        count.await();
    }
}

