package com.qianxin;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @date:2020/2/28 22:46
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class AQS {

    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        // 当满了.就阻塞
        final Condition full = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
//                TimeUnit.SECONDS.sleep(1000);

                full.await();
                System.out.println("=======释放了=====");
            } catch (InterruptedException e) {
                //
            } finally {
                lock.unlock();
            }
        },"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            lock.lock();
            System.out.println("=======拿到锁===");
            try {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //
                full.signal();

            } finally {
                lock.unlock();
            }
        },"t2").start();



    }
}
