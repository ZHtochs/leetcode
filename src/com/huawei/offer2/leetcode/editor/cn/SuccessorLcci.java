package com.huawei.offer2.leetcode.editor.cn;

//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。 
//
// 如果指定节点没有对应的“下一个”节点，则返回null。 
//
// 示例 1: 
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /   
//1
//
//输出: null 
// 👍 180 👎 0

import com.huawei.leetcode.editor.cn.TreeNode;

import java.util.LinkedList;

//Java：后继者
public class SuccessorLcci {
    public static void main(String[] args) {
        Solution solution = new SuccessorLcci().new Solution();
        TreeNode treeNode = TreeNode.createTreeNode(5, 3, 6, 2, 4, Integer.MIN_VALUE, Integer.MIN_VALUE, 1);
        TreeNode treeNode1 = solution.inorderSuccessor(treeNode, new TreeNode(2));
        System.out.println(treeNode1.val);
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
        LinkedList<TreeNode> list = new LinkedList<>();

        boolean find = false;

        TreeNode target;

        TreeNode result;

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            target = p;
            travel(root);
            return result;
        }

        public void travel(TreeNode node) {
            if (node == null) {
                return;
            }
            if (find) {
                return;
            }
            travel(node.left);

            if (find) {
                return;
            }
            if (!list.isEmpty()) {
                TreeNode peek = list.getLast();
                if (peek != null) {
                    if (peek.val == target.val) {
                        find = true;
                        result = node;
                        return;
                    }
                }
            }
            list.offer(node);
            travel(node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}