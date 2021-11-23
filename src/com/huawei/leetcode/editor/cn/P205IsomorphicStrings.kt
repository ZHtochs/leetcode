//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1: 
//
// 
//输入：s = "egg", t = "add"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "foo", t = "bar"
//输出：false 
//
// 示例 3： 
//
// 
//输入：s = "paper", t = "title"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 可以假设 s 和 t 长度相同。 
// 
// 👍 402 👎 0


package com.huawei.leetcode.editor.cn;

fun main(args: Array<String>) {

}

//Java：同构字符串
public class P205IsomorphicStrings {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isIsomorphic(s: String, t: String): Boolean {
            if (s.length != t.length) return false
            val chars = s.toCharArray()
            val charsB = t.toCharArray()
            val map = HashMap<Char, Char>()
            for (i in chars.indices) {
                if (map.containsKey(chars[i])) {
                    if (map[chars[i]] == charsB[i]) {
                        continue
                    } else {
                        return false
                    }
                } else {
                    if (map.values.contains(charsB[i])) {
                        return false
                    }
                    map[chars[i]] = charsB[i]
                }
            }
            return true
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}