package com.huawei.offer2.leetcode.editor.cn;

//给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。 
//
// 请你返回 nums 中唯一元素的 和 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3,2]
//输出：4
//解释：唯一元素为 [1,3] ，和为 4 。
// 
//
// 示例 2： 
//
// 输入：nums = [1,1,1,1,1]
//输出：0
//解释：没有唯一元素，和为 0 。
// 
//
// 示例 3 ： 
//
// 输入：nums = [1,2,3,4,5]
//输出：15
//解释：唯一元素为 [1,2,3,4,5] ，和为 15 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100 
// 
// 👍 55 👎 0

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//Java：唯一元素的和
public class P1748SumOfUniqueElements {
    public static void main(String[] args) {
        Solution solution = new P1748SumOfUniqueElements().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumOfUnique(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int sum = 0;
            for (Integer integer : map.keySet()) {
                if (map.get(integer) == 1) {
                    sum += integer;
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}