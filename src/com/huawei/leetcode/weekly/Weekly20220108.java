package com.huawei.leetcode.weekly;

import com.huawei.leetcode.editor.cn.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.logging.Handler;

/**
 * @program: offer双周赛
 * @author: zhuhe
 * @create: 2022-01-08 22:26
 **/
public class Weekly20220108 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome(new String[]{"lc", "cl", "gg"}));
        System.out.println(longestPalindrome(new String[]{"ab", "ty", "yt", "lc", "cl", "ab"}));
        System.out.println(longestPalindrome(new String[]{"cc", "ll", "xx"}));
        ;
    }

    public static String capitalizeTitle(String title) {
        String[] strings = title.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            String temp = strings[i];
            if (temp.length() <= 2) {
                stringBuilder.append(temp.toLowerCase());
            } else {
                char[] methodName = temp.toLowerCase().toCharArray();
                methodName[0] = Character.toUpperCase(methodName[0]);
                stringBuilder.append(new String(methodName));
            }
            if (i != strings.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static int pairSum(ListNode head) {
        ArrayList<ListNode> arrayList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head);
            head = head.next;
        }
        int i = 0;
        int j = arrayList.size() - 1;
        int res = 0;
        while (i < j) {
            res = Math.max(res, arrayList.get(i).val + arrayList.get(j).val);
            i++;
            j--;
        }
        return res;
    }

    private static Map<String, String> map = new HashMap<>();

    public static int longestPalindrome(String[] words) {
        for (int i = 'a'; i <= 'z'; i++) {
            for (int j = 'a'; j <= 'z'; j++) {
                map.put("" + (char) i + (char) j, "" + (char) j + (char) i);
            }
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }
        int pair = 0;
        int self = 0;
        for (String s : words) {
            if (!hashMap.containsKey(s)) {
                continue;
            }
            String temp = map.get(s);
            if (hashMap.containsKey(temp)) {
                char[] chars = s.toCharArray();
                if (chars[0] == chars[1]) {
                    int count = hashMap.get(s);
                    if (count == 1) {
                        hashMap.remove(s);
                        self++;
                    } else if (count == 2) {
                        hashMap.remove(s);
                        pair++;
                    } else {
                        removeSelf(hashMap, s);
                        removeSelf(hashMap, s);
                        pair++;
                    }
                } else {
                    pair++;
                    removeSelf(hashMap, s);
                    removeSelf(hashMap, temp);
                }

            }
        }
        if (pair == 0 && self == 0) {
            return 0;
        } else if (pair == 0 && self != 0) {
            return 2;
        } else if (pair != 0 && self == 0) {
            return pair * 4;
        } else {
            return pair * 4 + 2;

        }
    }

    private static void removeSelf(HashMap<String, Integer> hashMap, String key) {
        Integer integer2 = hashMap.getOrDefault(key, 0);
        if (integer2 == 1) {
            hashMap.remove(key);
        } else if (integer2 > 1) {
            hashMap.put(key, integer2 - 1);
        }
    }

}