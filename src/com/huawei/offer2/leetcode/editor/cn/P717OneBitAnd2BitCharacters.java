package com.huawei.offer2.leetcode.editor.cn;

//有两种特殊字符： 
//
// 
// 第一种字符可以用一个比特 0 来表示 
// 第二种字符可以用两个比特(10 或 11)来表示、 
// 
//
// 给定一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一位字符，则返回 true 。 
//
// 
//
// 示例 1: 
//
// 
//输入: bits = [1, 0, 0]
//输出: true
//解释: 唯一的编码方式是一个两比特字符和一个一比特字符。
//所以最后一个字符是一比特字符。
// 
//
// 示例 2: 
//
// 
//输入: bits = [1, 1, 1, 0]
//输出: false
//解释: 唯一的编码方式是两比特字符和两比特字符。
//所以最后一个字符不是一比特字符。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= bits.length <= 1000 
// bits[i] == 0 or 1 
// 
// 👍 252 👎 0

//Java：1比特与2比特字符
public class P717OneBitAnd2BitCharacters {
    public static void main(String[] args) {
        Solution solution = new P717OneBitAnd2BitCharacters().new Solution();
        System.out.println(solution.isOneBitCharacter(new int[]{0, 1, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isOneBitCharacter(int[] bits) {
            if (bits.length == 1) {
                return true;
            }
            boolean[] booleans = new boolean[bits.length];
            for (int i = 0; i < booleans.length; i++) {
                if (i == 0) {
                    booleans[i] = (bits[0] == 0);
                } else if (i == 1) {
                    int first = bits[0];
                    int second = bits[1];
                    booleans[i] = isCorrect(first, second);
                } else {
                    int first = bits[i - 1];
                    int second = bits[i];
                    booleans[i] = (booleans[i - 1] && (bits[i] == 0)) || (booleans[i - 2] && isCorrect(first, second));
                }
            }
            return booleans[bits.length - 2];
        }

        private boolean isCorrect(int a, int b) {
            return (a == 1 && b == 0) || (a == 1 && b == 1) || (a == 0 && b == 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}