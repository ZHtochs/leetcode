package com.huawei.offer2.leetcode.editor.cn;

//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// 👍 191 👎 0

//Java：一次编辑

import java.util.LinkedList;
import java.util.Queue;

public class OneAwayLcci {
    public static void main(String[] args) {
        Solution solution = new OneAwayLcci().new Solution();
        System.out.println(solution.oneEditAway("islander",
                "slander"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean oneEditAway(String first, String second) {
            if (Math.abs(first.length() - second.length()) >= 2) {
                return false;
            }
            if (first.equals(second)) {
                return true;
            }
            if (first.length() == second.length()) {
                int sum = 0;
                for (int i = 0; i < first.length(); i++) {
                    if (first.charAt(i) != second.charAt(i)) {
                        sum++;
                    }
                }
                return sum <= 1;
            }
            String shortOne = first.length() > second.length() ? second : first;
            String longOne = first.length() > second.length() ? first : second;
            if (shortOne.length() == 0) {
                return true;
            }
            Queue<Character> characters = new LinkedList<>();
            for (int i = 0; i < longOne.length(); i++) {
                characters.offer(longOne.charAt(i));
            }
            boolean used = false;
            for (int i = 0; i < shortOne.length(); i++) {
                char poll = characters.peek();
                if (poll == shortOne.charAt(i)) {
                    characters.poll();
                } else {
                    i--;
                    if (used) {
                        return false;
                    }
                    characters.poll();
                    used = true;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}