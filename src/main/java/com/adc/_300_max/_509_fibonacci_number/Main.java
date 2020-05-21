package com.adc._300_max._509_fibonacci_number;

public class Main {
    public static void main(String[] args) {
        int n = 44;

        long start = System.currentTimeMillis();
        System.out.println(new Solution().fib(n));
        System.out.println("fib耗时：" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println(new Solution().fib2(n));
        System.out.println("fib2耗时：" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println(new Solution().fib3(n));
        System.out.println("fib3耗时：" + (System.currentTimeMillis() - start));
    }
}
