package com.huawei.offer2.leetcode.editor.cn;

//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// 👍 690 👎 0

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Java：找到字符串中所有字母异位词
public class P438FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new P438FindAllAnagramsInAString().new Solution();
        List<Integer> integers = solution.findAnagrams("abab", "ab");
        System.out.println("123");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            if (s.length() < p.length()) {
                return Collections.EMPTY_LIST;
            }
            final int length = p.length();
            final int[] target = new int[26];
            char[] chars = p.toCharArray();
            for (int i = 0; i < length; i++) {
                target[chars[i] - 'a'] += 1;
            }

            final int[] current = new int[26];
            char[] charCurrent = s.toCharArray();

            for (int i = 0; i < length; i++) {
                current[charCurrent[i] - 'a'] += 1;
            }

            ArrayList<Integer> arrayList = new ArrayList<>();

            int i = 0;
            int j = i + length - 1;
            while (true) {
                if (compute(target, current)) {
                    arrayList.add(i);
                }
                i++;
                j++;
                if (j == charCurrent.length) {
                    break;
                }
                current[charCurrent[i - 1] - 'a']--;
                current[charCurrent[j] - 'a']++;
            }

            return arrayList;
        }

        private boolean compute(int[] target, int[] current) {
            for (int i = 0; i < target.length; i++) {
                if (target[i] != current[i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}