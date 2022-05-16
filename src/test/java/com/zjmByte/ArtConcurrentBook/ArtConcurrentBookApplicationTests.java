package com.zjmByte.ArtConcurrentBook;

import com.zjmByte.ArtConcurrentBook.chapterFive.TwinsLock;
import com.zjmByte.ArtConcurrentBook.chapterFour.SleepUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.locks.Lock;

@SpringBootTest
class ArtConcurrentBookApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void test() {
		final Lock lock = new TwinsLock();
		class Worker extends Thread {
			public void run() {
				while (true) {
					lock.lock();
					try {
						SleepUtils.second(1);
						System.out.println(Thread.currentThread().getName());
						SleepUtils.second(1);
					} finally {
						lock.unlock();
					}
				}
			}
		}
		// Æô¶¯10¸öÏß³Ì
		for (int i = 0; i < 10; i++) {
			Worker w = new Worker();
			w.setDaemon(true);
			w.start();
		}
		// Ã¿¸ô1Ãë»»ÐÐ
		for (int i = 0; i < 10; i++) {
			SleepUtils.second(1);
			System.out.println();
		}
	}
}
