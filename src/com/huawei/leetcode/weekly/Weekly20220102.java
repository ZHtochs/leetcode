package com.huawei.leetcode.weekly;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: offer
 * @author: zhuhe
 * @create: 2022-01-02 10:55
 **/
public class Weekly20220102 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:\\workspace\\offer\\src\\com\\huawei\\leetcode\\weekly\\string.txt");
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String temp = "";
            while ((temp = bufferedReader.readLine()) != null) {
                stringBuilder.append(temp);
            }
        } catch (IOException ioException) {

        }
        String[] strings = stringBuilder.toString().replace(" ", "").split(",");
        int[] ints = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        System.out.println(asteroidsDestroyed(81583, ints));
    }

    public static boolean checkString(String s) {
        if (s == null) {
            return false;
        }
        char[] chars = s.toCharArray();
        int firstB = -1;
        int lastA = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'b') {
                firstB = i;
                break;
            }
        }
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == 'a') {
                lastA = i;
                break;
            }
        }
        if (firstB == -1 || lastA == -1) {
            return true;
        }
        return lastA < firstB;
    }

    public static int numberOfBeams(String[] bank) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < bank.length; i++) {
            String s = bank[i];
            char[] chars = s.toCharArray();
            int count = 0;
            for (char aChar : chars) {
                if (aChar == '1') {
                    count++;
                }
            }
            if (count != 0) {
                arrayList.add(count);
            }
        }
        if (arrayList.size() <= 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < arrayList.size() - 1; i++) {
            sum += arrayList.get(i) * arrayList.get(i + 1);
        }
        return sum;
    }

    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        double doubleMass = mass;
        for (int asteroid : asteroids) {
            if (doubleMass < asteroid) {
                return false;
            } else {
                doubleMass += asteroid;
            }
        }
        return true;
    }

}