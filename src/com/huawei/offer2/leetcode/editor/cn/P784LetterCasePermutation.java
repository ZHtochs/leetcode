package com.huawei.offer2.leetcode.editor.cn;

//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。 
//
// 
//
// 示例：
//输入：S = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入：S = "3z4"
//输出：["3z4", "3Z4"]
//
//输入：S = "12345"
//输出：["12345"]
// 
//
// 
//
// 提示： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// 👍 350 👎 0

import java.util.ArrayList;
import java.util.List;

//Java：字母大小写全排列
public class P784LetterCasePermutation {
    public static void main(String[] args) {
        Solution solution = new P784LetterCasePermutation().new Solution();
        List<String> a1b2 = solution.letterCasePermutation("a1b2");
        a1b2 = solution.letterCasePermutation("3z4");
        a1b2 = solution.letterCasePermutation("12345");
        System.out.println("123");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();

        public List<String> letterCasePermutation(String s) {
            res.clear();
            char[] chars = s.toCharArray();
            res.add(s);
            dfs(chars, 0, chars.length);
            return res;
        }

        private void dfs(char[] chars, int start, int length) {
            for (int i = start; i < length; i++) {
                if (transformChar(chars[i]) != chars[i]) {
                    chars[i] = transformChar(chars[i]);
                    res.add(new String(chars));
                    dfs(chars, i + 1, length);
                    chars[i] = transformChar(chars[i]);
                }
            }
        }

        public char transformChar(char c) {
            if (c >= 'a' && c <= 'z') {
                return (char) (c + 'A' - 'a');
            } else if (c >= 'A' && c <= 'Z') {
                return (char) (c - 'A' + 'a');
            }
            return c;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}