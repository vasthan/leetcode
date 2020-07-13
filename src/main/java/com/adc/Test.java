package com.adc;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();
        map.getOrDefault(1, 0);

        List<Integer> list = new ArrayList<>();

        int[] res = list.stream().mapToInt(x -> x).toArray();


    }
}
