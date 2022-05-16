package com.zjmByte.ArtConcurrentBook.chapterFour;


public class Synchronized {
    public static void main(String[] args) {
        // ¶ÔSynchronized Class¶ÔÏó½øÐÐ¼ÓËø
        synchronized (Synchronized.class) {

        }
        // ¾²Ì¬Í¬²½·½·¨£¬¶ÔSynchronized Class¶ÔÏó½øÐÐ¼ÓËø
        m();
    }

    public static synchronized void m() {
    }
}

