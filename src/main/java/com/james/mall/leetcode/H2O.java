package com.james.mall.leetcode;

import java.util.concurrent.Semaphore;

/**
 * @author: JamesZhan
 * @create: 2021 - 03 - 07 15:30
 */
public class H2O {

    public H2O() {

    }

    Semaphore hydSemaphore = new Semaphore(2);
    Semaphore oxygenSemaphore = new Semaphore(0);
    volatile int i = 0;

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        hydSemaphore.acquire();
        releaseHydrogen.run();
        i++;
        if (i == 2){
            oxygenSemaphore.release(1);
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        oxygenSemaphore.acquire();
        releaseOxygen.run();
        hydSemaphore.release(2);
        i = 0;
    }
}
