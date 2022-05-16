package com.zjmByte.ArtConcurrentBook.chapterFive;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

   static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    public static void main(String[] args) {
        System.out.println(BaseSystem_2((1 << 16) - 1));
        System.out.println(65537 & 65535);

        Lock read = readWriteLock.readLock();
        Lock write = readWriteLock.writeLock();
        write.lock();
        try {

        }catch (Exception e){

        }finally {
            write.unlock();
        }

        read.lock();
        try {

        }catch (Exception e){

        }finally {
            read.unlock();
        }


    }


    public static String BaseSystem_2(int Scanner){
        String base="";
        int sys=0;
        while(true){
            sys=Scanner%2;
            Scanner=Scanner/2;
            base=sys+base;
            if(Scanner<2){
                sys=Scanner%2;
                base=sys+base;
                break;
            }
        }
        return base;
    }



}
