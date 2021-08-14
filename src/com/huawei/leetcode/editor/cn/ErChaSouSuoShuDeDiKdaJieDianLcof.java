package com.huawei.leetcode.editor.cn;

//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 189 👎 0

import java.util.Comparator;
import java.util.PriorityQueue;

public class ErChaSouSuoShuDeDiKdaJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
        TreeNode treeNode = TreeNode.createTreeNode(3, 1, 4);
        System.out.println(solution.kthLargest(treeNode, 1));
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int k;
        int value;

//        public int kthLargest(TreeNode root, int k) {
//            this.k = k;
//            dfs(root);
//            return priorityQueue.peek();
//        }
//
//        private void dfs(TreeNode root) {
//            if (root == null) {
//                return;
//            }
//            if (priorityQueue.size() < k) {
//                priorityQueue.add(root.val);
//            } else {
//                int max = priorityQueue.peek();
//                if (root.val > max) {
//                    priorityQueue.poll();
//                    priorityQueue.add(root.val);
//                }
//            }
//            dfs(root.left);
//            dfs(root.right);
//        }

        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return value;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.right);
            if (k == 1) {
                value = root.val;
            }
            k--;
            dfs(root.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}