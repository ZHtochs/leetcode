package com.huawei.leetcode.editor.cn;

import java.awt.desktop.PrintFilesEvent;
import java.nio.IntBuffer;
import java.util.LinkedList;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

/**
 * @program: offer
 * @author: zhuhe
 * @create: 2021-08-05 22:22
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static TreeNode createTreeNode(int... ints) {
        TreeNode[] treeNodes = new TreeNode[ints.length];
        for (int i = 0; i < treeNodes.length; i++) {
            if (ints[i] == Integer.MIN_VALUE) {
                treeNodes[i] = null;
            } else {
                treeNodes[i] = new TreeNode(ints[i]);
            }
        }
        for (int i = 0; i < treeNodes.length; i++) {
            if (treeNodes[i] == null) {
                continue;
            }
            treeNodes[i].left = 2 * i + 1 < treeNodes.length ? treeNodes[2 * i + 1] : null;
            treeNodes[i].right = 2 * i + 2 < treeNodes.length ? treeNodes[2 * i + 2] : null;
        }
        return treeNodes[0];
    }

    public static TreeNode createTreeNode() {
        return createTreeNode(1, 2, 3, 4, 5, 6, 7);
    }

    public static TreeNode createTreeNode(String string) {
        if (string.contains("[")) {
            string = string.substring(1, string.length() - 1);
        }
        String[] strings = string.split(",");
        int[] integers = Stream.of(strings).mapToInt(new ToIntFunction<String>() {
            @Override
            public int applyAsInt(String s) {
                if (s.equals("null") || s.equals("NULL")) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.parseInt(s);
                }
            }
        }).toArray();
        return createTreeNode(integers);
    }

    public static void printTreeNode(TreeNode treeNode) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(treeNode);
        while (true) {
            if (linkedList.isEmpty()) {
                break;
            }
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode1 = linkedList.poll();
                System.out.print(treeNode1.val + " ");
                if (treeNode1.left != null) {
                    linkedList.offer(treeNode1.left);
                }
                if (treeNode1.right != null) {
                    linkedList.offer(treeNode1.right);
                }
            }
            System.out.println();
        }
    }
}