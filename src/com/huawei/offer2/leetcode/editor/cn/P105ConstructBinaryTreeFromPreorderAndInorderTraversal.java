package com.huawei.offer2.leetcode.editor.cn;

//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// 👍 1585 👎 0

import com.huawei.leetcode.editor.cn.TreeNode;

//Java：从前序与中序遍历序列构造二叉树
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        TreeNode treeNode = solution.buildTree2(new int[]{2, 1, 3}, new int[]{1, 2, 3});
        System.out.println();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }
            if (preorder.length == 1) {
                return new TreeNode(preorder[0]);
            }
            int head = findHead(preorder[0], 0, preorder.length - 1, inorder);
            return buildTree(0, preorder.length - 1, 0, preorder.length - 1, preorder, inorder);
        }

        private TreeNode buildTree(int start1, int end1, int start2, int end2, int[] preorder, int[] inorder) {
            if (start1 > end1) {
                return null;
            }
            int newHead = findHead(preorder[start1], start2, end2, inorder);
            TreeNode treeNode = new TreeNode(inorder[newHead]);
            TreeNode leftNode = buildTree(start1 + 1, start1 + newHead - start2, start2, newHead - 1, preorder, inorder);
            treeNode.left = leftNode;
            TreeNode rightNode = buildTree(start1 + newHead - start2 + 1, end1, newHead + 1, end2, preorder, inorder);
            treeNode.right = rightNode;
            return treeNode;
        }

        private int findHead(int head, int start, int end, int[] ints) {
            for (int i = start; i <= end; i++) {
                if (ints[i] == head) {
                    return i;
                }
            }
            return 0;
        }

        public TreeNode buildTree2(int[] preorder, int[] inorder) {
            return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
        }

        private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
            // preorder 为空，直接返回 null
            if (p_start == p_end) {
                return null;
            }
            int root_val = preorder[p_start];
            TreeNode root = new TreeNode(root_val);
            //在中序遍历中找到根节点的位置
            int i_root_index = 0;
            for (int i = i_start; i < i_end; i++) {
                if (root_val == inorder[i]) {
                    i_root_index = i;
                    break;
                }
            }
            int leftNum = i_root_index - i_start;
            //递归的构造左子树
            root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index);
            //递归的构造右子树
            root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);
            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}