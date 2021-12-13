package com.huawei.offer2.leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 k ，找出三个长度为 k 、互不重叠、且 3 * k 项的和最大的子数组，并返回这三个子数组。 
//
// 以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。如果有多个结果，返回字典序最小的一个。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,1,2,6,7,5,1], k = 2
//输出：[0,3,5]
//解释：子数组 [1, 2], [2, 6], [7, 5] 对应的起始下标为 [0, 3, 5]。
//也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,1,2,1,2,1,2,1], k = 2
//输出：[0,2,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] < 2¹⁶ 
// 1 <= k <= floor(nums.length / 3) 
// 
// 👍 267 👎 0

import java.util.HashMap;

//Java：三个无重叠子数组的最大和
public class P689MaximumSumOf3NonOverlappingSubarrays {
    public static void main(String[] args) {
        Solution solution = new P689MaximumSumOf3NonOverlappingSubarrays().new Solution();
        int[] ints = solution.maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, }, 2);
        int[] ints2 = solution.maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1}, 2);
        System.out.println("!23");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int i = 0;
            int j = i + k - 1;
            while (true) {
                hashMap.put(i, sum);
                i++;
                j++;
                if (j == nums.length) {
                    break;
                }
                sum = sum - nums[i - 1] + nums[j];
            }

            int max = 0;
            int[] result = new int[3];
            for (int start = k; start < nums.length - k - 1; start++) {
                int[] front = findMax(hashMap, 0, start - k);
                int[] back = findMax(hashMap, start + k, nums.length - k);
                if (front[0] + back[0] + hashMap.get(start) > max) {
                    max = front[0] + back[0] + hashMap.get(start);
                    result[0] = front[1];
                    result[1] = start;
                    result[2] = back[1];
                }
            }
            return result;
        }

        private int[] findMax(HashMap<Integer, Integer> hashMap, int start, int end) {
            int max = 0;
            int maxi = 0;
            for (int i = start; i <= end; i++) {
                if (hashMap.get(i) > max) {
                    maxi = i;
                    max = hashMap.get(maxi);
                }
            }
            int[] ints = new int[2];
            ints[0] = max;
            ints[1] = maxi;
            return ints;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}