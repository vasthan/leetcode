package com.adc._0_99._51_n_queens;

import java.util.ArrayList;
import java.util.List;

/*
输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    // 摆放问题：横、竖、对角线上不能出现2个以上皇后

    // (0,0)	(0,1)	(0,2)	(0,3)
    //
    // (1,0)	(1,1)	(1,2)	(1,3)
    //
    // (2,0)	(2,1)	(2,2)	(2,3)
    //
    // (3,0)	(3,1)	(3,2)	(3,3)

    // 同列
    private boolean[] col;
    // 正斜线：x + y相同
    private boolean[] d1;
    // 反斜线：x - y相同
    private boolean[] d2;

    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        col = new boolean[n];
        d1 = new boolean[2 * n - 1];
        d2 = new boolean[2 * n - 1];
        res = new ArrayList<>();
        putQueen(n, 0, new ArrayList<>());
        return res;
    }

    // 在index行放置皇后，row中存放每一行皇后所处的列
    private void putQueen(int n, int index, List<Integer> row) {
        if (index == n) {
            res.add(generateBoard(row, n));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !d1[index + i] && !d2[index - i + n - 1]) {
                col[i] = true;
                d1[index + i] = true;
                d2[index - i + n - 1] = true;
                row.add(index, i);
                putQueen(n, index + 1, row);
                col[i] = false;
                d1[index + i] = false;
                d2[index - i + n - 1] = false;
                row.remove(index);
            }
        }
    }

    private List<String> generateBoard(List<Integer> row, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == row.get(i)) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            board.add(sb.toString());
        }
        return board;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> res = solution.solveNQueens(4);
        System.out.println(res);
    }
}
