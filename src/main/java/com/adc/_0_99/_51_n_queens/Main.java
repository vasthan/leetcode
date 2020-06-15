package com.adc._0_99._51_n_queens;

/**
 * 测试Solution和Solution2的性能
 */
public class Main {
    public static void main(String[] args) {
        int n = 12;
        Solution s1 = new Solution();
        Solution2 s2 = new Solution2();


        long start1 = System.currentTimeMillis();
        for (int i = 0; i <= n; i++) {
            s1.solveNQueens(i);
        }
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        for (int i = 0; i <= n; i++) {
            s2.solveNQueens(i);
        }
        long end2 = System.currentTimeMillis();

        System.out.println("Solution1 cost: " + (end1 - start1) + " ms");
        System.out.println("Solution2 cost: " + (end2 - start2) + " ms");
    }
}
