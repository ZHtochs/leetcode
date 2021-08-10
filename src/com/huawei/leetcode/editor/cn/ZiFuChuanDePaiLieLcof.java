package com.huawei.leetcode.editor.cn;

//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 
// 👍 400 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        String[] a = solution.permutation("aab");
        System.out.println("!@3");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] permutation(String s) {
            Set<String> hashset = p(s);
            return hashset.toArray(new String[0]);
        }

        public Set<String> p(String s) {
            if (s.length() == 0) {
                return new HashSet<>();
            }
            if (s.length() == 1) {
                Set<String> arrayList = new HashSet<>();
                arrayList.add(s);
                return arrayList;
            }
            Set<String> arrayListM = p(s.substring(0, s.length() - 1));
            Set<String> res = new HashSet<>();
            String cur = s.substring(s.length() - 1, s.length());
            for (String s1 : arrayListM) {
                StringBuilder stringBuilder = new StringBuilder(s1);
                for (int i = 0; i <= s1.length(); i++) {
                    res.add(stringBuilder.insert(i, cur).toString());
                    stringBuilder.deleteCharAt(i);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}