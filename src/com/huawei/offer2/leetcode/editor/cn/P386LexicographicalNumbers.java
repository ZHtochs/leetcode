package com.huawei.offer2.leetcode.editor.cn;

//给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。 
//
// 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5 * 10⁴ 
// 
// 👍 368 👎 0

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//Java：字典序排数
public class P386LexicographicalNumbers {
    public static void main(String[] args) {
        Solution solution = new P386LexicographicalNumbers().new Solution();
        System.out.println(solution.lexicalOrder(13));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> lexicalOrder(int n) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                arrayList.add(String.valueOf(i));
            }
            arrayList.sort((s, t1) -> {
                char[] t1Chars = s.toCharArray();
                char[] t2Chars = t1.toCharArray();

                for (int i = 0; i < Math.min(t1Chars.length, t2Chars.length); i++) {
                    if (t1Chars[i] != t2Chars[i]) {
                        return t1Chars[i] - t2Chars[i];
                    }
                }
                return t1Chars.length - t2Chars.length;
            });
            return arrayList.stream().map(Integer::parseInt).collect(Collectors.toList());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}