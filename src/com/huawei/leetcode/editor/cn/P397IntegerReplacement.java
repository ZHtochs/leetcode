//给定一个正整数 n ，你可以做如下操作： 
//
// 
// 如果 n 是偶数，则用 n / 2替换 n 。 
// 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。 
// 
//
// n 变为 1 所需的最小替换次数是多少？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 8
//输出：3
//解释：8 -> 4 -> 2 -> 1
// 
//
// 示例 2： 
//
// 
//输入：n = 7
//输出：4
//解释：7 -> 8 -> 4 -> 2 -> 1
//或 7 -> 6 -> 3 -> 2 -> 1
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// 👍 188 👎 0

package com.huawei.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：整数替换
public class P397IntegerReplacement {
    public static void main(String[] args) {
        Solution solution = new P397IntegerReplacement().new Solution();
        System.out.println(solution.integerReplacement(8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Integer, Integer> memo = new HashMap<Integer, Integer>();


        public int integerReplacement(int n) {
            if (n == 1) {
                return 0;
            }
            if (!memo.containsKey(n)) {
                if (n % 2 == 0) {
                    memo.put(n, 1 + integerReplacement(n / 2));
                } else {
                    memo.put(n, 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1)));
                }
            }
            return memo.get(n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}