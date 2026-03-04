package com.ityj.algorithm.bck.year2025;

import org.junit.jupiter.api.Test;

import java.util.*;

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

    // 冒泡排序 912. 排序数组
    // 1 3 4 2 5 1
    public int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                // 当前循环没有交换任何数据，即排序正常
                return nums;
            }
        }
        return nums;
    }


    public int[] maxSlidingWindow_0916(int[] nums, int k) {
        if (nums == null || k > nums.length) {
            return null;
        }

        int[] result = new int[nums.length - k + 1];

        LinkedList<Integer> queue = new LinkedList<>();
        // 前k个
        for (int i = 0; i < k; i++) {
            while (true) {
                if (!queue.isEmpty() && nums[i] > queue.getLast()) {
                    queue.removeLast();
                } else {
                    queue.addLast(nums[i]);
                    break;
                }
            }
        }
        int index = 0;
        result[index++] = queue.getFirst();

        // 后面的
        for (int i = k; i < nums.length; i++) {
            if (!queue.isEmpty() && queue.getFirst() == nums[i - k]) {
                queue.removeFirst();
            }

            while (true) {
                if (!queue.isEmpty() && nums[i] > queue.getLast()) {
                    queue.removeLast();
                } else {
                    queue.addLast(nums[i]);
                    break;
                }
            }
            result[index++] = queue.getFirst();
        }
        return result;
    }

    // 给出n个正整数 4;(1 ≤i≤ n)支持两种操作:
    //1.删除两个相同的数，添加这两个数之和
    //2.删除两个数，添加这两个数中的最大值
    //已知通过n - 1次操作后，只剩下一个数，求这个数的最大值，

    public static int getMaxValue(int count, int[] nums) {

        // Scanner输入两行，第一行是总数，第二行是数组
        Scanner scanner = new Scanner(System.in);
        String st = scanner.nextLine();
        count = Integer.parseInt(st);
        System.out.println("st = " + st);
        /*count = scanner.nextInt();
        scanner.nextLine();
        System.out.println("count = " + count);*/
        String arrStr = scanner.nextLine();
        String[] splitArr = arrStr.split(" ");
        for (int i = 0; i < splitArr.length; i++) {
            nums[i] = Integer.parseInt(splitArr[i]);
        }
        System.out.println(Arrays.toString(nums));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }

        while (true) {
            if (!queue.isEmpty() && queue.size() > 1) {
                int first = queue.poll();
                int second = queue.poll();
                if (first == second) {
                    queue.add(first + second);
                } else {
                    queue.add(Math.max(first, second));
                }
            } else {
                break;
            }
        }
        return queue.peek();
    }


    public static void main(String[] args) {
        int[] nums = {-7,-8,7};

        int maxValue = getMaxValue(4, nums);
        System.out.println("maxValue = " + maxValue);
    }


    @Test
    public void test1() {
        int[] nums = {-7,-8,7,5,7,1,6,0};

        int maxValue = getMaxValue(4, nums);
        System.out.println("maxValue = " + maxValue);

    }
}
