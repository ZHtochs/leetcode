package com.huawei.offer2.leetcode.editor.cn;

//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// 👍 338 👎 0

import com.huawei.leetcode.editor.cn.TreeNode;

import java.util.LinkedList;

//Java：找树左下角的值
public class P513FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Solution solution = new P513FindBottomLeftTreeValue().new Solution();
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
        public int findBottomLeftValue(TreeNode root) {
            TreeNode left = root;
            LinkedList<TreeNode> list = new LinkedList<>();
            list.add(root);
            while (!list.isEmpty()) {
                int size = list.size();
                left = list.getFirst();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = list.poll();
                    if (poll.left != null) {
                        list.add(poll.left);
                    }
                    if (poll.right != null) {
                        list.add(poll.right);
                    }
                }
            }
            return left.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}