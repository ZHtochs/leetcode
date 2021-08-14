package com.huawei.leetcode.editor.cn;

//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//滑动窗口的重要性质是：窗口的左边界和右边界永远只能向右移动，而不能向左移动。这是为了保证滑动窗口的时间复杂度是 O(n)O(n)。如果左右边界向左移动的话，这叫做“回溯”，算法的时间复杂度就可能不止 O(n)O(n)。
//
//作者：nettee
//链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/shi-yao-shi-hua-dong-chuang-kou-yi-ji-ru-he-yong-h/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
// 
// Related Topics 数学 双指针 枚举 
// 👍 305 👎 0

import java.util.ArrayList;

public class HeWeiSdeLianXuZhengShuXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        int[][] ints = solution.findContinuousSequence(9);
        ints = solution.findContinuousSequence(15);
        System.out.println("!@3");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {
            if (target == 1 || target == 2) {
                return new int[0][0];
            }

            int i = 1;
            int j = 2;
            int sum = 3;
            ArrayList<int[]> arrayList = new ArrayList<>();
            while (i <= target / 2) {
                if (sum > target) {
                    sum -= i;
                    i++;
                } else if (sum < target) {
                    j++;
                    sum += j;
                } else {
                    int[] ints = new int[j - i + 1];
                    for (int k = i; k <= j; k++) {
                        ints[k - i] = k;
                    }
                    arrayList.add(ints);
                    j++;
                    sum += j;
                }
            }
            return arrayList.toArray(new int[0][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}