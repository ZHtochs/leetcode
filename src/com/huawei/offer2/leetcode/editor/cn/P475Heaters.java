package com.huawei.offer2.leetcode.editor.cn;

//冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。 
//
// 在加热器的加热半径范围内的每个房屋都可以获得供暖。 
//
// 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。 
//
// 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。 
//
// 
//
// 示例 1: 
//
// 
//输入: houses = [1,2,3], heaters = [2]
//输出: 1
//解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
// 
//
// 示例 2: 
//
// 
//输入: houses = [1,2,3,4], heaters = [1,4]
//输出: 1
//解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
// 
//
// 示例 3： 
//
// 
//输入：houses = [1,5], heaters = [2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= houses.length, heaters.length <= 3 * 10⁴ 
// 1 <= houses[i], heaters[i] <= 10⁹ 
// 
// 👍 340 👎 0

import com.huawei.leetcode.editor.cn.BinarySearchTreeIterator;

import java.util.Arrays;

//Java：供暖器
public class P475Heaters {
    public static void main(String[] args) {
        Solution solution = new P475Heaters().new Solution();
//        System.out.println(solution.findRadius(new int[]{1, 2, 3}, new int[]{2}));
//        System.out.println(solution.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        System.out.println(solution.findRadius(new int[]{1, 1, 1, 1, 1, 1, 999, 999, 999, 999, 999}, new int[]{499, 500, 501}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(houses);
            Arrays.sort(heaters);
            int res = 0;
            for (int i = 0; i < houses.length; i++) {
                int house = houses[i];
                int temp = 0;
                for (int j = 0; j < heaters.length; j++) {
                    if (heaters[j] >= house || j == heaters.length - 1) {
                        temp = j;
                        break;
                    }
                }
                if (temp == 0) {
                    res = Math.max(res, Math.abs(heaters[temp] - house));
                } else {
                    res = Math.max(res, Math.min(Math.abs(heaters[temp - 1] - house), Math.abs(heaters[temp] - house)));
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}