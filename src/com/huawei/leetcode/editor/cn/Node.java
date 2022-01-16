package com.huawei.leetcode.editor.cn;

/**
 * @program: offer
 * @author: zhuhe
 * @create: 2022-01-16 16:59
 **/
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};