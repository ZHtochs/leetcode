package com.huawei.offer2.leetcode.editor.cn;

//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
// 👍 815 👎 0

import com.huawei.leetcode.editor.cn.ListNode;

//Java：删除排序链表中的重复元素 II
public class P82RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new P82RemoveDuplicatesFromSortedListIi().new Solution();
        ListNode.printListNode(solution.deleteDuplicates(ListNode.createList(1, 2, 3, 3, 4, 4, 5)));
        ListNode.printListNode(solution.deleteDuplicates(ListNode.createList(1, 1, 1, 2, 3)));
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode newHead = new ListNode(-1);
            newHead.next = head;
            int temp = -1;
            ListNode former = newHead;
            ListNode current = head;
            ListNode latter = head;
            while (current != null) {
                latter = current.next;
                if (latter == null) {
                    break;
                }
                int val = current.val;
                if (val == latter.val) {
                    while (true) {
                        latter = latter.next;
                        if (latter == null || latter.val != val) {
                            break;
                        }
                    }
                    current = latter;
                    former.next = current;
                } else {
                    latter = latter.next;
                    current = current.next;
                    former = former.next;
                }

            }
            return newHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}