package com.zjmByte.ArtConcurrentBook.chapterFive;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    public static void main(String[] args) {
        LockSupportTest lockSupportTest = new LockSupportTest();
        lockSupportTest.test();
    }

    private void test(){
        LockSupport.parkNanos(this,TimeUnit.SECONDS.toNanos(100));
    }

}
