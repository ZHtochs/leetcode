package com.huawei.offer2.leetcode.editor.cn;

//给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 
//的整数，并以数组形式返回。 
//
// 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[2,3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,2]
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i] <= n 
// nums 中的每个元素出现 一次 或 两次 
// 
// 👍 597 👎 0

import kotlin.collections.EmptyList;

import java.util.*;
import java.util.stream.Collectors;

//Java：数组中重复的数据
public class P442FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        Solution solution = new P442FindAllDuplicatesInAnArray().new Solution();
        int[] a = new int[2];
        System.out.println(a[3]);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            if (nums.length == 0 || nums.length == 1) {
                return new ArrayList<>();
            }
            Arrays.sort(nums);
            HashSet<Integer> arrayList = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    if (nums[0] == nums[1]) {
                        arrayList.add(nums[0]);
                    }
                    continue;
                }
                if (i == nums.length - 1) {
                    if (nums[nums.length - 2] == nums[nums.length - 1]) {
                        arrayList.add(nums[nums.length - 1]);
                    }
                    continue;
                }
                if (nums[i] == nums[i - 1] || nums[i] == nums[i + 1]) {
                    arrayList.add(nums[i]);
                }
            }
            return new ArrayList<>(arrayList);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}