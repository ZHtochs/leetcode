package com.huawei.leetcode.editor.cn;

//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。 
//
// 
//
// 为了让您更好地理解问题，以下面的二叉搜索树为例： 
//
// 
//
// 
//
// 
//
// 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是
//第一个节点。 
//
// 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。 
//
// 
//
// 
//
// 
//
// 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。 
//
// 
//
// 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-
//to-sorted-doubly-linked-list/ 
//
// 注意：此题对比原题有改动。 
// Related Topics 栈 树 深度优先搜索 二叉搜索树 链表 二叉树 双向链表 
// 👍 282 👎 0

public class ErChaSouSuoShuYuShuangXiangLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuYuShuangXiangLianBiaoLcof().new Solution();
        Solution.Node node1 = solution.new Node(1);
        Solution.Node node2 = solution.new Node(2);
        Solution.Node node3 = solution.new Node(3);
        Solution.Node node4 = solution.new Node(4);
        Solution.Node node5 = solution.new Node(5);
        node4.left = node2;
        node4.right = node5;
        node2.left = node1;
        node2.right = node3;
        Solution.Node node = solution.treeToDoublyList(node4);
        System.out.println("!23");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
    class Solution {

        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            Node node = treeList(root);
            Node temp = node;
            while (temp.right != null) {
                Node right = temp.right;
                right.left = temp;
                temp = temp.right;
            }

            temp.right = node;
            node.left = temp;
            return node;
        }

        public Node treeList(Node root) {
            if (root == null) {
                return null;
            }
            Node left = treeList(root.left);
            Node right = treeList(root.right);
            if (left == null) {
                root.right = right;
                return root;
            }
            Node head = left;
            while (left.right != null) {
                left = left.right;
            }
            left.right = root;
            root.right = right;
            return head;
        }

        public class Node {
            public int val;
            public Node left;
            public Node right;

            public Node() {
            }

            public Node(int _val) {
                val = _val;
            }

            public Node(int _val, Node _left, Node _right) {
                val = _val;
                left = _left;
                right = _right;
            }
        }

        ;
    }
//leetcode submit region end(Prohibit modification and deletion)

}