package com.huawei.offer2.leetcode.editor.cn;

//给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i 
//+ 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,3,6]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：arr = [2,1,2,6]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [4,-2,2,-4]
//输出：true
//解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= arr.length <= 3 * 10⁴ 
// arr.length 是偶数 
// -10⁵ <= arr[i] <= 10⁵ 
// 
// 👍 148 👎 0

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.ToIntFunction;

//Java：二倍数对数组
public class P954ArrayOfDoubledPairs {
    public static void main(String[] args) {
        Solution solution = new P954ArrayOfDoubledPairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canReorderDoubled(int[] arr) {
            HashMap<Integer, Integer> hashMap = new HashMap<>(arr.length / 2);
            for (int i1 : arr) {
                hashMap.put(i1, hashMap.getOrDefault(i1, 0) + 1);
            }
            if (hashMap.containsKey(0)) {
                if (hashMap.get(0) % 2 != 0) {
                    return false;
                } else {
                    hashMap.remove(0);
                }
            }
            ArrayList<Integer> arrayList = new ArrayList<>(hashMap.keySet());
            Collections.sort(arrayList, new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return Math.abs(integer) - Math.abs(t1);
                }
            });
            for (Integer integer : arrayList) {
                int integer1 = hashMap.get(integer);
                if (integer1 == 0) {
                    continue;
                }
                int integer2 = hashMap.getOrDefault(integer * 2, 0);
                if (integer1 > integer2) {
                    return false;
                }
                hashMap.put(integer * 2, integer2 - integer1);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}