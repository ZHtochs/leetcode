package com.huawei.leetcode.editor.cn;

/**
 * @program: offer
 * @author: zhuhe
 * @create: 2021-08-05 21:46
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode createList(int... ints) {
        ListNode head = new ListNode(ints[0]);
        ListNode temp = head;
        for (int i = 1; i < ints.length; i++) {
            temp.next = new ListNode(ints[i]);
            temp = temp.next;
        }
        return head;
    }

    public static void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public static void printInt(int[] ints) {
        for (int anInt : ints) {
            System.out.print(" " + anInt);
        }
    }
}