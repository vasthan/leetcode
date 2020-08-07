package com.adc._300_max._336_palindrome_pairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
336. 回文对
给定一组 互不相同 的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。

示例 1：

输入：["abcd","dcba","lls","s","sssll"]
输出：[[0,1],[1,0],[3,2],[2,4]]
解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
示例 2：

输入：["bat","tab","cat"]
输出：[[0,1],[1,0]]
解释：可拼接成的回文串为 ["battab","tabbat"]
 */
public class Solution {

    // 暴力解法：对于列表中的任意两个单词拼接成的字符串，判断它是不是回文
    // 复杂度：两层循环的时间复杂度是O(n^2)，判断回文时间复杂度O(m)，总的时间复杂度是O(m * n^2)，n是数组长度，m是字符串平均长度
    // 提交到leetcode报超时
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) {
            return res;
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && isPalindrome(words[i] + words[j])) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    // 判断一个字符串是不是回文串
    private boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"bat","tab","cat"};
        Solution s = new Solution();
        System.out.println(s.palindromePairs(words));
    }

}
