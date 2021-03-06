package com.diguage.books.thinking.concurrency;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 哲学家进餐问题主类:死锁演示
 * <p/>
 * Coder: D瓜哥，http://www.diguage.com/
 * Date: 2013-10-01
 * Time: 17:35
 */
public class DeadlockingDiningPhilosophers {
    public static void main(String[] args) throws IOException {
        // 使用随机数来带出参数
        Random random = new Random();
        int ponder = 5;
        ponder = random.nextInt(5);
        int size = 5;
        size = random.nextInt(10);
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            sticks[i] = new Chopstick();
        }

        for (int i = 0; i < size; i++) {
            exec.execute(new Philosopher(sticks[i],
                    sticks[(i + 1) % size], i, ponder));
        }
        System.out.println("Press 'Enter' to quit");
        System.in.read();
        exec.shutdown();
    }
}
