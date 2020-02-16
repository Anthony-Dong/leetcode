package com.num50;


/**
 * <a href="https://leetcode-cn.com/problems/powx-n/submissions/">50. Pow(x, n)</a>
 * <p>
 * Java底层的幂函数计算是C++写的, 所以我们看不到.
 * <p>
 * 对于幂函数计算 一般采用折中法 , 好比2^4 我们只需要两步 , a=2*2 , b=a*a , 不需要迭代两次. 这个前提是 4是2的幂次方.
 * 但是对于6 7这种数字咋计算. 所以考虑到这个. 就拿2的幂次数开始想 . 10 最后绝对是 8+2 8绝对是2*2*2 , 所以我们想想. 也就是加了两次,
 * 重头开始想 x=2^2 , x=2^4 , x=2^8 , x=2^16 ,所以第一步和第三步2^2*2^8次方就好了. 正好符合.
 * <p>
 * 10mod2=0 , 5mod2=1 ,2mod2=0 ,1mod2=1 , 所以正好符合.
 * <p>
 */
public class Solution {

    public static double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }

    public static void main(String[] args) {
        double v = myPow(2, 10);
        System.out.println(v);
    }
}