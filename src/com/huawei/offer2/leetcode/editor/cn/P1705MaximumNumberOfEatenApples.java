package com.huawei.offer2.leetcode.editor.cn;

//有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后（也就
//是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] =
//= 0 表示。 
//
// 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。 
//
// 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。 
//
// 
//
// 示例 1： 
//
// 输入：apples = [1,2,3,5,2], days = [3,2,1,4,2]
//输出：7
//解释：你可以吃掉 7 个苹果：
//- 第一天，你吃掉第一天长出来的苹果。
//- 第二天，你吃掉一个第二天长出来的苹果。
//- 第三天，你吃掉一个第二天长出来的苹果。过了这一天，第三天长出来的苹果就已经腐烂了。
//- 第四天到第七天，你吃的都是第四天长出来的苹果。
// 
//
// 示例 2： 
//
// 输入：apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
//输出：5
//解释：你可以吃掉 5 个苹果：
//- 第一天到第三天，你吃的都是第一天长出来的苹果。
//- 第四天和第五天不吃苹果。
//- 第六天和第七天，你吃的都是第六天长出来的苹果。
// 
//
// 
//
// 提示： 
//
// 
// apples.length == n 
// days.length == n 
// 1 <= n <= 2 * 10⁴ 
// 0 <= apples[i], days[i] <= 2 * 10⁴ 
// 只有在 apples[i] = 0 时，days[i] = 0 才成立 
// 
// 👍 140 👎 0

import java.util.Comparator;
import java.util.PriorityQueue;

//Java：吃苹果的最大数目
public class P1705MaximumNumberOfEatenApples {
    public static void main(String[] args) {
        Solution solution = new P1705MaximumNumberOfEatenApples().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eatenApples(int[] apples, int[] days) {

            PriorityQueue<Apple> applePriorityQueue = new PriorityQueue<>(Comparator.comparingInt(apple -> apple.day));
            int n = apples.length, time = 0, ans = 0;
            while (time < n || !applePriorityQueue.isEmpty()) {
                if (time < n && apples[time] > 0) {
                    Apple apple = new Apple();
                    apple.day = time + days[time] - 1;
                    apple.count = apples[time];
                    applePriorityQueue.add(apple);
                }

                while (!applePriorityQueue.isEmpty() && applePriorityQueue.peek().day < time)
                    applePriorityQueue.poll();
                if (!applePriorityQueue.isEmpty()) {
                    Apple cur = applePriorityQueue.poll();
                    if (--cur.count > 0 && cur.day > time) applePriorityQueue.add(cur);
                    ans++;
                }
                time++;
            }
            return ans;
        }

        private class Apple {
            int count;
            int day;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}