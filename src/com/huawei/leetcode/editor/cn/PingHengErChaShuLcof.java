package com.huawei.leetcode.editor.cn;

//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。 
//
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
// 
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
//
// 限制： 
//
// 
// 0 <= 树的结点个数 <= 10000 
// 
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/ 
//
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 180 👎 0

import javax.swing.event.HyperlinkEvent;
import java.util.HashMap;

public class PingHengErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new PingHengErChaShuLcof().new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        treeNode.right.right.left = new TreeNode(6);
        treeNode.right.right.right = new TreeNode(7);
        System.out.println(solution.isBalanced(treeNode));
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
        HashMap<TreeNode, Integer> integerHashMap = new HashMap<>();

        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            int left = getDepth(root.left);
            int right = getDepth(root.right);

            return Math.abs(right - left) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        private int getDepth(TreeNode node) {
            if (integerHashMap.containsKey(node)) {
                return integerHashMap.get(node);
            }
            if (node == null) {
                integerHashMap.put(null, 0);
                return 0;
            }
            if (node.left == null && node.right == null) {
                integerHashMap.put(node, 1);
                return 1;
            }
            int depth = Math.max(getDepth(node.left), getDepth(node.right)) + 1;
            integerHashMap.put(node, depth);
            return depth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}