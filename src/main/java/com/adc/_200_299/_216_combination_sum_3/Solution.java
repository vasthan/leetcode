package com.adc._200_299._216_combination_sum_3;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        dfs(k, n, 1, new ArrayList<>());
        return res;
    }

    private void dfs(int k, int n, int start, List<Integer> c) {
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(c));
            return;
        }
        if (k == 0 || n < start) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            c.add(i);
            dfs(k - 1, n - i, i + 1, c);
            c.remove(c.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combinationSum3(3, 7));
        System.out.println(s.combinationSum3(3, 9));
    }
}
