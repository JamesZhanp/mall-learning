package com.james.mall.leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @author: JamesZhan
 * @create: 2021 - 03 - 03 23:34
 */
public class ZeroEvenOdd {

    private int n;

    /**
     * 需要三个信号量
     * zero,  even,  odd
     */
    Semaphore zeroSemaphore;
    Semaphore evenSemaphore;
    Semaphore oddSemaphore;


    public ZeroEvenOdd(int n){
        this.n = n;
        this.zeroSemaphore = new Semaphore(1);
        this.evenSemaphore = new Semaphore(0);
        this.oddSemaphore = new Semaphore(0);
    }

    public void zero(IntConsumer printNumber) throws InterruptedException{

        for (int i = 1 ; i <= n ; i++){
            this.zeroSemaphore.acquire();
            printNumber.accept(0);
            if (i % 2 == 0){
                this.evenSemaphore.release();
            }else{
                this.oddSemaphore.release();
            }
        }

    }


    public void even(IntConsumer printNumber) throws InterruptedException{

        for (int i = 2 ; i <= n ;  i += 2){
            this.evenSemaphore.acquire();
            printNumber.accept(i);
            this.zeroSemaphore.release();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException{
        for (int i = 1; i <= n ; i+=2){
            this.oddSemaphore.acquire();
            printNumber.accept(i);
            this.zeroSemaphore.release();
        }

    }
}
