//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// 👍 375 👎 0

package com.huawei.leetcode.editor.cn;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.ToIntFunction;

//Java：二叉搜索树中的众数
public class P501FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P501FindModeInBinarySearchTree().new Solution();
        solution.findMode(new TreeNode(0));
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
        private Map<Integer, Integer> map = new HashMap<>();

        public int[] findMode(TreeNode root) {
            dfs(root);
            int max = 0;
            Set<Integer> set = new HashSet<>();
            for (Integer integer : map.keySet()) {
                if (map.get(integer) > max) {
                    max = map.get(integer);
                    set.clear();
                    set.add(integer);
                } else if (map.get(integer) == max) {
                    set.add(integer);
                }
            }
            return set.stream().mapToInt(Integer::intValue).toArray();
        }

        private void dfs(TreeNode treeNode) {
            if (treeNode == null) {
                return;
            }
            final int val = treeNode.val;
            map.compute(val, (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
            dfs(treeNode.left);
            dfs(treeNode.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}