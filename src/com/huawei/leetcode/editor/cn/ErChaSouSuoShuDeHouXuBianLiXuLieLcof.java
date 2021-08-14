package com.huawei.leetcode.editor.cn;

//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//        5
//    /    \
//   2      7
//  / \    / \
// 1   3  6   8
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,8,7,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 
// 👍 321 👎 0

public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
        System.out.println(solution.verifyPostorder(new int[]{4, 6, 7, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] ints;

        public boolean verifyPostorder(int[] postorder) {
            ints = postorder;
            return recur(0, postorder.length - 1);
        }

        private boolean recur(int left, int root) {
            if (left >= root) {
                return true;
            }
            int mid = left;
            for (int i = left; i <= root; i++) {
                if (ints[i] >= ints[root]) {
                    mid = i;
                    break;
                }
            }
            for (int i = mid; i < root; i++) {
                if (ints[i] < ints[root]) {
                    return false;
                }
            }
            return recur(left, mid - 1) && recur(mid, root - 1);

        }

        private int findFirstSmaller(int root) {
            for (int i = root; i >= 0; i--) {
                if (ints[i] < ints[root]) {
                    return i;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}