package com.huawei.offer2.leetcode.editor.cn;

//给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下： 
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
//输入：root = [1,2,3,4,5,6,7]
//输出：[1,#,2,3,#,4,5,6,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 
//next 指针连接，'#' 标志着每一层的结束。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量少于 4096 
// -1000 <= node.val <= 1000 
// 
// 👍 646 👎 0

import com.huawei.leetcode.editor.cn.Node;

import java.util.LinkedList;

//Java：填充每个节点的下一个右侧节点指针
public class P116PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Solution solution = new P116PopulatingNextRightPointersInEachNode().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.

*/

    class Solution {

        private Node pre;

        private int level = -1;

        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            LinkedList<Node> linkedList = new LinkedList<>();
            linkedList.add(root);
            int currentLevel = 1;
            while (true) {
                int size = linkedList.size();
                if (size == 0) {
                    break;
                }
                for (int i = 0; i < size; i++) {
                    Node currentNode = linkedList.poll();
                    if (currentNode.left != null) {
                        linkedList.offer(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        linkedList.offer(currentNode.right);
                    }
                    if (pre == null) {
                        //根节点
                        pre = currentNode;
                        continue;
                    }
                    if (level == currentLevel) {
                        pre.next = currentNode;
                    }
                    pre = currentNode;
                    level = currentLevel;
                }
                level = currentLevel;
                currentLevel++;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}