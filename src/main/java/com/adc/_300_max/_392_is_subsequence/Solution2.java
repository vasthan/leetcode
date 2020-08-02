package com.adc._300_max._392_is_subsequence;

/*
后续挑战：需要检查大量的字符串s

对字符串t进行预处理
 */
public class Solution2 {
    // DP，对字符串t进行预处理。当工程中有大量字符串s需要检查时，可以大大提高效率
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        int m = t.length();
        // 状态定义：dp[i][j]表示从字符串t的i位置开始，字母j第一次出现的位置（用0-25表示a-z的26个字母）
        int[][] dp = new int[m + 1][26];
        // 为了使状态转移代码统一，增加了最后一行的base case
        for (int i = 0; i < 26; i++) {
            // dp[m][i]=-1表示，从字符串t的m位置开始往后寻找任意的小写字母第一次出现的位置（贪心），都是不存在的
            dp[m][i] = -1;
        }

        // 状态转移，从dp数组的倒数第二行开始向上转移
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) - 'a' == j) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        // 判断字符串s是否是字符串t的子序列
        int begin = 0;
        for (char c : s.toCharArray()) {
            int index = dp[begin][c - 'a'];
            if (index == -1) {
                return false;
            } else {
                begin = index + 1;
            }
        }
        return true;
    }
}
