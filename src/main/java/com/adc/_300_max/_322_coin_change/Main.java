package com.adc._300_max._322_coin_change;

public class Main {
    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;

        Solution1 s1 = new Solution1();
        Solution2 s2 = new Solution2();
        Solution3 s3 = new Solution3();
        System.out.println(s1.coinChange(coins, amount));
        System.out.println(s2.coinChange(coins, amount));
        System.out.println(s3.coinChange(coins, amount));
    }
}
