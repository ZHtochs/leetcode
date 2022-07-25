package com.huawei.offer2.leetcode.editor.cn;

//给定一个整数数组 asteroids，表示在同一行的行星。 
//
// 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。 
//
// 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：asteroids = [5,10,-5]
//输出：[5,10]
//解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。 
//
// 示例 2： 
//
// 
//输入：asteroids = [8,-8]
//输出：[]
//解释：8 和 -8 碰撞后，两者都发生爆炸。 
//
// 示例 3： 
//
// 
//输入：asteroids = [10,2,-5]
//输出：[10]
//解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。 
//
// 
//
// 提示： 
//
// 
// 2 <= asteroids.length <= 10⁴ 
// -1000 <= asteroids[i] <= 1000 
// asteroids[i] != 0 
// 
// 👍 314 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Java：行星碰撞
public class P735AsteroidCollision {
    public static void main(String[] args) {
        Solution solution = new P735AsteroidCollision().new Solution();
        System.out.println(Arrays.toString(solution.asteroidCollision(new int[]{-2, 1, -2, -2})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            List<Integer> collect = Arrays.stream(asteroids).boxed().collect(Collectors.toList());
            List<Integer> temp = new ArrayList<>();
            while (true) {
                boolean crashed = false;
                int size = collect.size();
                for (int i = 0; i < size; i++) {
                    //他和她右边方向想通
                    if (i == size - 1) {
                        temp.add(collect.get(i));
                        break;
                    }
                    int now = collect.get(i);
                    int next = collect.get(i + 1);
                    if ((now > 0 && next > 0) || now < 0 && next < 0) {
                        temp.add(collect.get(i));
                    } else if (now > 0 && next < 0) {
                        crashed = true;
                        if (now + next > 0) {
                            temp.add(now);
                        } else if (now + next != 0) {
                            temp.add(next);
                        }
                        i += 1;
                    } else {
                        temp.add(now);
                    }
                }
                if (!crashed) {
                    break;
                }
                collect.clear();
                List<Integer> temp2 = collect;
                collect = temp;
                temp = temp2;
            }
            return collect.stream().mapToInt(Integer::intValue).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}