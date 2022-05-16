package com.zjmByte.ArtConcurrentBook.chapterEight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BankWaterService  {



    private static CyclicBarrier c = new CyclicBarrier(4, new Test());

    private Executor executor = Executors.newFixedThreadPool(4);

    private static ConcurrentHashMap<String, Integer> sheetBankWaterCount = new
            ConcurrentHashMap<String, Integer>();


    private void count() {
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            executor.execute(()->{
                sheetBankWaterCount
                        .put(Thread.currentThread().getName(), 1);
                System.out.println(finalI);
                try {
                    c.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
    }


    public static void main(String[] args) {
        System.out.println("第一次");
        BankWaterService bankWaterCount1 = new BankWaterService();
        bankWaterCount1.count();
    }


    static class Test implements Runnable{

        @Override
        public void run() {
            int result = 0;
// 汇总每个sheet计算出的结果
            for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
                result += sheet.getValue();
            }
// 将结果输出
            sheetBankWaterCount.put("result", result);
            System.out.println(result);
        }
    }
}
