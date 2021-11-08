package com.huawei.leetcode.editor.cn;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// 👍 1289 👎 0

public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == 0) {
                    moveToEnd(i, nums);
                }
            }
        }

        private void moveToEnd(int i, int[] nums) {
            for (int j = i; j < nums.length; j++) {
                if (j == nums.length - 1 || nums[j + 1] == 0) {
                    break;
                }
                swap(j, j+1, nums);
            }
        }

        private void swap(int i, int j, int[] nums) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}