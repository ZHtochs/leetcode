//给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。 
//
// 实现 Solution class: 
//
// 
// Solution(int[] nums) 使用整数数组 nums 初始化对象 
// int[] reset() 重设数组到它的初始状态并返回 
// int[] shuffle() 返回数组随机打乱后的结果 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Solution", "shuffle", "reset", "shuffle"]
//[[[1, 2, 3]], [], [], []]
//输出
//[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
//
//解释
//Solution solution = new Solution([1, 2, 3]);
//solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 
//1, 2]
//solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
//solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁶ <= nums[i] <= 10⁶ 
// nums 中的所有元素都是 唯一的 
// 最多可以调用 5 * 10⁴ 次 reset 和 shuffle 
// 
// 👍 225 👎 0


package com.huawei.leetcode.editor.cn;

fun main() {
    var nums = intArrayOf(1, 2, 3, 4)
    val solution = P384ShuffleAnArray.Solution(nums)
    val shuffle = solution.shuffle()
    val reset = solution.reset()
    println("!23")
}

//Java：打乱数组
public class P384ShuffleAnArray {


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution(nums: IntArray) {
        var enums: IntArray = nums

        fun reset(): IntArray {
            return enums
        }

        fun shuffle(): IntArray {
            var stack = mutableListOf<Int>(*enums.toTypedArray())
            var newNums = mutableListOf<Int>()
            while (stack.isNotEmpty()) {
                val index = (0 until stack.size).random()
                newNums.add(stack[index])
                stack.removeAt(index)
            }
            return newNums.toIntArray()
        }

    }

    /**
     * Your Solution object will be instantiated and called as such:
     * var obj = Solution(nums)
     * var param_1 = obj.reset()
     * var param_2 = obj.shuffle()
     */
//leetcode submit region end(Prohibit modification and deletion)

}