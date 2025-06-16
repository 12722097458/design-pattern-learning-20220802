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

    // 283. 移动零
    public void moveZeroes(int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                result[index++] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    // 双指针
    public void moveZeroes2(int[] nums) {
        int length = nums.length;
        int left = 0;   // 一直指向0, 已处理的最右侧
        int right = 0;  // 未处理的最左侧, 找到非0就和left互换位置

        while (right < length) {
            // 不等于0就不用换位置
            // 对于index=0, left和right同时指向index0,
            // 1. =0 --> right++, 不做替换。 没问题
            // 2. !=0 -> 进行替换， 然后left++ 指向索引1
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    // 11. 盛最多水的容器
    public int maxArea2_notwork(int[] height) { //timeout error
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            int leftHeight = height[i];
            for (int j = i + 1; j < height.length; j++) {
                int rightHeight = height[j];
                int area = calculateArea(Math.min(leftHeight, rightHeight), (j - i));
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    private int calculateArea(int height, int width) {
        return height * width;
    }

    public int maxArea(int[] height) { //timeout error
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            maxArea = Math.max(calculateArea(Math.min(leftHeight, rightHeight), (right - left)), maxArea);
            if (leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    // 15. 三数之和   指针 beyond my ability
    public List<List<Integer>> threeSum(int[] nums) {
        return null;
    }

    // 3. 无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        List<Character> list = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            while (list.contains(s.charAt(i))) {
                list.remove(0);
            }
            list.add(s.charAt(i));
            result = Math.max(result, list.size());
        }
        return result;
    }

    // 438. 找到字符串中所有字母异位词   不会做
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) {
            return result;
        }

        return result;
    }

    // 136. 只出现一次的数字
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.stream().findFirst().get();
    }

    @Test
    public void testMethod() {
        int[] arr = {0,1,0,3,12};
        String s = "aaaaaaaaaa";
        String p = "aaaaaaaaaaaaa";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println("anagrams = " + anagrams);
    }
}
