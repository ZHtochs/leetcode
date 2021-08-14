package com.huawei.leetcode.editor.cn;

//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。 
//
// 例如： 
//
// 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tre
//e/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 133 👎 0

import java.util.LinkedList;

public class ErChaShuDeShenDuLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaShuDeShenDuLcof().new Solution();
        System.out.println(solution.maxDepth(TreeNode.createTreeNode(0)));
        System.out.println(solution.maxDepth(TreeNode.createTreeNode(0, 1)));
        System.out.println(solution.maxDepth(TreeNode.createTreeNode(0, 1, 2, 3, 4)));
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
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            LinkedList<TreeNode> list = new LinkedList<>();
            list.add(root);
            int depth = 0;
            while (!list.isEmpty()) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = list.poll();
                    if (treeNode.left != null) {
                        list.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        list.add(treeNode.right);
                    }
                }
                depth++;
            }
            return depth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}