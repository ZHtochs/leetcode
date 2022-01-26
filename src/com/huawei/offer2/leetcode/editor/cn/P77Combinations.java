package com.huawei.offer2.leetcode.editor.cn;

//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// 👍 833 👎 0

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

//Java：组合
public class P77Combinations {
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        List<List<Integer>> combine = solution.combine(3, 2);
        System.out.println("123");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> combine(int n, int k) {
            ArrayList<Integer> set;
            set = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                set.add(i);
            }
            if (k <= 0 || k > n) {
                return Collections.emptyList();
            }
            List<List<Integer>> res = new LinkedList<>();
            if (k == 1) {
                for (Integer integer : set) {
                    res.add(new ArrayList<>(List.of(integer)));
                }
                return res;
            }
            if (k == n) {
                ArrayList<Integer> arrayList = new ArrayList<>(set);
                res.add(arrayList);
                return res;
            }
            List<List<Integer>> former = combine(n - 1, k);
            List<List<Integer>> former2 = combine(n - 1, k - 1);
            System.out.println("!23");
            for (int i = 0; i < former2.size(); i++) {
                List<Integer> list = former2.get(i);
                list.add(n);
                former.add(list);
            }
            return former;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}