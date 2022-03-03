package com.huawei.offer2.leetcode.editor.cn;

//给定一个二叉树 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指
//针连接），'#' 表示每层的末尾。 
//
// 
//
// 提示： 
//
// 
// 树中的节点数小于 6000 
// -100 <= node.val <= 100 
// 
//
// 
//
// 
// 
// 👍 515 👎 0

import com.huawei.leetcode.editor.cn.PopulatingNextRightPointersInEachNode;

import java.util.LinkedList;

//Java：填充每个节点的下一个右侧节点指针 II
public class P117PopulatingNextRightPointersInEachNodeIi {
    public static void main(String[] args) {
        Solution solution = new P117PopulatingNextRightPointersInEachNodeIi().new Solution();
        P117PopulatingNextRightPointersInEachNodeIi.Node node1 = new P117PopulatingNextRightPointersInEachNodeIi.Node(1);
        P117PopulatingNextRightPointersInEachNodeIi.Node node2 = new P117PopulatingNextRightPointersInEachNodeIi.Node(2);
        P117PopulatingNextRightPointersInEachNodeIi.Node node3 = new P117PopulatingNextRightPointersInEachNodeIi.Node(3);
        P117PopulatingNextRightPointersInEachNodeIi.Node node4 = new P117PopulatingNextRightPointersInEachNodeIi.Node(4);
        P117PopulatingNextRightPointersInEachNodeIi.Node node5 = new P117PopulatingNextRightPointersInEachNodeIi.Node(5);
        P117PopulatingNextRightPointersInEachNodeIi.Node node6 = new P117PopulatingNextRightPointersInEachNodeIi.Node(6);
        P117PopulatingNextRightPointersInEachNodeIi.Node node7 = new P117PopulatingNextRightPointersInEachNodeIi.Node(7);
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        solution.connect(node1);
        System.out.println("123");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            LinkedList<Node> linkedList = new LinkedList<>();
            linkedList.offer(root);
            while (!linkedList.isEmpty()) {
                int size = linkedList.size();
                Node former = null;
                Node current = null;
                for (int i = 0; i < size; i++) {
                    current = linkedList.poll();
                    if (former != null) {
                        former.next = current;
                    }
                    former = current;
                    if (current.left != null) {
                        linkedList.offer(current.left);
                    }
                    if (current.right != null) {
                        linkedList.offer(current.right);
                    }
                }
            }
            return root;
        }
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}