package com.huawei.leetcode.editor.cn;

//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 target = 22， 
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
// 返回:

//[
//   [5,4,11,2],
//   [5,8,4,5]
//]

// 提示： 

// 节点总数 <= 10000 

// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 回溯 二叉树 
// 👍 218 👎 0

import java.util.LinkedList;
import java.util.List;

public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
        TreeNode treeNode = TreeNode.createTreeNode(5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 0, 0, 5, 1);
        List<List<Integer>> lists = solution.pathSum(treeNode, 22);
        treeNode = TreeNode.createTreeNode(1);
        lists = solution.pathSum(treeNode, 0);
        System.out.println("!23");
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

//        public List<List<Integer>> pathSum(TreeNode root, int target) {
//            if (root == null) {
//                return new LinkedList<>();
//            }
//            return recur(root, target);
//        }
//
//        public List<List<Integer>> recur(TreeNode treeNode, int target) {
//            if (treeNode == null) {
//                return new LinkedList<>();
//            }
//            if (treeNode.right == null && treeNode.left == null) {
//                if (target == treeNode.val) {
//                    List<Integer> list = new LinkedList<>();
//                    List<List<Integer>> list2 = new LinkedList<>();
//                    list.add(target);
//                    list2.add(list);
//                    return list2;
//                } else {
//                    return new LinkedList<>();
//                }
//            }
//            List<List<Integer>> left = recur(treeNode.left, target - treeNode.val);
//            List<List<Integer>> right = recur(treeNode.right, target - treeNode.val);
//            List<List<Integer>> sum = new LinkedList<>();
//            if (left != null) {
//                sum.addAll(left);
//            }
//            if (right != null) {
//                sum.addAll(right);
//            }
//            for (List<Integer> list : sum) {
//                list.add(0, treeNode.val);
//            }
//            return sum;
//        }

        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            recur(root, sum);
            return res;
        }
        void recur(TreeNode root, int tar) {
            if(root == null) return;
            path.add(root.val);
            tar -= root.val;
            if(tar == 0 && root.left == null && root.right == null)
                res.add(new LinkedList(path));
            recur(root.left, tar);
            recur(root.right, tar);
            path.removeLast();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}