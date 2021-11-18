//给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为
//每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
//输出: 16 
//解释: 这两个单词为 "abcw", "xtfn"。 
//
// 示例 2: 
//
// 
//输入: ["a","ab","abc","d","cd","bcd","abcd"]
//输出: 4 
//解释: 这两个单词为 "ab", "cd"。 
//
// 示例 3: 
//
// 
//输入: ["a","aa","aaa","aaaa"]
//输出: 0 
//解释: 不存在这样的两个单词。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= words.length <= 1000 
// 1 <= words[i].length <= 1000 
// words[i] 仅包含小写字母 
// 
// 👍 275 👎 0

package com.huawei.leetcode.editor.cn;

//Java：最大单词长度乘积
public class P318MaximumProductOfWordLengths {
    public static void main(String[] args) {
        Solution solution = new P318MaximumProductOfWordLengths().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(String[] words) {
            int[] hash = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                char[] chars = words[i].toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    hash[i] |= 1 << (chars[j] - 'a');
                }
            }

            int max = 0;
            for (int i = 0; i < words.length - 1; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if ((hash[i] & hash[j]) == 0) {
                        max = Math.max(words[i].length() * words[j].length(), max);
                    }
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}