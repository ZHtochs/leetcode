package com.huawei.leetcode.daily;

/**
 * @program: offer
 * @author: zhuhe
 * @create: 2021-11-06 22:31
 **/
public class Problem268 {
    public static void main(String[] args) {
        Problem268 problem268 = new Problem268();

        problem268.missingNumber(new int[]{7, 6, 4, 2, 3, 5, 9, 0, 1});
    }

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i && nums[i] < nums.length) {
                swap(nums, nums[i], i);
                i--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    private void swap(int[] ints, int i, int j) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }
}