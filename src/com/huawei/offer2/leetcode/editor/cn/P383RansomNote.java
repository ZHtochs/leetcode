package com.huawei.offer2.leetcode.editor.cn;

//为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。 
//
// 给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符
//构成。 
//
// 如果可以构成，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
// 👍 239 👎 0

import javax.naming.ldap.HasControls;
import java.util.HashMap;
import java.util.function.Function;

//Java：赎金信
public class P383RansomNote {
    public static void main(String[] args) {
        Solution solution = new P383RansomNote().new Solution();
        solution.canConstruct("aa", "ab");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            char[] chars = magazine.toCharArray();
            HashMap<Character, Integer> hashMap = new HashMap<>();
            for (char aChar : chars) {
                hashMap.put(aChar, hashMap.getOrDefault(aChar, 0) + 1);
            }
            char[] chars1 = ransomNote.toCharArray();
            for (char c : chars1) {
                if (!hashMap.containsKey(c)) {
                    return false;
                } else {
                    int count = hashMap.get(c);
                    if (count == 1) {
                        hashMap.remove(c);
                    } else {
                        hashMap.put(c, count - 1);
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}