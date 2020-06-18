package com.adc._200_299._215_kth_largest_element_in_an_array;

import java.util.Random;

/*
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    private Random rand = new Random();
    // 快速排序partition思路
    // 数组中第K大元素，就是数组按从大到小排序后索引为k-1位置的元素
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k - 1);
    }

    private int findKthLargest(int[] nums, int l, int r, int k) {
        int p = partition(nums, l, r);
        if (p == k)
            return nums[p];
        return p > k ? findKthLargest(nums, l, p - 1, k) : findKthLargest(nums, p + 1, r, k);
    }

    private int partition(int[] nums, int l, int r) {
        swap(nums, l, rand.nextInt(r - l + 1) + l);
        int v = nums[l];
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] <= v) j--;
            while (i < j && nums[i] >= v) i++;
            swap(nums, i, j);
        }
        swap(nums, l, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums  = {3,2,1,5,6,4};
        System.out.println(new Solution().findKthLargest(nums, 2));

        int[] nums2 = {3,2,3,1,2,4,5,5,6};
        System.out.println(new Solution().findKthLargest(nums2, 4));
    }
}
