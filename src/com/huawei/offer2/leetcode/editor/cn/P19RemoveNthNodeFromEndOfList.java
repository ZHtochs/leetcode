package com.huawei.offer2.leetcode.editor.cn;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// 👍 1748 👎 0

import com.huawei.leetcode.editor.cn.ListNode;

//Java：删除链表的倒数第 N 个结点
public class P19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
        ListNode listNode = ListNode.createList(1, 2, 3, 4, 5);
        ListNode listNode1 = solution.removeNthFromEnd(listNode, 2);
        ListNode.printListNode(listNode1);
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode listNode = new ListNode(0);
            listNode.next = head;
            for (int i = 0; i < n; i++) {
                head = head.next;
            }
            ListNode temp = listNode;
            while (head != null) {
                head = head.next;
                temp = temp.next;
            }
            temp.next = temp.next.next;
            return listNode.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}