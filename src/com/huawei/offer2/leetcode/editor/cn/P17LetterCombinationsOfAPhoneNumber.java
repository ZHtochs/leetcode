package com.huawei.offer2.leetcode.editor.cn;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// 👍 1770 👎 0

import java.util.*;
import java.util.stream.Stream;

//Java：电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println('1' - '0');
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private HashMap<Integer, String[]> hashMap = new HashMap<>() {{
            put(1 + 1, new String[]{"a", "b", "c"});
            put(2 + 1, new String[]{"d", "e", "f"});
            put(3 + 1, new String[]{"g", "h", "i"});
            put(4 + 1, new String[]{"j", "k", "l"});
            put(5 + 1, new String[]{"m", "n", "o"});
            put(6 + 1, new String[]{"p", "q", "r", "s"});
            put(7 + 1, new String[]{"t", "u", "v"});
            put(8 + 1, new String[]{"w", "x", "y", "z"});
        }};

        private List<String> res = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) {
                return res;
            }
            char[] chars = digits.toCharArray();
            ArrayList<Integer> characters = new ArrayList<>();
            for (char character : chars) {
                characters.add(character - '0');
            }
            int[] ints = characters.stream().mapToInt(Integer::intValue).toArray();
            backTracking(ints, new StringBuilder(), 0);
            return res;
        }

        private void backTracking(int[] ints, StringBuilder s, int start1) {
            if (s.length() == ints.length) {
                res.add(s.toString());
                return;
            }
            String[] strings = hashMap.get(ints[start1]);
            for (int i = 0; i < strings.length; i++) {
                s.append(strings[i]);
                backTracking(ints, s, start1 + 1);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}