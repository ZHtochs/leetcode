package com.huawei.offer2.leetcode.editor.cn;

//给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: root = [5,2,-3]
//输出: [2,-3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入: root = [5,2,-5]
//输出: [2]
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 10⁴] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// 👍 155 👎 0

import com.huawei.leetcode.editor.cn.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

//Java：出现次数最多的子树元素和
public class P508MostFrequentSubtreeSum {
    public static void main(String[] args) {
        Solution solution = new P508MostFrequentSubtreeSum().new Solution();
        System.out.println(Arrays.toString(solution.findFrequentTreeSum(TreeNode.createTreeNode(5, 2, -3))));
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
        HashMap<TreeNode, Integer> hashMap = new HashMap<>();

        public int[] findFrequentTreeSum(TreeNode root) {
            HashMap<Integer, Integer> hashMap2 = new HashMap<>();
            dfs(root, hashMap2);
            int max = Integer.MIN_VALUE;
            for (int value : hashMap2.values()) {
                max = Math.max(max, value);
            }
            final int x = max;
            return hashMap2.keySet().stream()
                    .filter(integer -> hashMap2.get(integer) == x).mapToInt(Integer::intValue).toArray();
        }

        private void dfs(TreeNode root, HashMap<Integer, Integer> hashMap) {
            if (root == null) {
                return;
            }
            int sum = getSum(root);
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
            dfs(root.left, hashMap);
            dfs(root.right, hashMap);
        }

        public int getSum(TreeNode treeNode) {
            if (treeNode == null) {
                return 0;
            }
            int leftValue = hashMap.getOrDefault(treeNode.left, getSum(treeNode.left));
            int rightValue = hashMap.getOrDefault(treeNode.right, getSum(treeNode.right));
            int res = treeNode.val + leftValue + rightValue;
            hashMap.put(treeNode, res);
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}