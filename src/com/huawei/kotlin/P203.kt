package com.huawei.kotlin

import com.huawei.leetcode.editor.cn.ListNode

fun main(args: Array<String>) {
    val a = ListNode.createList(1, 3, 4, 4, 5)
    var lista = Solution().removeElements(a, 4)
    print("123")
}

class Solution {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val head2 = ListNode(Int.MIN_VALUE)
        head2.next = head
        var newHead = head2
        while (true) {
            if (newHead.next == null) return head2.next
            if (newHead.next.`val` == `val`) newHead.next = newHead.next.next else newHead = newHead.next
        }
    }
}