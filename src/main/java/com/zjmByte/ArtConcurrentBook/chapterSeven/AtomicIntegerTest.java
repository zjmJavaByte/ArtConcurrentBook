package com.zjmByte.ArtConcurrentBook.chapterSeven;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerTest {

    static AtomicInteger ai = new AtomicInteger(1);
    static AtomicBoolean atomicBoolean = new AtomicBoolean(true);
    static AtomicChar atomicChar = new AtomicChar('a');

    static int[] value = new int[] { 1, 2 };
    static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
        atomicBoolean.getAndSet(false);
        //System.out.println(atomicChar.get());
        System.out.println(atomicIntegerArray.getAndSet(0, 5));
        System.out.println(atomicIntegerArray.get(0));
        System.out.println(value[0]);

    }

}
