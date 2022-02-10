package com.huawei.offer2.leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
// 
//
// |x| 的值定义为： 
//
// 
// 如果 x >= 0 ，那么值为 x 。 
// 如果 x < 0 ，那么值为 -x 。 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,2,1], k = 1
//输出：4
//解释：差的绝对值为 1 的数对为：
//- [1,2,2,1]
//- [1,2,2,1]
//- [1,2,2,1]
//- [1,2,2,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,3], k = 3
//输出：0
//解释：没有任何数对差的绝对值为 3 。
// 
//
// 示例 3： 
//
// 输入：nums = [3,2,1,5,4], k = 2
//输出：3
//解释：差的绝对值为 2 的数对为：
//- [3,2,1,5,4]
//- [3,2,1,5,4]
//- [3,2,1,5,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 1 <= k <= 99 
// 
// 👍 56 👎 0

import java.util.HashMap;

//Java：差的绝对值为 K 的数对数目
public class P2006CountNumberOfPairsWithAbsoluteDifferenceK {
    public static void main(String[] args) {
        Solution solution = new P2006CountNumberOfPairsWithAbsoluteDifferenceK().new Solution();
        System.out.println(solution.countKDifference(new int[]{3, 2, 1, 5, 4}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countKDifference(int[] nums, int k) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int num : nums) {
                hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
            }
            int sum = 0;
            for (int num : nums) {
                sum += hashMap.getOrDefault(num + k, 0);
                sum += hashMap.getOrDefault(num - k, 0);
                Integer integer = hashMap.remove(num);
                if (integer > 1) {
                    hashMap.put(num, integer - 1);
                }
            }
            ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}