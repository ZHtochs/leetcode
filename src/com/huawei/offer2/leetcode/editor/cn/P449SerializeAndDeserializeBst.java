package com.huawei.offer2.leetcode.editor.cn;

//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。 
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：[2,1,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数范围是 [0, 10⁴] 
// 0 <= Node.val <= 10⁴ 
// 题目数据 保证 输入的树是一棵二叉搜索树。 
// 
// 👍 340 👎 0

import com.huawei.leetcode.editor.cn.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

//Java：序列化和反序列化二叉搜索树
public class P449SerializeAndDeserializeBst {
    public static void main(String[] args) {
        Codec solution = new P449SerializeAndDeserializeBst().new Codec();
        // TO TEST
        TreeNode treeNode = TreeNode.createTreeNode(2, 1, 3);
        String serialize = solution.serialize(treeNode);
        System.out.println(serialize);
        TreeNode treeNode1 = solution.deserialize(serialize);
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

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            dsf(arrayList, root);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                stringBuilder.append(arrayList.get(i));
                if (i != arrayList.size() - 1) {
                    stringBuilder.append(",");
                }
            }
            return stringBuilder.toString();
        }

        void dsf(ArrayList<Integer> arrayList, TreeNode treeNode) {
            if (treeNode == null) {
                return;
            }
            arrayList.add(treeNode.val);
            dsf(arrayList, treeNode.left);
            dsf(arrayList, treeNode.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) {
                return null;
            }
            String[] split = data.split(",");
            int[] middle = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
            int[] pre = new int[middle.length];
            System.arraycopy(middle, 0, pre, 0, middle.length);
            Arrays.sort(pre);
            return rebuild(0, middle.length - 1, 0, middle.length - 1, middle, pre);
        }

        private TreeNode rebuild(int preStart, int preEnd, int inStart, int inEnd, int[] preorder, int[] inorder) {
            if (preStart > preEnd) {
                return null;
            }
            int newHead = findHead(preorder[preStart], inStart, inEnd, inorder);
            TreeNode treeNode = new TreeNode(inorder[newHead]);
            treeNode.left = rebuild(preStart + 1, preStart + newHead - inStart, inStart, newHead - 1, preorder, inorder);
            treeNode.right = rebuild(preStart + newHead - inStart + 1, preEnd, newHead + 1, inEnd, preorder, inorder);
            return treeNode;
        }

        private int findHead(int head, int start, int end, int[] ints) {
            for (int i = start; i <= end; i++) {
                if (ints[i] == head) {
                    return i;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}