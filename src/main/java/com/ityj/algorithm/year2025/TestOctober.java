package com.ityj.algorithm.year2025;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestOctober {


    // 输入: nums = [0,1,0,3,12]
    // 1,0,0,3,12
    // 1,3,0,0,12
    //输出: [1,3,12,0,0]
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int left = 0;
        int right = 0;
        while (true) {
            if (left > right || right > nums.length - 1) {
                return;
            }
            if (nums[right] != 0) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                left++;
            }
            right++;
        }
    }



    // 输入：nums = [-1,0,1,2,-1,-4]
    //输出：[[-1,-1,2],[-1,0,1]]
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int first = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (true) {
                if (left >= right) {
                    break;
                }
                if (nums[left] + nums[right] + first == 0) {
                    List<Integer> record = new ArrayList<>();
                    record.add(first);
                    record.add(nums[left]);
                    record.add(nums[right]);
                    result.add(record);
                    left++;
                    right--;
                    while (true) {
                        if (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        } else {
                            break;
                        }
                    }
                    while (true) {
                        if (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        } else {
                            break;
                        }
                    }
                } else if (nums[left] + nums[right] + first > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }


    // 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
    //输出：[3,3,5,5,6,7]
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k > nums.length) {
            return null;
        }
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        // 0 - k
        for (int i = 0; i < k; i++) {
            while (true) {
                if (!queue.isEmpty() && queue.getLast() < nums[i]) {
                    queue.removeLast();
                    continue;
                } else {
                    queue.offer(nums[i]);
                    break;
                }
            }
        }
        int index = 0;
        result[index++] = queue.getFirst();

        // 后续的
        for (int i = k; i < nums.length; i++) {

            if (queue.getFirst() == nums[i - k]) {
                queue.removeFirst();
            }

            while (true) {
                if (!queue.isEmpty() && queue.getLast() < nums[i]) {
                    queue.removeLast();
                } else {
                    queue.offer(nums[i]);
                    break;
                }
            }
            result[index++] = queue.getFirst();
        }
        return result;
    }



        @Test
    public void test1() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
            int[] ints = maxSlidingWindow(nums, 3);
            System.out.println("lists = " + Arrays.toString(ints));
        }
}
