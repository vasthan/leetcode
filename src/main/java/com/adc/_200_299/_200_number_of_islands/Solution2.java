package com.adc._200_299._200_number_of_islands;

//  dfs优化，不使用visited数组记录，直接把访问过的陆地标记为0
public class Solution2 {
    private int m, n;
    // 上-右-下-左
    private int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int num = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (inArea(newX, newY) && grid[newX][newY] == '1') {
                dfs(grid, newX, newY);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >=0 && y < n;
    }

    public static void main(String[] args) {
        // 11110
        // 11010
        // 11000
        // 00000
        char[][] grid1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        // 11000
        // 11000
        // 00100
        // 00011
        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(new Solution2().numIslands(grid1));
        System.out.println(new Solution2().numIslands(grid2));
    }
}
