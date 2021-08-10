package com.huawei.leetcode.editor.cn;

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 
// 👍 168 👎 0

import java.util.List;

public class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        ListNode listNode = ListNode.createList(1);
        ListNode.printInt(solution.reversePrint(listNode));
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
        public int[] reversePrint(ListNode head) {
            int length = 0;
            ListNode temp = head;
            while (temp != null) {
                temp = temp.next;
                length++;
            }
            int[] ints = new int[length];

            for (int i = length - 1; i >= 0; i--) {
                ints[i] = head.val;
                head = head.next;
            }
            return ints;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}