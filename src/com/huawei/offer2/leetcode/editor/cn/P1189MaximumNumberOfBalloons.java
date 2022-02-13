package com.huawei.offer2.leetcode.editor.cn;

//给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。 
//
// 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：text = "nlaebolko"
//输出：1
// 
//
// 示例 2： 
//
// 
//
// 输入：text = "loonbalxballpoon"
//输出：2
// 
//
// 示例 3： 
//
// 输入：text = "leetcode"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 10^4 
// text 全部由小写英文字母组成 
// 
// 👍 101 👎 0

import java.util.List;

//Java：“气球” 的最大数量
public class P1189MaximumNumberOfBalloons {
    public static void main(String[] args) {
        Solution solution = new P1189MaximumNumberOfBalloons().new Solution();
        System.out.println(solution.maxNumberOfBalloons("nlaebolko"));
        System.out.println(solution.maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(solution.maxNumberOfBalloons("leetcode"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //"balloon"
        public int maxNumberOfBalloons(String text) {
            char[] chars = text.toCharArray();
            int[] ints = new int[27];
            for (int i = 0; i < chars.length; i++) {
                ints[chars[i] - 'a'] = ints[chars[i] - 'a'] + 1;
            }
            int res = ints[0];
            res = Math.min(res, ints[1]);
            res = Math.min(res, ints['n' - 'a']);
            res = Math.min(res, ints['l' - 'a'] / 2);
            res = Math.min(res, ints['o' - 'a'] / 2);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}