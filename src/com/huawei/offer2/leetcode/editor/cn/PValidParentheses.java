package com.huawei.offer2.leetcode.editor.cn;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// 👍 2781 👎 0

import java.util.LinkedList;

//Java：有效的括号
public class PValidParentheses{
    public static void main(String[] args) {
        Solution solution = new PValidParentheses().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        LinkedList<Character> characters = new LinkedList<>();
        characters.push(chars[0]);
        for (int i = 1; i < s.length(); i++) {
            if (characters.size() == 0) {
                characters.push(chars[i]);
                continue;
            }
            if (characters.peek() == '(' && chars[i] == ')') {
                characters.pop();
                continue;
            }
            if (characters.peek() == '[' && chars[i] == ']') {
                characters.pop();
                continue;
            }
            if (characters.peek() == '{' && chars[i] == '}') {
                characters.pop();
                continue;
            }
            characters.push(chars[i]);
        }
        return characters.size() == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}