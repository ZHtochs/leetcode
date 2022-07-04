package com.huawei.offer2.leetcode.editor.cn;

//假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。 
//
// 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 
//costs 来表示的。 
//
// 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。 
//
// 请计算出粉刷完所有房子最少的花费成本。 
//
// 
//
// 示例 1： 
//
// 
//输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
//输出: 10
//解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
//     最少花费: 2 + 5 + 3 = 10。
// 
//
// 示例 2： 
//
// 
//输入: costs = [[7,6,2]]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// costs.length == n 
// costs[i].length == 3 
// 1 <= n <= 100 
// 1 <= costs[i][j] <= 20 
// 
//
// 
//
// 注意：本题与主站 256 题相同：https://leetcode-cn.com/problems/paint-house/ 
// 👍 101 👎 0

import com.huawei.leetcode.editor.cn.ListNode;

import java.util.Arrays;

//Java：粉刷房子
public class JEj789 {
    public static void main(String[] args) {
        Solution solution = new JEj789().new Solution();
        System.out.println(solution.minCost(ListNode.getIntArrays("[[3,5,3],[6,17,6],[7,13,18],[9,10,18]]")));
        System.out.println("           ");
        System.out.println(solution.minCost2(ListNode.getIntArrays("[[3,5,3],[6,17,6],[7,13,18],[9,10,18]]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCost(int[][] costs) {
            if (costs.length == 1) {
                return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
            }
            int[] current = new int[3];
            int[] pre = costs[0].clone();
            for (int i = 1; i < costs.length; i++) {
                int[] temp = costs[i].clone();
                current[0] = Math.min(pre[1], pre[2]) + temp[0];
                current[1] = Math.min(pre[0], pre[2]) + temp[1];
                current[2] = Math.min(pre[0], pre[1]) + temp[2];
                pre = current.clone();
                System.out.println(Arrays.toString(current));
            }
            return Math.min(Math.min(current[0], current[1]), current[2]);
        }

        public int minCost2(int[][] cs) {
            int n = cs.length;
            int a = cs[0][0], b = cs[0][1], c = cs[0][2];
            for (int i = 0; i < n - 1; i++) {
                int d = Math.min(b, c) + cs[i + 1][0];
                int e = Math.min(a, c) + cs[i + 1][1];
                int f = Math.min(a, b) + cs[i + 1][2];
                a = d;
                b = e;
                c = f;
                System.out.println(a + " " + b + " " + c);
            }
            return Math.min(a, Math.min(b, c));
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}