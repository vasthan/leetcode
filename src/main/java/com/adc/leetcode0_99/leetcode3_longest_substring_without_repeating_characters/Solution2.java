package com.adc.leetcode0_99.leetcode3_longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

// 优化的滑动窗口
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            max = Math.max(max, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution2().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution2().lengthOfLongestSubstring("pwwkew"));
    }
}
