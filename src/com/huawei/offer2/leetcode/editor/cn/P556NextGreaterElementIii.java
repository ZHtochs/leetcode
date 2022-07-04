package com.huawei.offer2.leetcode.editor.cn;

//给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。 
//
// 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：21
// 
//
// 示例 2： 
//
// 
//输入：n = 21
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// 👍 272 👎 0

import java.util.Arrays;

//Java：下一个更大元素 III
public class P556NextGreaterElementIii {
    public static void main(String[] args) {
        Solution solution = new P556NextGreaterElementIii().new Solution();
        System.out.println(solution.nextGreaterElement(230241));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nextGreaterElement(int n) {
            char[] chars = String.valueOf(n).toCharArray();
            int x = -1;//target
            int y = -1;//found
            for (int i = 1; i < chars.length; i++) {
                if (x != -1) {
                    break;
                }
                for (int j = chars.length - 1; j >= 0 && j - i >= 0; j--) {
                    if (chars[j] > chars[j - i]) {
                        x = j;
                        y = j - i;
                        break;
                    }
                }

            }

            if (x == -1) {
                return -1;
            }
            char temp = chars[x];
            chars[x] = chars[y];
            chars[y] = temp;
            String s = new String(chars);
            try {
                return Integer.parseInt(s);
            } catch (Exception e) {
                return -1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}