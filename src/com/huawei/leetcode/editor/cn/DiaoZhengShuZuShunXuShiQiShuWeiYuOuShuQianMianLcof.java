package com.huawei.leetcode.editor.cn;

//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// Related Topics 数组 双指针 排序 
// 👍 146 👎 0

public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    public static void main(String[] args) {
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        ListNode.printInt(solution.exchange(new int[]{1, 2, 3, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] exchange(int[] nums) {
            int head = 0;
            int tail = nums.length - 1;
            while (head < tail) {
                if (nums[head] % 2 == 0 && nums[tail] % 2 == 1) {
                    int temp = nums[head];
                    nums[head] = nums[tail];
                    nums[tail] = temp;
                    head++;
                    tail--;
                    continue;
                }
                if (nums[head] % 2 == 0 && nums[tail] % 2 == 0) {
                    tail--;
                    continue;
                }
                if (nums[tail] % 2 == 1 && nums[head] % 2 == 1) {
                    head++;
                    continue;
                }
                head++;
                tail--;
            }

            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}