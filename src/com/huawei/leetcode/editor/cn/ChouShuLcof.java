package com.huawei.leetcode.editor.cn;

//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 
// 👍 205 👎 0

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.logging.Logger;

public class ChouShuLcof {
    public static void main(String[] args) {
        Solution solution = new ChouShuLcof().new Solution();
        System.out.println(solution.nthUglyNumber(1407));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

        public int nthUglyNumber(int n) {
            priorityQueue.add(1L);
            int[] factors = new int[]{2, 3, 5};
            int res = 0;
            for (int i = 0; i < n; i++) {
                long curr = priorityQueue.poll();
                res = (int) curr;
                for (int factor : factors) {
                    if (!priorityQueue.contains(curr * factor)) {
                        priorityQueue.add(curr * factor);
                    }

                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}