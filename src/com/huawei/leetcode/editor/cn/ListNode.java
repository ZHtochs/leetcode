package com.huawei.leetcode.editor.cn;

/**
 * @program: offer
 * @author: zhuhe
 * @create: 2021-08-05 21:46
 **/
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    static ListNode createList(int... ints) {
        ListNode head = new ListNode(ints[0]);
        ListNode temp = head;
        for (int i = 1; i < ints.length; i++) {
            temp.next = new ListNode(ints[i]);
            temp = temp.next;
        }
        return head;
    }

    static void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    static void printInt(int[] ints) {
        for (int anInt : ints) {
            System.out.print(" " + anInt);
        }
    }
}