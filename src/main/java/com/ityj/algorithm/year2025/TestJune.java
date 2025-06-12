package com.ityj.algorithm.year2025;

import org.junit.jupiter.api.Test;

import java.util.*;

public class TestJune {


    // 1. 两数之和
    public int[] twoSum(int[] nums, int target) {
        int[] resultIndex = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            resultIndex[0] = i;
            int firstNum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int secondNum = nums[j];
                if (firstNum + secondNum == target) {
                    resultIndex[1] = j;
                    return resultIndex;
                }
            }
        }
        System.out.println("not found!");
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            if (map.containsKey(target - currentValue)) {
                return new int[] {i, map.get(target - currentValue)};
            } else {
                map.put(currentValue, i);
            }
        }
        System.out.println("not found!");
        return null;
    }

    // 49. 字母异位词分组
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        for (String str : strs) {
            String orderedStr = sortStr(str);
            if (strMap.containsKey(orderedStr)) {
                strMap.get(orderedStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                strMap.put(orderedStr, list);
            }
        }
        return new ArrayList<>(strMap.values());
    }

    private String sortStr(String str) {
        if (str.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        for (char ch : charArray) {
            sb.append(ch);
        }
        return sb.toString();
    }

    // 128. 最长连续序列
    // 1.要先用set去重
    //2.；
    public int longestConsecutive(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            // 当x-1在集合中时，直接continue，即可
            if (set.contains(num - 1)) {
                continue;
            }
            // 当x-1不在集合中时，说明在x这个值断开了，那么重新计算x往后的连续序列，并和之前的比较。
            int y = num + 1;
            while (set.contains(y)) {
                y++;
            }
            // 循环结束后，y-1 是最后一个在哈希集合中的数
            max = Math.max(max, y - num); // 从 x 到 y-1 一共 y-x 个数

        }
        return max;
    }


    @Test
    public void testMethod() {
        int[] arr = {6};
        int i = longestConsecutive(arr);
        System.out.println("i = " + i);
    }
}
