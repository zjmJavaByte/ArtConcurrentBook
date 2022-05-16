package com.zjmByte.ArtConcurrentBook.chapterEight;

import com.zjmByte.ArtConcurrentBook.chapterFour.SleepUtils;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 *
 * 两者的区别：
 * CountDownLatch 主要用来解决一个线程等待多个线程的场景，可以类比旅游团团长要等待所有游客到齐才能去下一个景点
 * 而 CyclicBarrier 是一组线程之间的相互等待，可以类比几个驴友之间的不离不弃，共同到达某个地方，再继续出发，这样反复
 */
public class CyclicBarrierTest4 {


    private static Executor executor = Executors.newFixedThreadPool(4);


    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);


    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {

            try {
                System.out.println(Thread.currentThread().getName() + "第一回合");
                SleepUtils.second(5);
                cyclicBarrier.await();

                System.out.println(Thread.currentThread().getName() + "第二回合");
                SleepUtils.second(5);
                cyclicBarrier.await();

                System.out.println(Thread.currentThread().getName() + "第三回合");
                SleepUtils.second(5);
                cyclicBarrier.await();
            } catch (Exception e) {

            }


        });

        Thread thread2 = new Thread(() -> {

            try {
                System.out.println(Thread.currentThread().getName() + "第一回合");
                SleepUtils.second(5);
                cyclicBarrier.await();

                System.out.println(Thread.currentThread().getName() + "第二回合");
                SleepUtils.second(5);
                cyclicBarrier.await();

                System.out.println(Thread.currentThread().getName() + "第三回合");
                SleepUtils.second(5);
                cyclicBarrier.await();
            } catch (Exception e) {

            }


        });
        thread1.setName("线程一");
        thread2.setName("线程二");

        thread1.start();
        thread2.start();
    }

}
