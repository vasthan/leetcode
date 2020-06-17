package com.adc._0_99._80_remove_duplicates_from_sorted_arrayII;

/*
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

示例 1:

给定 nums = [1,1,1,2,2,3],

函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。

你不需要考虑数组中超出新长度后面的元素。
示例 2:

给定 nums = [0,0,1,1,1,1,2,3,3],

函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。

你不需要考虑数组中超出新长度后面的元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    // 双指针，记录元素出现的次数count
    public int removeDuplicates(int[] nums) {
        // 从第二个元素开始判断
        int k = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[k - 1])
                count++;
            else
                count = 1;
            if (count > 2)
                continue;
            nums[k++] = nums[i];
        }
        return k;
    }

    // 去重，每个元素最多出现n次
    public int removeDuplicatesN(int[] nums, int n) {
        // 从第二个元素开始判断
        int k = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[k - 1])
                count++;
            else
                count = 1;
            if (count > n)
                continue;
            nums[k++] = nums[i];
        }
        return k;
    }

    public static void main(String[] args) {
        // System.out.println(new Solution().removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
        System.out.println(new Solution().removeDuplicatesN(new int[]{0,0,1,1,1,1,2,3,3}, 9));
    }
}
