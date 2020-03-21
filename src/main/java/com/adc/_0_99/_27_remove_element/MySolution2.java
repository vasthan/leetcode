package com.adc._0_99._27_remove_element;

// 我的解法：两头双指针-交换元素
// 时间复杂度：O(n)，空间复杂度：O(1)
public class MySolution2 {
    public int removeElement(int[] nums, int val) {
        // 区间[0, n)保存新数组，n表示删除后的数组长度
        int i = 0, n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int newLength = new MySolution2().removeElement(nums, 2);
        for (int i = 0; i < newLength; i++) {
            System.out.println(nums[i]);
        }
    }
}
