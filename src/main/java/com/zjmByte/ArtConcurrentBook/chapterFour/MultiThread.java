package com.zjmByte.ArtConcurrentBook.chapterFour;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {

    public static void main(String[] args) {
        // »ñÈ¡JavaÏß³Ì¹ÜÀíMXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // ²»ÐèÒª»ñÈ¡Í¬²½µÄmonitorºÍsynchronizerÐÅÏ¢£¬½ö½ö»ñÈ¡Ïß³ÌºÍÏß³Ì¶ÑÕ»ÐÅÏ¢
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // ±éÀúÏß³ÌÐÅÏ¢£¬½ö´òÓ¡Ïß³ÌIDºÍÏß³ÌÃû³ÆÐÅÏ¢
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo);
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }
    }
}

