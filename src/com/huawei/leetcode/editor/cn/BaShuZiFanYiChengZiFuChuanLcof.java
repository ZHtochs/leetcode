package com.huawei.leetcode.editor.cn;

//给定一个数字，我们按照如下规则把它翻译为字符串：
// 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// Related Topics 字符串 动态规划 
// 👍 262 👎 0

public class BaShuZiFanYiChengZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        System.out.println(solution.translateNum(12258));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //        public int translateNum(int num) {
//            if (num < 10) {
//                return 1;
//            }
//            if (num % 100 < 26 && num % 100 >= 10) {
//                return translateNum(num / 10) + translateNum(num / 100);
//            } else {
//                return translateNum(num / 10);
//            }
//        }
        public int translateNum(int num) {
            String s = String.valueOf(num);
            int a = 1, b = 1;
            for (int i = 2; i <= s.length(); i++) {
                String tmp = s.substring(i - 2, i);
                int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
                b = a;
                a = c;
            }
            return a;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)
}