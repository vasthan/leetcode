package com.adc;

import java.util.*;

public class Test {

    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Set<Character>[] sets = new HashSet[rows.length];
        for (int i = 0; i < rows.length; i++) {
            sets[i] = new HashSet<>();
            for (char c : rows[i].toCharArray()) {
                sets[i].add(c);
            }
            for (char c : rows[i].toUpperCase().toCharArray()) {
                sets[i].add(c);
            }
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            for (Set<Character> set : sets) {
                if (findWord(word, set)) {
                    res.add(word);
                    break;
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }

    private boolean findWord(String word, Set<Character> set) {
        for (char c : word.toCharArray()) {
            if (!set.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String[] words = {"Hello","Alaska","Dad","Peace"};
        String[] words = {"omk"};
        String[] res = new Test().findWords(words);
        System.out.println(Arrays.toString(res));

    }
}
