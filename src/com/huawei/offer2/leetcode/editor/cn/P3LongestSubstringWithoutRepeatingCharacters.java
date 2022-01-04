package com.huawei.offer2.leetcode.editor.cn;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// 👍 6688 👎 0

import java.util.HashSet;
import java.util.Set;

//Java：无重复字符的最长子串
public class P3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("au"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 1 || s.length() == 0) {
                return s.length();
            }
            char[] chars = s.toCharArray();
            Set<Character> set = new HashSet<>();
            int current = -1;
            int i = 0;
            int j = 0;
            while (j <= chars.length - 1) {
                char temp = chars[j];
                if (!set.contains(temp)) {
                    set.add(temp);
                    j++;
                } else {
                    while (i <= j) {
                        if (temp != chars[i]) {
                            set.remove(chars[i]);
                            i++;
                        } else {
                            set.remove(chars[i]);
                            i++;
                            break;
                        }
                    }
                }
                current = Math.max(set.size(), current);
            }
            return current;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}