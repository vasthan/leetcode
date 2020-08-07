package com.adc._300_max._336_palindrome_pairs;

import java.util.*;

// https://leetcode-cn.com/problems/palindrome-pairs/solution/hui-wen-dui-by-leetcode-solution/
// 参考官方题解中的哈希表解法
public class Solution2 {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) {
            return res;
        }
        // 存放翻转字符串以及它对应在words数组中的索引
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int m = word.length();

            for (int j = 0; j <= m; j++) {
                if (isPalindrome(word, j, m - 1)) {
                    int left = map.getOrDefault(word.substring(0, j), -1);
                    if (left != -1 && left != i) {
                        res.add(Arrays.asList(i, left));
                    }
                }

                if (j != 0 && isPalindrome(word, 0, j - 1)) {
                    int right = map.getOrDefault(word.substring(j, m), -1);
                    if (right != -1 && right != i) {
                        res.add(Arrays.asList(right, i));
                    }
                }
            }
        }
        return res;
    }

    // 判断str[l, r]区间子串是不是回文串
    private boolean isPalindrome(String str, int l, int r) {
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcd","dcba","lls","s","sssll"};
        Solution2 s = new Solution2();
        System.out.println(s.palindromePairs(words));
    }
}
