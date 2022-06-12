package com.huawei.offer2.leetcode.editor.cn;

//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// 👍 1265 👎 0

import com.huawei.leetcode.editor.cn.TreeNode;

import java.util.LinkedList;
import java.util.concurrent.DelayQueue;

//Java：二叉树的最大深度
public class P104MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            LinkedList<TreeNode> treeNodes = new LinkedList<>();
            int currentLevel = 0;
            treeNodes.add(root);
            while (!treeNodes.isEmpty()) {
                currentLevel++;
                int size = treeNodes.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = treeNodes.poll();
                    if (poll.left != null) {
                        treeNodes.offer(poll.left);
                    }
                    if (poll.right != null) {
                        treeNodes.offer(poll.right);
                    }
                }
            }
            return currentLevel;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}