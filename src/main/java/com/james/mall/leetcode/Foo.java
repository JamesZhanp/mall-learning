package com.james.mall.leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: JamesZhan
 * @create: 2021 - 03 - 01 23:13
 */
public class Foo {

    CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.

        try {
            printFirst.run();
            cyclicBarrier.await();
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        try {
            cyclicBarrier.await();
            printSecond.run();
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        try {
            cyclicBarrier.await();
            cyclicBarrier.await();
            printThird.run();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
