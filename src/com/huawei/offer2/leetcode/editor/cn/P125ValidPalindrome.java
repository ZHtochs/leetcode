package com.huawei.offer2.leetcode.editor.cn;

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
// 👍 440 👎 0

//Java：验证回文串
public class P125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            char[] chars = s.toCharArray();
            int i = 0;
            int j = chars.length - 1;
            while (i < j) {
                if (!isValid(chars[i])) {
                    i++;
                    continue;
                }

                if (!isValid(chars[j])) {
                    j--;
                    continue;
                }
                if (String.valueOf(chars[i]).equalsIgnoreCase(String.valueOf(chars[j]))) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
            return true;
        }

        private boolean isValid(char c) {
            if (c >= '0' && c <= '9') {
                return true;
            }
            if (c >= 'a' && c <= 'z') {
                return true;
            }

            if (c >= 'A' && c <= 'Z') {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}