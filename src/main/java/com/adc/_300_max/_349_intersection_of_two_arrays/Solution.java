package com.adc._300_max._349_intersection_of_two_arrays;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }

        int[] intersection = new int[result.size()];
        int index = 0;
        for (int v : result) {
            intersection[index++] = v;
        }
        return intersection;
    }
}
