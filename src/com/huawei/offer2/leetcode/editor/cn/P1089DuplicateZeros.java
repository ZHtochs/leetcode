package com.huawei.offer2.leetcode.editor.cn;

//给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。 
//
// 注意：请不要在超过该数组长度的位置写入元素。 
//
// 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。 
//
// 
//
// 示例 1： 
//
// 输入：[1,0,2,3,0,4,5,0]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
// 
//
// 示例 2： 
//
// 输入：[1,2,3]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10000 
// 0 <= arr[i] <= 9 
// 
// 👍 190 👎 0

import java.util.Arrays;

//Java：复写零
public class P1089DuplicateZeros {
    public static void main(String[] args) {
        Solution solution = new P1089DuplicateZeros().new Solution();
        int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        solution.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void duplicateZeros(int[] arr) {
            int n = arr.length;
            //两个指针
            int top = 0;
            int i = -1;
            while (top < n) {
                i++;
                //遇到0则top多向右移动一步 模拟添加一个0
                if (arr[i] == 0) {
                    top++;
                }
                top++;
            }
            //有可能最后的arr[i]是一个0 会多移动两步，再移动回来
            if (top > n) {
                top = top - 2;
                arr[top] = 0;
                top--;
                i--;
            } else {
                //不是0则移动出去一步
                top--;
            }
            while (top >= 0) {
                //从右向左填充数据
                arr[top] = arr[i];
                top--;
                //是0 则多向左移动一步 多添加一个0
                if (arr[i] == 0) {
                    arr[top] = 0;
                    top--;
                }
                i--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}