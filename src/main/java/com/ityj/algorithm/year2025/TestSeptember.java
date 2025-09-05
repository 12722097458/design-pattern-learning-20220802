package com.ityj.algorithm.year2025;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestSeptember {


    // 输入: s = "abcabcbb"
    //输出: 3
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0 ) {
            return 0;
        }

        int max = 0;
        LinkedList<Character> data = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (data.contains(ch)) {
                while (true) {
                    Character first = data.removeFirst();
                    if (first == ch) {
                        break;
                    }
                }
            }
            data.add(ch);
            max = Math.max(max, data.size());
        }
        return max;
    }


    //输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
    //输出：[3,3,5,5,6,7]
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k > nums.length) {
            return null;
        }
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            int num = nums[i];
            while (!queue.isEmpty() && num > queue.getLast()) {
                queue.removeLast();
            }
            queue.addLast(num);
        }
        result[index++] = queue.getFirst();

        for (int i = k; i < nums.length; i++) {
            int num = nums[i];
            if (!queue.isEmpty() && queue.getFirst() == nums[i - k]) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && num > queue.getLast()) {
                queue.removeLast();
            }
            queue.addLast(num);
            result[index++] = queue.getFirst();
        }
        return result;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        backTracing(candidates, target, result, tmpList, 0, 0);
        return result;
    }

    private void backTracing(int[] candidates, int target, List<List<Integer>> result, List<Integer> tmpList, int sum, int fromIndex) {
        if (sum >= target) {
            if (sum == target) {
                result.add(new ArrayList<>(tmpList));
            }
            return;
        }

        for (int i = fromIndex; i < candidates.length; i++) {
            tmpList.add(candidates[i]);
            backTracing(candidates, target, result, tmpList, sum + candidates[i], i);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    //
    //输入：nums = [1,2,3]
    //输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        sub(nums, result, tmpList, 0);
        return result;
    }

    private void sub(int[] nums, List<List<Integer>> result, List<Integer> tmpList, int fromIndex) {
        result.add(new ArrayList<>(tmpList));
        for (int i = fromIndex; i < nums.length; i++) {
            tmpList.add(nums[i]);
            sub(nums, result, tmpList, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }


    @Test
    public void test1() {
        int[] nums = {-7,-8,7,5,7,1,6,0};

    }
}
