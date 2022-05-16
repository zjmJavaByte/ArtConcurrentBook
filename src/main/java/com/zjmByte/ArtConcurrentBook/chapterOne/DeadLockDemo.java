package com.zjmByte.ArtConcurrentBook.chapterOne;


/**
 * 死锁
 *
 * @author tengfei.fangtf
 * @version $Id: DeadLockDemo.java, v 0.1 2015-7-18 ÏÂÎç10:08:28 tengfei.fangtf Exp $
 */
public class DeadLockDemo {

    /** AËø */
    private static String A = "A";
    /** BËø */
    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("1");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        });
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }

}

