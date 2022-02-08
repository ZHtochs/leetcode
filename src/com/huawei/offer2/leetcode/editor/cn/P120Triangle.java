package com.huawei.offer2.leetcode.editor.cn;

//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -10⁴ <= triangle[i][j] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
// 👍 953 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：三角形最小路径和
public class P120Triangle {
    public static void main(String[] args) {
        Solution solution = new P120Triangle().new Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(List.of(2)));
        triangle.add(new ArrayList<>(List.of(3, 4)));
        triangle.add(new ArrayList<>(List.of(6, 5, 7)));
        triangle.add(new ArrayList<>(List.of(4, 1, 8, 3)));
        System.out.println(solution.minimumTotal(triangle));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            List<Integer> former = new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            for (List<Integer> list : triangle) {
                res = list;
                if (!former.isEmpty()) {
                    for (int j = 0; j < res.size(); j++) {
                        if (j == 0) {
                            res.set(0, former.get(0) + res.get(j));
                        } else if (j == res.size() - 1) {
                            res.set(j, former.get(j - 1) + res.get(j));
                        } else {
                            res.set(j, Math.min(former.get(j - 1), former.get(j)) + res.get(j));
                        }
                    }
                }
                former = res;
            }
            int max = Integer.MAX_VALUE;
            for (Integer re : res) {
                max = Math.min(max, re);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}