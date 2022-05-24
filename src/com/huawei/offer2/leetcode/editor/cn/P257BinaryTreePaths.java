package com.huawei.offer2.leetcode.editor.cn;

//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// 👍 731 👎 0

import com.huawei.leetcode.editor.cn.TreeNode;

import java.util.ArrayList;
import java.util.List;

//Java：二叉树的所有路径
public class P257BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new P257BinaryTreePaths().new Solution();
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
        private List<String> temp = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            dfs(root, "");
            return temp;
        }

        private void dfs(TreeNode root, String str) {
            if (root == null) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.append(root.val);
            if (root.right == null && root.left == null) {
                temp.add(stringBuilder.toString());
                return;
            }
            stringBuilder.append("->");
            String s = stringBuilder.toString();
            dfs(root.left, s);
            dfs(root.right, s);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}