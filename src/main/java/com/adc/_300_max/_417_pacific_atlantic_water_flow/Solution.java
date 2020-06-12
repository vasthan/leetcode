package com.adc._300_max._417_pacific_atlantic_water_flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。

提示：
输出坐标的顺序不重要
m 和 n 都小于150

示例：
给定下面的 5x5 矩阵:

  太平洋 ~   ~   ~   ~   ~
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * 大西洋

返回:
[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/pacific-atlantic-water-flow
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


// 这道题是要寻找一个坐标既能够到达太平洋也能到达大西洋
// 但是这个过程一般不是一次深度搜索就能够完成的，所以我们从各边界开始逆流进行搜索。
// 然后用两个二维数组进行记录，相当于进行了 4 次dfs，最后对两个数组取交集
public class Solution {
    // 矩阵的行数、列数
    int m, n;
    // 四个方向
    int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || (m = matrix.length) == 0 || (n = matrix[0].length) == 0)
            return res;
        // 左上
        boolean[][] pacific = new boolean[m][n];
        // 右下
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, i, 0);
            dfs(matrix, atlantic, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, pacific, 0, j);
            dfs(matrix, atlantic, m - 1, j);
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i, j));
        return res;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (inArea(newX, newY) && matrix[newX][newY] >= matrix[x][y] && !visited[newX][newY]) {
                dfs(matrix, visited, newX, newY);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };
        List<List<Integer>> res = new Solution().pacificAtlantic(matrix);
        System.out.println(res);
    }
}






