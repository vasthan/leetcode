package com.adc._0_99._80_remove_duplicates_from_sorted_arrayII;

import java.util.Arrays;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MySolution {

    // 快慢指针
    // 时间复杂度O(n)，空间复杂度O(1)
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int slow = 1, fast = 2;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 1]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    // 问题扩展：删除重复元素，每个元素最多出现n次
    public int removeDuplicatesN(int[] nums, int n) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int slow = n - 1, fast = n;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - n + 1]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }


    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3,4,5};
        // int length = new MySolution().removeDuplicates(nums);
        int length = new MySolution().removeDuplicatesN(nums, 1);
        System.out.println(length);
        System.out.println(Arrays.toString(nums));
    }
}
