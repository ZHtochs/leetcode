package com.huawei.offer2.leetcode.editor.cn;

//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
// 👍 536 👎 0

import java.util.Locale;

//Java：字符串的排列
public class P567PermutationInString {
    public static void main(String[] args) {
        Solution solution = new P567PermutationInString().new Solution();
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s2.length() < s1.length()) {
                return false;
            }
            int[] counts = new int[26];
            char[] chars = s1.toCharArray();
            for (char aChar : chars) {
                counts[aChar - 'a']++;
            }

            char[] s2Chars = s2.toCharArray();
            int[] current = new int[26];
            for (int i = 0; i < chars.length; i++) {
                current[s2Chars[i] - 'a']++;
            }
            for (int i = 0; i < s2Chars.length; i++) {
                if (compareInts(counts, current)) {
                    return true;
                } else {
                    if (i + chars.length == s2Chars.length) {
                        break;
                    }
                    current[s2Chars[i] - 'a']--;
                    current[s2Chars[i + chars.length] - 'a']++;
                }
            }
            return false;
        }

        private boolean compareInts(int[] s1, int[] current) {
            for (int i = 0; i < s1.length; i++) {
                if (s1[i] != current[i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}