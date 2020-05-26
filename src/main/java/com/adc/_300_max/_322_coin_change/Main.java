package com.adc._300_max._322_coin_change;

public class Main {
    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;

        Solution s = new Solution();
        // System.out.println(s.coinChange1(coins, amount));
        System.out.println(s.coinChange2(coins, amount));
        System.out.println(s.coinChange3(coins, amount));
    }
}
