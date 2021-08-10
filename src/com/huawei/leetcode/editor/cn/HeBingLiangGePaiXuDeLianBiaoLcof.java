package com.huawei.leetcode.editor.cn;

//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 递归 链表 
// 👍 151 👎 0

import java.util.List;

public class HeBingLiangGePaiXuDeLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
        ListNode listNode = ListNode.createList(1, 2, 4);
        ListNode listNode2 = ListNode.createList(1, 3, 4);
        ListNode.printListNode(solution.mergeTwoLists(listNode, listNode2));
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode cursor = new ListNode(0);
            head.next = cursor;
            while (true) {
                if (l1 == null) {
                    cursor.next = l2;
                    return head.next.next;
                }
                if (l2 == null) {
                    cursor.next = l1;
                    return head.next.next;
                }
                if (l1.val < l2.val) {
                    cursor.next = l1;
                    l1 = l1.next;
                } else {
                    cursor.next = l2;
                    l2 = l2.next;
                }
                cursor = cursor.next;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}