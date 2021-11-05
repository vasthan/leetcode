package com.adc.other.oddevenprinter;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinter {
    private static Lock lock = new ReentrantLock();
    // 奇数打印完了
    private static Condition odd = lock.newCondition();
    // 偶数打印完了
    private static Condition even = lock.newCondition();

    public static class OddPrinter extends Thread {
        private int num;

        public OddPrinter() {
            this.num = 1;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                while (true) {
                    System.out.println(num);
                    num += 2;
                    Thread.sleep(1000);
                    odd.signal();
                    even.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static class EvenPrinter extends Thread {
        private int num;

        public EvenPrinter() {
            this.num = 0;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                while (true) {
                    System.out.println(num);
                    num += 2;
                    Thread.sleep(1000);
                    odd.await();
                    even.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new EvenPrinter().start();
        new OddPrinter().start();
    }
}
