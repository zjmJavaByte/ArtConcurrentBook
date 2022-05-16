package com.zjmByte.ArtConcurrentBook.chapterFive;

/**
 *
 */

import com.zjmByte.ArtConcurrentBook.chapterFour.SleepUtils;

import java.util.concurrent.locks.Lock;


/**
 * 10-11
 */
public class TwinsLockTest {

    public void test() {
        final Lock lock = new TwinsLock();
        class Worker extends Thread {
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
        // Æô¶¯10¸öÏß³Ì
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }
        // Ã¿¸ô1Ãë»»ÐÐ
        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }
    }
}

