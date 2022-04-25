package com.huawei.offer2.leetcode.editor.cn;

//在一个二维的花园中，有一些用 (x, y) 坐标表示的树。由于安装费用十分昂贵，你的任务是先用最短的绳子围起所有的树。只有当所有的树都被绳子包围时，花园才能
//围好栅栏。你需要找到正好位于栅栏边界上的树的坐标。 
//
// 
//
// 示例 1: 
//
// 输入: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
//输出: [[1,1],[2,0],[4,2],[3,3],[2,4]]
//解释:
//
// 
//
// 示例 2: 
//
// 输入: [[1,2],[2,2],[4,2]]
//输出: [[1,2],[2,2],[4,2]]
//解释:
//
//即使树都在一条直线上，你也需要先用绳子包围它们。
// 
//
// 
//
// 注意: 
//
// 
// 所有的树应当被围在一起。你不能剪断绳子来包围树或者把树分成一组以上。 
// 输入的整数在 0 到 100 之间。 
// 花园至少有一棵树。 
// 所有树的坐标都是不同的。 
// 输入的点没有顺序。输出顺序也没有要求。 
// 👍 106 👎 0

import com.huawei.leetcode.editor.cn.ListNode;

import java.util.*;
import java.util.stream.Collectors;

//Java：安装栅栏
public class P587ErectTheFence {
    public static void main(String[] args) {
        Solution solution = new P587ErectTheFence().new Solution();
        int[][] ints = solution.outerTrees(ListNode.getIntArrays("[[1,5]]"));
        System.out.println(ints);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] outerTrees(int[][] trees) {
            if (trees.length == 1) {
                return trees;
            }
            List<int[]> arraylist = Arrays.stream(trees)
                    .sorted((ints, t1) -> {
                        if (ints[0] != t1[0]) {
                            return ints[0] - t1[0];
                        } else {
                            return ints[1] - t1[1];
                        }
                    })
                    .collect(Collectors.toList());
            Set<int[]> res = new HashSet<>();

            int currentPosition = 0;
            do {
                currentPosition = position(arraylist, res, currentPosition, true);
                System.out.println(currentPosition);
            } while (currentPosition != arraylist.size() - 1);
            currentPosition = arraylist.size() - 1;
            do {
                currentPosition = position(arraylist, res, currentPosition, false);
                System.out.println(currentPosition);
            } while (currentPosition != 0);
            return res.toArray(new int[0][]);
        }

        private int position(List<int[]> arrayList, Set<int[]> res, int currentPosition, boolean direction) {
            int[] current = arrayList.get(currentPosition);
            int position = currentPosition;
            int[] maxInt = null;
            double max = Integer.MIN_VALUE;
            if (direction) {
                for (int i = currentPosition + 1; i < arrayList.size(); i++) {
                    int[] temp = arrayList.get(i);
                    // 垂直
                    if (temp[0] == current[0]) {
                        res.add(temp);
                        position = i;
                        break;
                    }
                    double xielv = (temp[1] - current[1]) * 1.0 / (temp[0] - current[0]);
                    if (xielv > max) {
                        position = i;
                        maxInt = temp;
                        max = xielv;
                    }
                }
            } else {
                for (int i = currentPosition - 1; i >= 0; i--) {
                    int[] temp = arrayList.get(i);
                    // 垂直
                    if (temp[0] == current[0]) {
                        res.add(temp);
                        position = i;
                        break;
                    }
                    double xielv = (temp[1] - current[1]) * 1.0 / (temp[0] - current[0]);
                    if (xielv > max) {
                        position = i;
                        maxInt = temp;
                        max = xielv;
                    }
                }
            }
            if (maxInt != null) {
                res.add(maxInt);
            }
            return position;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}