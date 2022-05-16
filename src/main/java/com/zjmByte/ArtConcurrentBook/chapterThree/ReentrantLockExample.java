package com.zjmByte.ArtConcurrentBook.chapterThree;

import com.zjmByte.ArtConcurrentBook.TestClass;
import lombok.experimental.UtilityClass;

import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockExample {

    int a = 0;
    ReentrantLock lock = new ReentrantLock();

    public void writer() {
        lock.lock(); //»ñÈ¡Ëø
        try {
            a++;
        } finally {
            lock.unlock(); //ÊÍ·ÅËø
        }
    }

    public void reader() {
        lock.lock(); //»ñÈ¡Ëø
        try {
            int i = a;
            //¡­¡­
        } finally {
            lock.unlock(); //ÊÍ·ÅËø
        }
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
    }
}

