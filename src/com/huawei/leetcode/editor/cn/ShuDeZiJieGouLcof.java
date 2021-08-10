package com.huawei.leetcode.editor.cn;

//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 315 👎 0

import javax.swing.plaf.InsetsUIResource;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShuDeZiJieGouLcof {
    public static void main(String[] args) {
        Solution solution = new ShuDeZiJieGouLcof().new Solution();
        TreeNode a = TreeNode.createTreeNode(10, 12, 6, 8, 3, 11);
        TreeNode b = TreeNode.createTreeNode(10, 12, 6, 8);
        System.out.println(solution.isSubStructure(a, b));
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
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) {
                return false;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(A);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (isTreeSame(node, B)) {
                    return true;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            return false;
        }

        private boolean isTreeSame(TreeNode A, TreeNode B) {
            if (B == null) return true;
            if (A == null || A.val != B.val) return false;
            return isTreeSame(A.left, B.left) && isTreeSame(A.right, B.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}