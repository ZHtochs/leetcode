package com.huawei.offer2.leetcode.editor.cn;

//给你一个数组 nums ，请你完成两类查询。 
//
// 
// 其中一类查询要求 更新 数组 nums 下标对应的值 
// 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right 
// 
//
// 实现 NumArray 类： 
//
// 
// NumArray(int[] nums) 用整数数组 nums 初始化对象 
// void update(int index, int val) 将 nums[index] 的值 更新 为 val 
// int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元
//素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]） 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["NumArray", "sumRange", "update", "sumRange"]
//[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
//输出：
//[null, 9, null, 8]
//
//解释：
//NumArray numArray = new NumArray([1, 3, 5]);
//numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
//numArray.update(1, 2);   // nums = [1,2,5]
//numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -100 <= nums[i] <= 100 
// 0 <= index < nums.length 
// -100 <= val <= 100 
// 0 <= left <= right < nums.length 
// 调用 pdate 和 sumRange 方法次数不大于 3 * 10⁴ 
// 
// 👍 388 👎 0

//Java：区域和检索 - 数组可修改
public class P307RangeSumQueryMutable {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
     class NumArray {
        private int[] nums;
        private int[] sums;
        private int size;

        public NumArray(int[] nums) {
            this.nums = nums;
            size = (int) Math.ceil(Math.sqrt(nums.length));
            int length = (int) Math.ceil(nums.length * 1.0 / size);
            sums = new int[length];
            for (int i = 0; i < sums.length; i++) {
                for (int j = i * size; j < (i + 1) * size && j < nums.length; j++) {
                    sums[i] = sums[i] + nums[j];
                }
            }
        }

        public void update(int index, int val) {
            int num = nums[index];
            int diff = val - num;
            nums[index] = val;
            int position = index / size;
            sums[position] += diff;

        }

        public int sumRange(int left, int right) {
            int b1 = left / size, i1 = left % size, b2 = right / size, i2 = right % size;
            if (b1 == b2) { // 区间 [left, right] 在同一块中
                int sum = 0;
                for (int j = left; j <= right; j++) {
                    sum += nums[j];
                }
                return sum;
            }
            int sum1 = 0;
            for (int j = i1; j < size; j++) {
                sum1 += nums[b1 * size + j];
            }
            int sum2 = 0;
            for (int j = 0; j <= i2; j++) {
                sum2 += nums[b2 * size + j];
            }
            int sum3 = 0;
            for (int j = b1 + 1; j < b2; j++) {
                sum3 += sums[j];
            }
            return sum1 + sum2 + sum3;
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}