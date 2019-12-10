package com.num1195;

import java.util.function.IntConsumer;

/**
 * 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 * 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 * 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 * 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 */
public class FizzBuzz {
    private final int n;
    private int x = 1;
    private static final Object lock = new Object();

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (x <= n) {
            synchronized (lock) {
                if (x > n) {
                    return;
                }
                if (x % 3 == 0 && x % 5 != 0) {
                    printFizz.run();
                    x++;
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (x <= n) {
            synchronized (lock) {
                if (x > n) {
                    return;
                }
                if (x % 5 == 0 && x % 3 != 0) {
                    printBuzz.run();
                    x++;
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (x <= n) {
            synchronized (lock) {
                if (x > n) {
                    return;
                }
                if (x % 5 == 0 && x % 3 == 0) {
                    printFizzBuzz.run();
                    x++;
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (x <= n) {
            synchronized (lock) {
                if (x > n) {
                    return;
                }
                if (x % 5 != 0 && x % 3 != 0) {
                    printNumber.accept(x);
                    x++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Runnable rFizz = () -> System.out.println("fizz");
        Runnable rBuzz = () -> System.out.println("buzz");
        Runnable rFizzBuzz = () -> System.out.println("fizzbuzz");
        IntConsumer pNumber = x -> System.out.println(x);

        Runnable rFBFizz = () -> {
            try {
                fizzBuzz.fizz(rFizz);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        };
        Runnable rFBBuzz = () -> {
            try {
                fizzBuzz.buzz(rBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable rFBFizzBuzz = () -> {
            try {
                fizzBuzz.fizzbuzz(rFizzBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable rNumber = () -> {
            try {
                fizzBuzz.number(pNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t1 = new Thread(rFBFizz);
        Thread t2 = new Thread(rFBBuzz);
        Thread t3 = new Thread(rFBFizzBuzz);
        Thread t4 = new Thread(rNumber);
        t4.start();
        t1.start();
        t2.start();
        t3.start();

    }


}