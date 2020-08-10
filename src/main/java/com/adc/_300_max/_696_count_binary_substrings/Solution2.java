package com.adc._300_max._696_count_binary_substrings;

/*
优化空间复杂度到O(1)
 */
public class Solution2 {
    public int countBinarySubstrings(String s) {
        if (s == null) return 0;
        int i = 0, n = s.length();
        int res = 0;

        int preCount = 0;
        while (i < n) {
            int count = 0;
            char c = s.charAt(i);
            while (i < n && s.charAt(i) == c) {
                count++;
                i++;
            }
            res += Math.min(preCount, count);
            preCount = count;
        }
        return res;
    }
}
