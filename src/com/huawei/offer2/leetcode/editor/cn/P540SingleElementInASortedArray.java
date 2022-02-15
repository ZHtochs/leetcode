package com.huawei.offer2.leetcode.editor.cn;

//给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。 
//
// 请你找出并返回只出现一次的那个数。 
//
// 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,2,3,3,4,4,8,8]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums =  [3,3,7,7,10,11,11]
//输出: 10
// 
//
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
// 👍 450 👎 0

//Java：有序数组中的单一元素
public class P540SingleElementInASortedArray {
    public static void main(String[] args) {
        Solution solution = new P540SingleElementInASortedArray().new Solution();
        System.out.println(solution.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        System.out.println(solution.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    if (nums[0] != nums[1]) {
                        return nums[0];
                    }
                } else if (nums[nums.length - 1] != (nums[nums.length - 2])) {
                    return nums[nums.length - 1];
                } else {
                    if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                        return nums[i];
                    }
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}