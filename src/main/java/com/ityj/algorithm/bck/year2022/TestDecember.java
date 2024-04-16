package com.ityj.algorithm.bck.year2022;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class TestDecember {

    // 1929. 数组串联
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2 * nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums[i % nums.length];
        }
        return ans;
    }

    //  Offer 21. 调整数组顺序使奇数位于偶数前面
    public int[] exchange(int[] nums) {

        if (nums.length == 0) {
            return nums;
        }
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int[] res = new int[nums.length];
        for (int num : nums) {
            if (num % 2 == 0) {
                res[rightIndex--] = num;
            } else {
                res[leftIndex++] = num;
            }
        }
        return res;
    }

    // 20. 有效的括号
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        while (!"".equals(s)) {
            String temp = s.replace("()", "").replace("{}", "").replace("[]", "");
            if (s.equals(temp)) {
                return false;
            }
            s = temp;
        }
        return true;
    }

    public boolean isValid2(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

    public int findMaxK(int[] nums) {
        List<Integer> greaterZero  = new ArrayList<>();
        List<Integer> lessZero  = new ArrayList<>();
        for (int num : nums) {
            if (num > 0) {
                greaterZero.add(num);
            } else {
                lessZero.add(num);
            }
        }
        greaterZero.sort(Comparator.reverseOrder());
        for (Integer num : greaterZero) {
            if (lessZero.contains(-num)) {
                return num;
            }
        }
        return -1;
    }

    public int maxPower(String s) {
        int maxLength = 0;
        int length = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                length = 1;
                maxLength = length;
                continue;
            }
            if (chars[i] == chars[i - 1]) {
                length++;
                maxLength = Math.max(length, maxLength);
            } else {
                length = 1;
            }
        }
        return maxLength;
    }

    public double average(int[] salary) {
        int max = salary[0];
        int min = salary[0];
        int sum = 0;
        for (int num : salary) {
            sum += num;
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        return (double) (sum - max - min) / (salary.length - 2);
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        if (numExchange > numBottles) {
            return numBottles;
        }
        int result = numBottles;
        while (true) {
            int toExchangeNum = numBottles / numExchange;
            int left = numBottles % numExchange;
            result += toExchangeNum;
            numBottles = toExchangeNum + left;
            if (toExchangeNum + left < numExchange) {
                break;
            }
        }
        return result;
    }

    public double calculateTax(int[][] brackets, int income) {

        double resTax = 0D;
        if (income == 0) {
            return resTax;
        }

        for (int i = 0; i < brackets.length; i++) {
            int[] bracket = brackets[i];
            int limit = bracket[0];
            int percentage = bracket[1];
            if (income <= limit) {
                int money = i == 0 ? income : income - brackets[i - 1][0];
                resTax += money * (percentage / 100D);
                break;
            } else {
                int money = i == 0 ? limit : limit - brackets[i - 1][0];
                resTax += money * (percentage / 100D);
            }
        }
        return resTax;
    }

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public int prefixCount(String[] words, String pref) {
        int result = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                result++;
            }
        }
        return result;
    }

    public String reverseBits(int num) {

        StringBuilder sb = new StringBuilder();
        while (true) {
            int fin = num % 2;
            int par = num / 2;
            sb.append(fin);
            if (par == 0) {
                break;
            }
            num = par;
        }
        return sb.reverse().toString();
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int n1 = nums1[i];
            int nextGreaterElement = -1;
            boolean flag = false;
            for (int n2 : nums2) {
                if (n2 == n1) {
                    flag = true;
                }
                if (flag && n2 > n1) {
                    nextGreaterElement = n2;
                    break;
                }
            }
            result[i] = nextGreaterElement;
        }
        return result;
    }

    @Test
    public void testDemo() {
        int[] salary = new int[] {4000,3000,1000,2000};
        double average = average(salary);
        System.out.println("average = " + average);

        String s = reverseBits(7);
        System.out.println("s = " + s);
    }

}


