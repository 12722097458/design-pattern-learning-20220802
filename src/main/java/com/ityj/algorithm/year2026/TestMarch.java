package com.ityj.algorithm.year2026;

import org.junit.jupiter.api.Test;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

public class TestMarch {


    /*
    *   输入：nums = [2,7,11,15], target = 9
        输出：[0,1]
    * */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(target - nums[i], i);
        }

        int[] res = new int[2];
        Set<Integer> toTargetSet = indexMap.keySet();
        for (int i = 0; i < nums.length; i++) {
            if (toTargetSet.contains(nums[i])) {
                Integer index = indexMap.get(nums[i]);
                if (index == i) {
                    continue;
                }
                res[0] = index;
                res[1] = i;
                return res;
            }
        }
        return res;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                res[0] = indexMap.get(nums[i]);
                res[1] = i;
                return res;
            }
            indexMap.put(target - nums[i], i);
        }
        return res;
    }

    // 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    // 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dataMap = new HashMap<>();
        for (String str : strs) {
            // str按照字母表顺序排序
            String sortedStr = sortStr(str);
            if (dataMap.containsKey(sortedStr)) {
                dataMap.get(sortedStr).add(str);
            } else {
                List<String> objects = new ArrayList<>();
                objects.add(str);
                dataMap.put(sortedStr, objects);
            }
        }
        return new ArrayList<>(dataMap.values());
    }

    private String sortStr(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    // 输入：nums = [100,4,200,1,3,2]
    //输出：4
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = 0;
        Arrays.sort(nums);

        int currenCount = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                continue;
            } else {
                int formerVal = nums[i - 1];
                if (formerVal == nums[i]){
                    continue;
                }
                if (formerVal + 1 == nums[i]) {
                    currenCount++;
                } else {
                    max = Math.max(max, currenCount);
                    currenCount = 1;
                }
            }
        }
        return Math.max(max, currenCount);
    }


    // 输入：nums = [100,4,200,1,3,2]
    //输出：4
    public int longestConsecutive_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int max = 0;
        for (Integer num : set) {
            int currentCount = 1;
            if (set.contains(num - 1)) {
                continue;
            }
            while (true) {
                if (set.contains(++num)) {
                    currentCount++;
                } else {
                    max = Math.max(max, currentCount);
                    break;
                }
            }
        }
        return max;
    }

    // 将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
    // 输入: nums = [0,1,0,3,12]
    //输出: [1,3,12,0,0]
    // 1. 找到非0的数 2.和最左边的0交换位置
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;

        while (true) {

            if (right >= nums.length) {
                break;
            }

            if (nums[left] != 0 && nums[right] != 0) {
                left++;
                right++;
            } else if (nums[left] == 0 && nums[right] == 0) {
                right++;
            } else if (nums[left] == 0 && nums[right] != 0) {
                // 交换
                nums[left] = nums[right];
                nums[right] = 0;
                left++;
                right++;
            } else if (nums[left] != 0 && nums[right] == 0) {
                left++;
                right++;
            }
        }
    }

    // 11. 盛最多水的容器 输入：[1,8,6,2,5,4,8,3,7]
    //输出：49
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (true) {
            if (left >= right) {
                break;
            }
            int xLength = right - left;
            if (height[left] >= height[right]) {
                max = Math.max(xLength * height[right], max);
                right--;
            } else {
                max = Math.max(xLength * height[left], max);
                left++;
            }
        }
        return max;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return null;
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);


        for (int i = 0; i < nums.length; i++) {
            // 连续数字跳过
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int firstNum = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (true) {
                if (left >= right) {
                    break;
                }
                if (nums[left] + nums[right] + firstNum > 0) {
                    right--;
                } else if (nums[left] + nums[right] + firstNum < 0) {
                    left++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(firstNum);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    resultList.add(list);
                    // left++ right-- 需要保证数字不能连续
                    while (true) {
                        if (left == nums.length - 1) {
                            break;
                        }
                        if (nums[left] != nums[++left]) {
                            break;
                        }
                    }
                    while (true) {
                        if (right == 0) {
                            break;
                        }
                        if (nums[right] != nums[--right]) {
                            break;
                        }
                    }
                }
            }
        }
        return resultList;
    }

    // 无重复字符的最长子串
    // 输入: s = "abcabcbb"
    //输出: 3
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int max = 0;
        LinkedList<Character> list = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (!list.contains(ch)) {
                list.addLast(ch);
            } else {
                max = Math.max(max, list.size());
                // remove duplicate character
                while (true) {
                    list.removeFirst();
                    if (!list.contains(ch)) {
                        list.addLast(ch);
                        break;
                    }
                }
            }
        }
        return Math.max(max, list.size());
    }

    // 和为 K 的子数组
    // 输入：nums = [1,2,3], k = 3
    // 输出：2
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = i + 1;
            // 处理第一个值
            int sum = nums[i];
            if (sum == k) {
                res++;
            }

            while (true) {
                if (index >= nums.length) {
                    break;
                }
                sum += nums[index++];
                if (sum == k) {
                    res++;
                }

            }
        }
        return res;
    }


    // 滑动窗口最大值
    // 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
    //输出：[3,3,5,5,6,7]
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        // 处理长度<=k的场景
        if (nums.length <= k) {
            int max = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            return new int[]{max};
        }

        int[] resArr = new int[nums.length - k + 1];
        int index = 0;
        // 队列保存窗口内的数据
        LinkedList<Integer> queue = new LinkedList<>();

        // 处理resArr[0]
        for (int i = 0; i < k; i++) {
            int current = nums[i];
            while (true) {
                if (!queue.isEmpty() && queue.getLast() < current) {
                    queue.removeLast();
                } else {
                    queue.addLast(current);
                    break;
                }
            }
        }
        resArr[index++] = queue.getFirst();

        // 其他
        for (int i = k; i < nums.length; i++) {
            int current = nums[i];
            if (nums[i - k] == queue.getFirst()) {
                queue.removeFirst();
            }
            while (true) {
                if (!queue.isEmpty() && queue.getLast() < current) {
                    queue.removeLast();
                } else {
                    queue.addLast(current);
                    resArr[index++] = queue.getFirst();
                    break;
                }
            }
        }
        return resArr;
    }



    @Test
    public void testtttt() {
        int[] nums = {1,3,1,2,0,5};
        int[] res = maxSlidingWindow(nums, 3);
        System.out.println(res);

    }

}
