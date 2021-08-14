package com.huawei.leetcode.editor.cn;

//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 194 👎 0

import java.util.Arrays;

public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        System.out.println(solution.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(solution.search(new int[]{1}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int index = Arrays.binarySearch(nums, target);
            if (index < 0) {
                return 0;
            }
            int start = 0, end = 0;
            for (int i = index; i >= 0; i--) {
                if (nums[i] != target) {
                    break;
                }
                start = i;

            }
            for (int i = index; i < nums.length; i++) {
                if (nums[i] != target) {
                    break;
                }
                end = i;
            }
            return end - start + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}