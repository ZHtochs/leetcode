package com.huawei.offer2.leetcode.editor.cn;

//你有一个单词列表 words 和一个模式 pattern，你想知道 words 中的哪些单词与模式匹配。 
//
// 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。 
//
// （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。） 
//
// 返回 words 中与给定模式匹配的单词列表。 
//
// 你可以按任何顺序返回答案。 
//
// 
//
// 示例： 
//
// 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
//输出：["mee","aqq"]
//解释：
//"mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
//"ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
//因为 a 和 b 映射到同一个字母。 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 50 
// 1 <= pattern.length = words[i].length <= 20 
// 
// 👍 173 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Java：查找和替换模式
public class P890FindAndReplacePattern {
    public static void main(String[] args) {
        Solution solution = new P890FindAndReplacePattern().new Solution();
        System.out.println(solution.findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"},"abb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<Character, Character> hashMap1 = new HashMap<>();
        HashMap<Character, Character> hashMap2 = new HashMap<>();

        public List<String> findAndReplacePattern(String[] words, String pattern) {
            return Arrays.stream(words).filter(s -> isMatch(s, pattern)).collect(Collectors.toList());

        }

        private boolean isMatch(String s, String pattern) {
            hashMap1.clear();
            hashMap2.clear();
            if (s.length() != pattern.length()) {
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                char char1 = s.charAt(i);
                char char2 = pattern.charAt(i);
                if (hashMap1.containsKey(char1)) {
                    char temp = hashMap1.get(char1);
                    if (temp != char2) {
                        return false;
                    }
                }
                if (hashMap2.containsKey(char2)) {
                    char temp = hashMap2.get(char2);
                    if (char1 != temp) {
                        return false;
                    }
                }
                hashMap1.put(char1, char2);
                hashMap2.put(char2, char1);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}