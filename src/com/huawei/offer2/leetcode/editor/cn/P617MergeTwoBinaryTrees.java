package com.huawei.offer2.leetcode.editor.cn;

//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// 👍 854 👎 0

import com.huawei.leetcode.editor.cn.TreeNode;

//Java：合并二叉树
public class P617MergeTwoBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new P617MergeTwoBinaryTrees().new Solution();
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
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            TreeNode dfs = dfs(root1, root2);
            return dfs;
        }

        TreeNode dfs(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) {
                return null;
            }
            TreeNode treeNode;
            if (node1 != null && node2 != null) {
                treeNode = new TreeNode(node1.val + node2.val);
            } else if (node1 == null && node2 == null) {
                treeNode = null;
            } else {
                treeNode = new TreeNode(node1 == null ? node2.val : node1.val);
            }
            treeNode.left = dfs(node1 == null ? null : node1.left, node2 == null ? null : node2.left);
            treeNode.right = dfs(node1 == null ? null : node1.right, node2 == null ? null : node2.right);
            return treeNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}