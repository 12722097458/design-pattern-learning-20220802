package com.ityj.algorithm.year2025;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestAugust {

    public List<List<Integer>> threeSum_test13(int[] nums) {
        // nums = [-1,0,1,2,-1,-4]
        if (nums == null || nums.length < 3) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // nums = [-4,-1,-1,0,1,2]


        for (int i = 0; i < nums.length - 1; i++) {
            int first = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            if (i != 0 && first == nums[i - 1]) {
                continue;
            }

            while (true) {
                if (left >= right) {
                    break;
                }
                if (first + nums[left] + nums[right] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(first);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
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
                } else if (first + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }


    @Test
    public void test1() {
        int[] nums = {-4,-1,-1,0,1,2};
        List<List<Integer>> lists = threeSum_test13(nums);
        System.out.println("lists = " + lists);
    }
}
