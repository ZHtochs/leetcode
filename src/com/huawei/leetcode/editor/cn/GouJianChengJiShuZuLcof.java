package com.huawei.leetcode.editor.cn;

//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// Related Topics 数组 前缀和 
// 👍 142 👎 0

public class GouJianChengJiShuZuLcof {
    public static void main(String[] args) {
        Solution solution = new GouJianChengJiShuZuLcof().new Solution();
        ListNode.printInt(solution.constructArr(new int[]{1, 2, 3, 4, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArr(int[] a) {
            int[] front = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                if (i == 0) {
                    front[0] = 1;
                } else {
                    front[i] = front[i - 1] * a[i - 1];
                }
            }
            int[] back = new int[a.length];
            for (int i = a.length - 1; i >= 0; i--) {
                if (i == a.length - 1) {
                    back[a.length - 1] = 1;
                } else {
                    back[i] = back[i + 1] * a[i + 1];
                }
            }
            int[] res = new int[a.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = front[i] * back[i];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}