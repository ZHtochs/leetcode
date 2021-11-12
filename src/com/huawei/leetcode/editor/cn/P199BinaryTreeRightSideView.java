//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// -100 <= Node.val <= 100 
// 
// 👍 559 👎 0

package com.huawei.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：二叉树的右视图
public class P199BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new P199BinaryTreeRightSideView().new Solution();
        TreeNode treeNode = TreeNode.createTreeNode(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> list = solution.rightSideView(treeNode);
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (true) {
                if (queue.isEmpty()) {
                    break;
                }
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode temp = queue.poll();
                    if (i == size - 1) {
                        list.add(temp.val);
                    }
                    if (temp.left != null) {
                        queue.offer(temp.left);
                    }
                    if (temp.right != null) {
                        queue.offer(temp.right);
                    }
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}