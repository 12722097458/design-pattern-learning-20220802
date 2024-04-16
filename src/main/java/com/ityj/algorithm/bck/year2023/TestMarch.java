package com.ityj.algorithm.bck.dir2022.year2023;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TestMarch {

    // 2243. 计算字符串的数字和
    public String digitSum(String s, int k) {

        while (true) {
            // 长度 <= k 结束
            if (s.length() <= k) {
                return s;
            }
            int index = 0;
            // 分割后的字符串
            StringBuilder subStr = new StringBuilder();
            while (true) {
                if (index + k >= s.length()) {
                    subStr.append(sum(s.substring(index)));
                    s = subStr.toString();
                    break;
                }
                subStr.append(sum(s.substring(index, index + k)));
                index = index + k;
            }
        }

    }

    // 求和
    public int sum(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            // 需要把char转换成字符串， 再求和
            result += Integer.parseInt(str.charAt(i) + "");
        }
        return result;
    }



    // 844. 比较含退格的字符串
    public boolean backspaceCompare(String s, String t) {
        return resolveCharacter(s).equals(resolveCharacter(t));
    }

    public String resolveCharacter(String str) {
        String reverseStr = new StringBuilder(str).reverse().toString();
        char[] chars = reverseStr.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '#') {
                chars[i] = ' ';
                count++;
            } else {
                if (count > 0) {
                    chars[i] = ' ';
                    count--;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (char aChar : chars) {
            if (aChar != ' ') {
                result.append(aChar);
            }
        }
        return result.toString();
    }

    // 35. 搜索插入位置
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 顺利找到
            if (num == target) {
                return i;
            }
            // 找到比这个大的了
            if (num > target) {
                return i;
            }
        }
        // 未找到，就取最后一位
        return nums.length;
    }

    // 2215. 找出两数组的不同
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> result = new ArrayList<>();
        // nums1 有, nums2没有
        List<Integer> list1 = Arrays.stream(nums1).distinct().filter(n1 -> Arrays.stream(nums2).noneMatch(x -> x == n1)).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2).distinct().filter(n2 -> Arrays.stream(nums1).noneMatch(x -> x == n2)).boxed().collect(Collectors.toList());
        result.add(list1);
        result.add(list2);
        return result;
    }

    // 剑指 Offer 57 - II. 和为s的连续正数序列
    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i < target; i++) {
            int sum = 0;
            List<Integer> subList = new ArrayList<>();
            int num = i;
            while (true) {
                subList.add(num);
                sum += num;
                if (sum == target) {
                    list.add(subList);
                    break;
                }
                if (sum > target) {
                    break;
                }
                num++;
            }
        }
        int[][] res = new int[list.size()][];
        for(int i = 0; i < res.length; i++){
            res[i] = new int[list.get(i).size()];
            for(int j = 0; j < res[i].length; j++){
                res[i][j] = list.get(i).get(j);
            }
        }
        return res;
    }

    // 976. 三角形的最大周长
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2 ; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }

    // 67. 二进制求和
    public String addBinary(String a, String b) {
        // a b 保持一样长
        int maxLength = Math.max(a.length(), b.length());
        if (a.length() == maxLength) {
            int subLength = maxLength - b.length();
            for (int i = 0; i < subLength; i++) {
                b = "0" + b;
            }
        } else {
            int subLength = maxLength - a.length();
            for (int i = 0; i < subLength; i++) {
                a = "0" + a;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = a.length() - 1; i >= 0; i--) {
            int numA = Integer.parseInt(a.charAt(i) + "");
            int numB = Integer.parseInt(b.charAt(i) + "");
            int sum = numA + numB;
            if (flag) {
                sum = sum + 1;
            }
            int prefix = sum / 2;
            int suffix = sum % 2;
            sb.insert(0, suffix);
            if (prefix == 0) {
                flag = false;
            } else {
                flag = true;
            }
        }
        if (flag) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }

    // 1185. 一周中的第几天
    // 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}
    // 需要知道1971年1月1日是星期五
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate defaultDate = LocalDate.of(1971, 1, 1);
        LocalDate curr = LocalDate.of(year, month, day);

        int deltaDays = (int) ((curr.toEpochDay() - defaultDate.toEpochDay()) % 7);

        switch (deltaDays) {
            case 1:
                return "Saturday";
            case 2:
                return "Sunday";
            case 3:
                return "Monday";
            case 4:
                return "Tuesday";
            case 5:
                return "Wednesday";
            case 6:
                return "Thursday";
            case 0:
                return "Friday";
            default:
                throw new RuntimeException("Error data");
        }
    }

    // 819. 最常见的单词
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase(Locale.ROOT);
        String[] arr = paragraph.split("[^a-zA-Z]+");
        Map<String, Integer> map = new HashMap<>();
        // get data with filter
        Arrays.stream(arr).filter(x -> !Arrays.asList(banned).contains(x)).forEach(str -> map.merge(str, 1, (oldValue, newValue) -> oldValue + 1));
        Integer maxCount = map.values().stream().max(Comparator.comparingInt(o -> o)).orElse(0);
        return map.keySet().stream().filter(k -> Objects.equals(map.get(k), maxCount)).findAny().orElse("");
    }

    // 1486. 数组异或操作
    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= (start + 2 * i);
        }
        return result;
    }


    @Test
    public void testDemo() {
        String s = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] arr = {"hit"};
        int i = xorOperation(4, 3);

    }

}


