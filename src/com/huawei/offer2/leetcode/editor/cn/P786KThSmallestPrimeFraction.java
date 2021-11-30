package com.huawei.offer2.leetcode.editor.cn;

//给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数 组成，且其中所有整数互不相同。 
//
// 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。 
//
// 那么第 k 个最小的分数是多少呢? 以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == 
//arr[j] 。 
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,5], k = 3
//输出：[2,5]
//解释：已构造好的分数,排序后如下所示: 
//1/5, 1/3, 2/5, 1/2, 3/5, 2/3
//很明显第三个最小的分数是 2/5
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,7], k = 1
//输出：[1,7]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 1000 
// 1 <= arr[i] <= 3 * 10⁴ 
// arr[0] == 1 
// arr[i] 是一个 素数 ，i > 0 
// arr 中的所有数字 互不相同 ，且按 严格递增 排序 
// 1 <= k <= arr.length * (arr.length - 1) / 2 
// 
// 👍 182 👎 0

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//Java：第 K 个最小的素数分数
public class P786KThSmallestPrimeFraction {
    public static void main(String[] args) {
        Solution solution = new P786KThSmallestPrimeFraction().new Solution();

        System.out.println(Arrays.toString(solution.kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));
        System.out.println(Arrays.toString(solution.kthSmallestPrimeFraction(new int[]{1, 7}, 1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            PriorityQueue<Pair> pairs = new PriorityQueue<>(k, Comparator.reverseOrder());
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    Pair pair = new Pair(arr[i], arr[j]);
                    if (pairs.size() < k) {
                        pairs.add(pair);
                    } else {
                        Pair pairMax = pairs.peek();
                        if (pairMax.compareTo(pair) == 1) {
                            pairs.poll();
                            pairs.add(pair);
                        }
                    }
                }
            }
            Pair pair = pairs.peek();
            return new int[]{pair.a, pair.b};
        }

        private class Pair implements Comparable {
            int a;

            int b;

            public Pair(int a, int b) {
                this.a = a;
                this.b = b;
            }

            @Override
            public int compareTo(Object o) {
                Pair pair2 = (Pair) o;
                return Integer.compare(a * pair2.b, b * pair2.a);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}