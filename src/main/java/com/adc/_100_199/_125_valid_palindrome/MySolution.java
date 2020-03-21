package com.adc._100_199._125_valid_palindrome;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class MySolution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        char[] arr = s.toCharArray();
        while (l <= r) {
            char a = arr[l];
            char b = arr[r];
            if (!isNumber(a) && !isLetter(a)) {
                l++;
                continue;
            } else if (!isNumber(b) && !isLetter(b)) {
                r--;
                continue;
            } else if (a == b || (isLetter(a) && isLetter(b) && Math.abs(a - b) == 32)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isNumber(char v) {
        return v >= '0' && v <= '9';
    }

    private boolean isLetter(char v) {
        return (v >= 'A' && v <= 'Z') || (v >= 'a' && v <= 'z');
    }

    public static void main(String[] args) {

        System.out.println(new MySolution().isPalindrome("0P"));
        System.out.println('a' - 'A');
    }
}
