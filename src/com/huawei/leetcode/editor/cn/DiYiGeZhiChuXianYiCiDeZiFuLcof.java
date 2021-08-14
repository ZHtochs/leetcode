package com.huawei.leetcode.editor.cn;

//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 
// 👍 124 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DiYiGeZhiChuXianYiCiDeZiFuLcof {
    public static void main(String[] args) {
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char firstUniqChar(String s) {
            char[] chars = s.toCharArray();
            HashMap<Character, Boolean> characters = new HashMap();
            for (Character character : chars) {
                if (characters.containsKey(character)) {
                    characters.put(character, false);
                } else {
                    characters.put(character, true);
                }
            }
            for (int i = 0; i < chars.length; i++) {
                if (characters.get(chars[i])) {
                    return chars[i];
                }
            }
            return ' ';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}