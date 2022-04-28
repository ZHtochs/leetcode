package com.huawei.offer2.leetcode.editor.cn;

//给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。 
//
// 返回满足此条件的 任一数组 作为答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,1,2,4]
//输出：[2,4,3,1]
//解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// 0 <= nums[i] <= 5000 
// 
// 👍 300 👎 0

import java.util.Arrays;

//Java：按奇偶排序数组
public class P905SortArrayByParity {
    public static void main(String[] args) {
        Solution solution = new P905SortArrayByParity().new Solution();
        System.out.println(Arrays.toString(solution.sortArrayByParity(new int[]{3, 1, 2, 4})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParity(int[] nums) {
            int i = 0;
            int j = nums.length - 1;
            while (i <= j) {

                if (nums[i] % 2 == 0) {
                    i++;
                    continue;
                }
                if (nums[j] % 2 != 0) {
                    j--;
                    continue;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            return nums;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}