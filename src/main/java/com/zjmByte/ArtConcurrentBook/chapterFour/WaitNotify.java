package com.zjmByte.ArtConcurrentBook.chapterFour;

/**
 *
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 6-11
 */
public class WaitNotify {
    static boolean flag = true;
    static Object  lock = new Object();

    public static void main(String[] args) throws Exception {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);

        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {
        public void run() {
            // ¼ÓËø£¬ÓµÓÐlockµÄMonitor
            synchronized (lock) {
                // µ±Ìõ¼þ²»Âú×ãÊ±£¬¼ÌÐøwait£¬Í¬Ê±ÊÍ·ÅÁËlockµÄËø
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. wait @ "
                                + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                }
                // Ìõ¼þÂú×ãÊ±£¬Íê³É¹¤×÷
                System.out.println(Thread.currentThread() + " flag is false. running @ "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {
        public void run() {
            // ¼ÓËø£¬ÓµÓÐlockµÄMonitor
            synchronized (lock) {
                // »ñÈ¡lockµÄËø£¬È»ºó½øÐÐÍ¨Öª£¬Í¨ÖªÊ±²»»áÊÍ·ÅlockµÄËø£¬
                // Ö±µ½µ±Ç°Ïß³ÌÊÍ·ÅÁËlockºó£¬WaitThread²ÅÄÜ´Ówait·½·¨ÖÐ·µ»Ø
                System.out.println(Thread.currentThread() + " hold lock. notify @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);
            }
            // ÔÙ´Î¼ÓËø
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again. sleep @ "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);
            }
        }
    }

}

