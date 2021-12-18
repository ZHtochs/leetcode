package com.huawei.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

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

    // [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
    public static int[][] getIntArrays(String s) {
        String[] strings = s.replace(" ", "").split("],");
        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            String[] strings1 = strings[i].replace("[", "").replace("]", "").split(",");
            int[] ints = Arrays.stream(strings1).mapToInt(Integer::valueOf).toArray();
            arrayList.add(ints);
        }
        int[][] ints = new int[arrayList.size()][arrayList.get(0).length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = arrayList.get(i);
        }
        return ints;
    }

    public static char[][] getCharArrays(String... strings) {
        char[][] chars = new char[strings.length][strings[0].length()];
        for (int i = 0; i < strings.length; i++) {
            chars[i] = strings[i].toCharArray();
        }
        return chars;
    }
}