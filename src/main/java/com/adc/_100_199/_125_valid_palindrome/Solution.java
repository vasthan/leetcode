package com.adc._100_199._125_valid_palindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            while (!isDigitOrLetter(chars[i]) && i < j) i++;
            while (!isDigitOrLetter(chars[j]) && i < j) j--;
            if (i < j && Character.toLowerCase(chars[i]) != Character.toLowerCase(chars[j])) return false;
            i++;
            j--;
        }
        return true;
    }

    private boolean isDigitOrLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new Solution().isPalindrome(s));
        // System.out.println((byte)'a');
        // System.out.println((byte)'z');
        // System.out.println((byte)'A');
        // System.out.println((byte)'Z');
        // System.out.println((byte)'0');
        // System.out.println((byte)'9');
    }
}
