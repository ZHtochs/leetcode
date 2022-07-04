package com.huawei.offer2.leetcode.editor.cn;

//给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,4,7,5,3,6,8,9]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2],[3,4]]
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// -10⁵ <= mat[i][j] <= 10⁵ 
// 
// 👍 355 👎 0

import com.huawei.leetcode.editor.cn.ListNode;

import java.util.*;

//Java：对角线遍历
public class P498DiagonalTraverse {
    public static void main(String[] args) {
        Solution solution = new P498DiagonalTraverse().new Solution();
        int[][] ints = new int[][]{{1, 2}, {2, 2}, {3, 3}};
        System.out.println(Arrays.toString(solution.findDiagonalOrder(ListNode.getIntArrays("[[1,2,3],[4,5,6],[7,8,9]]"))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            LinkedList<int[]> queue = new LinkedList<>();
            ArrayList<LinkedList<int[]>> res = new ArrayList<>();
            queue.add(new int[]{0, 0});
            while (!queue.isEmpty()) {
                int size = queue.size();
                res.add(new LinkedList<>(queue));
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll();
                    int[] second = new int[]{poll[0], poll[1] + 1};
                    int[] first = new int[]{poll[0] + 1, poll[1]};
                    if (first[0] < mat.length && first[1] < mat[0].length) {
                        int[] peek = queue.peek();
                        if (peek == null || peek[0] != first[0] && peek[1] != first[1]) {
                            queue.add(first);
                        }
                    }
                    if (second[0] < mat.length && second[1] < mat[0].length) {
                        int[] peek = queue.peek();
                        if (peek == null || peek[0] != second[0] && peek[1] != second[1]) {
                            queue.add(second);
                        }
                    }
                }
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < res.size(); i++) {
                LinkedList<int[]> ints = res.get(i);
                if (i % 2 != 0) {
                    Collections.reverse(ints);
                }
                for (int[] temp : ints) {
                    arrayList.add(mat[temp[0]][temp[1]]);
                }
            }
            return arrayList.stream().mapToInt(Integer::intValue).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}