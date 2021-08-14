package com.huawei.leetcode.editor.cn;

//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 521 👎 0

import java.util.HashMap;
import java.util.Map;

public class ZhongJianErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();

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
        Map<Integer, Integer> map;
        int[] preOrder;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            map = new HashMap<>(inorder.length);
            preOrder = preorder;
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return recur(0, 0, inorder.length - 1);
        }

        TreeNode recur(int root, int left, int right) {
            if (left > right) return null;                          // 递归终止
            TreeNode node = new TreeNode(preOrder[root]);          // 建立根节点
            int i = map.get(preOrder[root]);                       // 划分根节点、左子树、右子树
            node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
            node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
            return node;                                           // 回溯返回根节点
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}