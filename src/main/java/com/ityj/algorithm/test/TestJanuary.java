package com.ityj.algorithm.test;

import org.junit.jupiter.api.Test;

import java.util.*;

public class TestJanuary {

    // 1984. 学生分数的最小差值
    public int minimumDifference(int[] nums, int k) {
        int result = 0;
        if (k == 1) {
            return result;
        }

        Arrays.sort(nums);
        int leftIndex = 0;
        while (true) {
            int rightIndex = k - 1 + leftIndex;
            if (rightIndex == nums.length) {
                break;
            }
            if (leftIndex == 0) {
                result = Math.abs(nums[leftIndex] - nums[rightIndex]);
            } else {
                result = Math.min(result, Math.abs(nums[leftIndex] - nums[rightIndex]));
            }
            leftIndex++;
        }
        return result;
    }


    // 2164. 对奇偶下标分别排序
    // index 奇数 递减
    // index 偶数 递增排列
    public int[] sortEvenOdd(int[] nums) {
        Stack<Integer> oddStack = new Stack<>();  // 栈 先进后出，pop弹出最后一个， 所以奇数栈就递增排列
        Stack<Integer> evenStack = new Stack<>();
        int[] res = new int[nums.length];
        boolean flag = true;
        for (int num : nums) {
            if (flag) {
                evenStack.push(num);
            } else {
                oddStack.push(num);
            }
            flag = !flag;
        }
        evenStack.sort(Comparator.reverseOrder());
        oddStack.sort(Comparator.naturalOrder());
        for (int i = 0; i < res.length; i++) {
            if (i % 2 == 0) {
                res[i] = evenStack.pop();
            } else {
                res[i] = oddStack.pop();
            }

        }
        return res;
    }

    // 1688. 比赛中的配对次数
    public int numberOfMatches(int n) {
        int result = 0;
        while (true) {
            if (n % 2 == 1 && n != 1) {
                result++;
                n--;
            }
            n = n / 2;
            result += n;
            if (n == 0 || n == 1) {
                break;
            }
        }
        return result;
    }
    // 这样更好理解一点，配对的次数=淘汰的人数。因为配对一次，就淘汰一个人
    public int numberOfMatchesBest(int n) {
        return n - 1;
    }


    // 169. 多数元素
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int limit = nums.length / 2 + 1; // 等值于这个数，就是满足条件的值，并且最多有一个
        int currentNum = -1;
        int count = 0;
        for (int num : nums) {
            if (currentNum == num) {
                count++;
                if (count == limit) {
                    return currentNum;
                }
            } else {
                currentNum = num;
                count = 1;
            }
        }
        return -1;
    }

    // 2255. 统计是给定字符串前缀的字符串数目
    public int countPrefixes(String[] words, String s) {
        int result = 0;
        List<String> prefixList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            prefixList.add(sb.append(c).toString());
        }
        for (String word : words) {
            if (prefixList.contains(word)) {
                result++;
            }
        }
        return result;
    }

    public int countPrefixesBest(String[] words, String s) {
        int result = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                result++;
            }
        }
        return result;
    }

    public String thousandSeparator(int n) {
        List<String> list = new ArrayList<>();
        while (true) {
            int prefix = n / 1000;
            int suffix = n % 1000;
            if (prefix == 0) {
                list.add(String.valueOf(suffix));
                break;
            } else {
                // 51040   040需要补一个0
                list.add(addZero(suffix));
            }
            n = prefix;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.insert(0, str).insert(0, ".");
        }
        return sb.substring(1);
    }

    private String addZero(int suffix) {
        StringBuilder result = new StringBuilder(String.valueOf(suffix));
        while (true) {
            if (result.length() == 3) {
                break;
            }
            result.insert(0, "0");
        }
        return result.toString();
    }



    @Test
    public void testDemo() {
        int[] nums = new int[] {3, 2, 3};

        int res = majorityElement(nums);

        System.out.println("res = " + res);

        StringBuilder result = new StringBuilder("SDSA");
        result.append("L");

        System.out.println("result.toString() = " + result.toString());
    }

}


