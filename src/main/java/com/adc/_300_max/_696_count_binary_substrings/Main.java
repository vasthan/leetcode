package com.adc._300_max._696_count_binary_substrings;

public class Main {
    public static void main(String[] args) {
        String s = "001100011";
        System.out.println(new Solution().countBinarySubstrings(s));
        System.out.println(new Solution2().countBinarySubstrings(s));
    }
}
