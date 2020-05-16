package com.adc._300_max._345_reverse_vowels_of_a_string;

import java.util.HashSet;
import java.util.Set;

/**
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 */
public class Solution {
    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        // 这里要考虑大小写
        char[] vowels = {'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};
        Set<Character> set = new HashSet<>();
        for (char vowel : vowels) {
            set.add(vowel);
        }
        char[] arr = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (!set.contains(arr[l])) {
                l++;
                continue;
            }
            if (!set.contains(arr[r])) {
                r--;
                continue;
            }
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
        return new String(arr);
    }
}
