package com.adc._0_99._3_longest_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        // 使用滑动窗口[i, j)表示最长子串
        int i = 0, j = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length() && j < s.length()) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution1().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution1().lengthOfLongestSubstring("pwwkew"));
    }
}
