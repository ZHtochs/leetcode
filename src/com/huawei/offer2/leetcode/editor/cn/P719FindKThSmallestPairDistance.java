package com.huawei.offer2.leetcode.editor.cn;

//数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。 
//
// 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。
//返回 所有数对距离中 第 k 小的数对距离。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,1], k = 1
//输出：0
//解释：数对和对应的距离如下：
//(1,3) -> 2
//(1,1) -> 0
//(3,1) -> 2
//距离第 1 小的数对是 (1,1) ，距离为 0 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,6,1], k = 3
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 2 <= n <= 10⁴ 
// 0 <= nums[i] <= 10⁶ 
// 1 <= k <= n * (n - 1) / 2 
// 
// 👍 343 👎 0

import java.util.Arrays;

//Java：找出第 K 小的数对距离
public class P719FindKThSmallestPairDistance {
    public static void main(String[] args) {
        Solution solution = new P719FindKThSmallestPairDistance().new Solution();
        System.out.println(solution.smallestDistancePair(new int[]{1, 6, 1}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestDistancePair(int[] nums, int k) {
            int count[] = new int[(int) 1e6 + 5];
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    count[Math.abs(nums[i] - nums[j])]++;
                }
            }
            for (int i = 0; ; i++) {
                k -= count[i];
                if (k <= 0) {
                    return i;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}