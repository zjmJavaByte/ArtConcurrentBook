package com.zjmByte.ArtConcurrentBook.chapterFive;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockUseCase {
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        lock.lock();
        try {
        } finally {
            lock.unlock();
        }
    }

}
