package com.huawei.offer2.leetcode.editor.cn;

//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints.length <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
// 👍 175 👎 0

import java.util.*;

//Java：最小时间差
public class P539MinimumTimeDifference {
    public static void main(String[] args) {
        Solution solution = new P539MinimumTimeDifference().new Solution();
        List<String> timePoints = new LinkedList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");
        System.out.println(solution.findMinDifference(timePoints));

        timePoints.clear();
        timePoints.add("23:59");
        timePoints.add("00:00");
        timePoints.add("00:00");
        System.out.println(solution.findMinDifference(timePoints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            List<Data> list = new LinkedList<>();
            HashSet<Data> dataSet = new HashSet<>();
            for (String timePoint : timePoints) {
                String[] strings = timePoint.split(":");
                Data data = new Data(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
                list.add(data);
                if (dataSet.contains(data)) {
                    return 0;
                } else {
                    dataSet.add(data);
                }
            }
            Collections.sort(list);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < list.size() - 1; i++) {
                min = Math.min(min, asd(list.get(i + 1), list.get(i)));
            }
            int first = asd(list.get(0), new Data(0, 0));
            int last = asd(new Data(24, 0), list.get(list.size() - 1));
            min = Math.min(min, first + last);
            return min;
        }

        private int asd(Data data1, Data data2) {
            return data1.hour * 60 + data1.min - data2.hour * 60 - data2.min;
        }

        public class Data implements Comparable<Data> {
            int hour;
            int min;

            public Data(int hour, int min) {
                this.hour = hour;
                this.min = min;
            }

            @Override
            public int compareTo(Data data) {
                if (data == this) {
                    return 0;
                }
                if (hour > data.hour) {
                    return 1;
                } else if (data.hour == hour) {
                    return Integer.compare(min, data.min);
                } else {
                    return -1;
                }
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof Data) {
                    Data data2 = (Data) obj;
                    return data2.hour == hour && data2.min == min;
                }
                return false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}