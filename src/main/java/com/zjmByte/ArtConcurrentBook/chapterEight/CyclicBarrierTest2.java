package com.zjmByte.ArtConcurrentBook.chapterEight;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest2 {

    //用于在线程到达屏障时，优先执行 barrierAction ，方便处理更复杂的业务场景
    static CyclicBarrier c = new CyclicBarrier(2, new A());

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(1);
            try {
                c.await();
            } catch (Exception e) {

            }

        }).start();

        System.out.println(2);
        try {
            c.await();
        } catch (Exception e) {

        }

    }

    static class A implements Runnable {

        @Override
        public void run() {
            System.out.println(3);
        }

    }

}

