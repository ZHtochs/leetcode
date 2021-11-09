package com.huawei.leetcode.editor.cn;

//给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。 
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。 
//
// 
//
// 提示： 
//
// 
// 树上节点的数目在范围 [2, 1000] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// 👍 585 👎 0

public class RecoverBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new RecoverBinarySearchTree().new Solution();
        TreeNode treeNode = TreeNode.createTreeNode(3, 1, 4, Integer.MIN_VALUE, Integer.MIN_VALUE, 2);
        solution.recoverTree(treeNode);
        System.out.println("123");
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
        private TreeNode first;
        private TreeNode pre;
        private TreeNode second;

        public void recoverTree(TreeNode root) {
            middleTravel(root);
            if (second == null) {
                second = pre;
            }
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        private void middleTravel(TreeNode root) {
            if (root == null) {
                return;
            }
            middleTravel(root.left);
            if (pre != null) {
                if (pre.val > root.val) {
                    second = root;
                    if (first == null) {
                        first = pre;
                    }
                }
            }
            pre = root;
            middleTravel(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}