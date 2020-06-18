package com.adc._200_299._215_kth_largest_element_in_an_array;

import java.util.PriorityQueue;


public class Solution2 {

    // 使用优先队列，最小堆维护数组最大的前k个元素
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else if (num > minHeap.peek()) {
                minHeap.add(num);
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums  = {3,2,1,5,6,4};
        System.out.println(new Solution2().findKthLargest(nums, 2));

        int[] nums2 = {3,2,3,1,2,4,5,5,6};
        System.out.println(new Solution2().findKthLargest(nums2, 4));
    }
}
