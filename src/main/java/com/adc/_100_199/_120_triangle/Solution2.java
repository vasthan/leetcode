package com.adc._100_199._120_triangle;

import java.util.List;

// 优化空间复杂度到O(n)
// 根据状态转移方程，f[i][j]只与i-1行的状态有关，与i-2之前的行无关
// 所以我们可以只用2行n列数组来保存状态，使用i的奇偶性来进行状态转移
public class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int n = triangle.size();
        int[][] f = new int[2][n];

        f[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            int cur = i % 2;
            int pre = 1 - cur;
            f[cur][0] = f[pre][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                f[cur][j] = Math.min(f[pre][j], f[pre][j - 1]) + triangle.get(i).get(j);
            }
            f[cur][i] = f[pre][i - 1] + triangle.get(i).get(i);
        }

        int last = (n - 1) % 2;
        int res = f[last][0];
        for (int i = 1; i < n; i++) {
            res = Math.min(res, f[last][i]);
        }
        return res;
    }
}
