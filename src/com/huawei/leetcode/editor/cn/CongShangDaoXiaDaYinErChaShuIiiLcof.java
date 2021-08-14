package com.huawei.leetcode.editor.cn;

//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 121 👎 0

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CongShangDaoXiaDaYinErChaShuIiiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
        TreeNode treeNode = TreeNode.createTreeNode(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<List<Integer>> lists = solution.levelOrder(treeNode);
        System.out.println("123");
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            LinkedList<TreeNode> list = new LinkedList<>();
            List<List<Integer>> lists = new LinkedList<>();
            if (root == null) {
                return lists;
            }
            list.add(root);
            boolean direction = true;
            while (!list.isEmpty()) {
                List<Integer> temp = list.stream().mapToInt(treeNode -> treeNode.val).boxed().collect(Collectors.toList());
                if (!direction) {
                    Collections.reverse(temp);
                }
                lists.add(temp);
                direction = !direction;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = list.poll();
                    if (treeNode.left != null) {
                        list.add(treeNode.left);
                    }

                    if (treeNode.right != null) {
                        list.add(treeNode.right);
                    }
                }
            }
            return lists;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}