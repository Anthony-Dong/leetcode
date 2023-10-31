package com.recursive;

/**
 * TODO
 *
 * @date:2020/2/9 19:07
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class FibonacciSequence {

    private int pri = 0;

    /**
     * F(N)=F(N-1)+F(N-2)
     * 0,1,1,2,3,5
     */
    public int fib(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int fib = fib(--n);
        int sum = pri + fib;
        pri = fib;
        return sum;
    }

    public static void main(String[] args) {
        FibonacciSequence solution = new FibonacciSequence();
        int fibs = solution.fib(5);
        System.out.println(fibs);
    }
}
