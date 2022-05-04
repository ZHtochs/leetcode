package com.huawei.offer2.leetcode.editor.cn;

//给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。. 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root1 = [2,1,4], root2 = [1,0,3]
//输出：[0,1,1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root1 = [1,null,8], root2 = [8,1]
//输出：[1,1,8,8]
// 
//
// 
//
// 提示： 
//
// 
// 每棵树的节点数在 [0, 5000] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// 👍 130 👎 0

import com.huawei.leetcode.editor.cn.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//Java：两棵二叉搜索树中的所有元素
public class P1305AllElementsInTwoBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new P1305AllElementsInTwoBinarySearchTrees().new Solution();
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

        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            pr(root1, list1);
            pr(root2, list2);
            List<Integer> res = new ArrayList<>();
            int first = 0;
            int second = 0;
            while (first < list1.size() && second < list2.size()) {
                int integer1 = list1.get(first);
                int integer2 = list2.get(second);
                if (integer1 > integer2) {
                    res.add(integer2);
                    second++;
                } else {
                    res.add(integer1);
                    first++;
                }
            }
            for (int i = first; i < list1.size(); i++) {
                res.add(list1.get(i));
            }

            for (int i = second; i < list2.size(); i++) {
                res.add(list2.get(i));
            }
            return res;
        }

        private void pr(TreeNode node, List<Integer> res) {
            if (node == null) {
                return;
            }
            pr(node.left, res);
            res.add(node.val);
            pr(node.right, res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}