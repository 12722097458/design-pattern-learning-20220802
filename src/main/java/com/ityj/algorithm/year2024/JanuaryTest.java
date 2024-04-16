package com.ityj.algorithm.year2024;

import java.util.Arrays;

public class JanuaryTest {

    //14. 最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        int minLength = Arrays.stream(strs).mapToInt(String::length).min().getAsInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            char tmp = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != tmp) {
                    return sb.toString();
                }
            }
            sb.append(tmp);
        }
        return sb.toString();
    }


    // 1385. 两个数组间的距离值
    //      1.1 两个数组需要互相计算
    // 在arr2中找与arr[i]最相近的数，如果连最相近的数绝对值差都大于d，那么其他就更不用考虑了
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        int res = 0;
        for (int i = 0; i < arr1.length; i++) {
            int first = arr1[i];
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(first - arr2[j]) <= d) {
                    break;
                }
                if (j == arr2.length - 1) {
                    res++;
                }
            }
        }
        return res;
    }

}
