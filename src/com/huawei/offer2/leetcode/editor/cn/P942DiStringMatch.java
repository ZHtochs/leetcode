package com.huawei.offer2.leetcode.editor.cn;

//由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中: 
//
// 
// 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I' 
// 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D' 
// 
//
// 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "IDID"
//输出：[0,4,1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：s = "III"
//输出：[0,1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：s = "DDI"
//输出：[3,2,0,1] 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含字符 "I" 或 "D" 
// 
// 👍 364 👎 0

import java.util.Arrays;

//Java：增减字符串匹配
public class P942DiStringMatch {
    public static void main(String[] args) {
        Solution solution = new P942DiStringMatch().new Solution();
        System.out.println(Arrays.toString(solution.diStringMatch("IDID")));
        System.out.println(Arrays.toString(solution.diStringMatch("III")));
        System.out.println(Arrays.toString(solution.diStringMatch("DDI")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] diStringMatch(String s) {
            char[] chars = s.toCharArray();
            int start = 0;
            int end = chars.length;
            int[] res = new int[s.length() + 1];
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'D') {
                    res[i] = end;
                    end--;
                } else {
                    res[i] = start;
                    start++;
                }
            }
            res[res.length - 1] = start;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}