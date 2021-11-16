//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
// 👍 702 👎 0

package com.huawei.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Java：重排链表
public class P143ReorderList {
    public static void main(String[] args) {
        Solution solution = new P143ReorderList().new Solution();
        ListNode listNode = ListNode.createList(1, 2, 3, 4);
        solution.reorderList(listNode);
        ListNode listNode2 = ListNode.createList(1, 2, 3, 4, 5);
        solution.reorderList(listNode2);
        System.out.println("123");
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }
            Deque<ListNode> stack = new LinkedList<>();
            ListNode root = head;
            while (root != null) {
                stack.push(root);
                root = root.next;
            }
            root = head;
            while (true) {
                ListNode peak = stack.pop();
                peak.next = null;
                if (root == peak || root.next == peak) {
                    return;
                }
                ListNode next = root.next;
                root.next = peak;
                peak.next = next;
                root = next;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}