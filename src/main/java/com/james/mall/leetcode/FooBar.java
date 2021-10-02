package com.james.mall.leetcode;

import java.util.concurrent.Semaphore;

/**
 * @author: JamesZhan
 * @create: 2021 - 03 - 01 23:28
 */
public class FooBar {

    Semaphore s1 = new Semaphore(1);
    Semaphore s2 = new Semaphore(0);

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            s1.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            s2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            s2.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            s1.release();
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(2);
    }
}
