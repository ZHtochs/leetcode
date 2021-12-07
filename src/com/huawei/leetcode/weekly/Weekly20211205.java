package com.huawei.leetcode.weekly;

import com.huawei.leetcode.editor.cn.ListNode;
import com.huawei.leetcode.editor.cn.TreeNode;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @program: offer
 * @author: zhuhe
 * @create: 2021-12-05 10:34
 **/
public class Weekly20211205 {
    public static void main(String[] args) {
        Weekly20211205 weekly20211205 = new Weekly20211205();
        TreeNode treeNode = TreeNode.createTreeNode(1, 2, 3, 4, 5, 6, 7);
        LinkedList<Pair> list = new LinkedList<>();
        String s = weekly20211205.getDirections(treeNode, 6, 7);
        System.out.println(s);
    }

    private ArrayList<Integer> arrayList = new ArrayList<>();

    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) {
                continue;
            }
            for (int j = 0; j < digits.length; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < digits.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    if (digits[k] % 2 != 0) {
                        continue;
                    }
                    int sum = 100 * digits[i] + 10 * digits[j] + digits[k];
                    set.add(sum);
                }
            }
        }
        int[] ints = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(ints);
        return ints;
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode pr = new ListNode(Integer.MIN_VALUE);
        pr.next = head;
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (slow == null || slow.next == null) {
                pr.next = fast.next;
                break;
            }
            slow = slow.next.next;
            fast = fast.next;
            pr = pr.next;
        }
        return head;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        LinkedList<Pair> arrayListStart = new LinkedList<>();
        LinkedList<Pair> arrayListEnd = new LinkedList<>();
        pre(root, startValue, arrayListStart, "");
        pre(root, destValue, arrayListEnd, "");
        Pair pair = null;
        for (Pair pair1 : arrayListStart) {
            if (arrayListEnd.contains(pair1)) {
                pair = pair1;
            }
        }
        pair = pair == null ? new Pair(root, "") : pair;
        StringBuilder stringBuilder = new StringBuilder();
        for (Pair pair1 : arrayListStart) {
            if (pair1 == pair) {
                //到达根节点
                break;
            }
            stringBuilder.append(pair1.direction);
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        for (Pair pair1 : arrayListEnd) {
            if (pair1 == pair) {
                //到达根节点
                break;
            }
            stringBuilder2.append(pair1.direction);
        }
        stringBuilder.append(stringBuilder2.reverse());
        return stringBuilder.toString();
    }

    public boolean pre(TreeNode root, int target, LinkedList<Pair> list, String direction) {
        if (root == null) return false;
        list.push(new Pair(root, direction));
        if (root.val == target) return true;
        boolean b = false;
        //先去左子树找
        if (root.left != null) b = pre(root.left, target, list, "L");
        //左子树找不到并且右子树不为空的情况下才去找
        if (!b && root.right != null) b = pre(root.right, target, list, "R");
        //左右都找不到，弹出栈顶元素
        if (!b) list.pop();
        return b;
    }

    private class Pair {
        TreeNode treeNode;

        String direction;

        public Pair(TreeNode treeNode, String direction) {
            this.treeNode = treeNode;
            this.direction = direction;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return treeNode.val == pair.treeNode.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(treeNode.val);
        }
    }
}