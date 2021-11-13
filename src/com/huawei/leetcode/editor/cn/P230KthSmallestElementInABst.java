//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
// 👍 523 👎 0

package com.huawei.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：二叉搜索树中第K小的元素
public class P230KthSmallestElementInABst {
    public static void main(String[] args) {
        Solution solution = new P230KthSmallestElementInABst().new Solution();
        TreeNode treeNode = TreeNode.createTreeNode(5, 3, 6, 2, 4, Integer.MIN_VALUE, Integer.MIN_VALUE, 1);
        System.out.println(solution.kthSmallest(treeNode, 3));
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
        public int kthSmallest(TreeNode root, int k) {
            if (root == null) {
                return 0;
            }
            // 自己维护栈结构
            Deque<TreeNode> stack = new LinkedList<>();
            // 当前节点从root开始
            TreeNode node = root;
            while (node != null || !stack.isEmpty()) {
                // 如果当前节点有左子节点，依次入栈
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                // 弹出栈顶元素
                node = stack.pop();
                // 判断 k
                if (--k == 0) {
                    break;
                }
                // 再处理右子节点
                node = node.right;
            }
            return node.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}