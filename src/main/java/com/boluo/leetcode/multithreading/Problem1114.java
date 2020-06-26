package com.boluo.leetcode.multithreading;

import java.util.concurrent.Semaphore;

public class Problem1114 {

}

class Foo {

    private Object object = new Object();
    private int mark = 1;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (object) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            while (mark != 1) {
                object.wait(500);
            }
            mark = 2;
            printFirst.run();
            object.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        synchronized (object) {
            while (mark != 2) {
                object.wait(500);
            }
            mark = 3;

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            object.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        synchronized (object) {
            while (mark != 3) {
                object.wait(500);
            }
            mark = 1;
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            object.notifyAll();
        }
    }
}

class Foo1 {

    Semaphore one = new Semaphore(1);
    Semaphore two = new Semaphore(0);
    Semaphore three = new Semaphore(0);
    public Foo1() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        try {
            one.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        two.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        try {
            two.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        three.release();

    }

    public void third(Runnable printThird) throws InterruptedException {

        try {
            three.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        one.release();
    }
}
