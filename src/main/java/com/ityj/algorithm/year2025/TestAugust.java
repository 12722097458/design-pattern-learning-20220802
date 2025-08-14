package com.ityj.algorithm.year2025;

import com.ityj.algorithm.entity.ListNode;
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

    // 输入：nums = [1,2,3], k = 3
    //输出：2
    public int subarraySum_test14(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k) {
                result++;
            }
            int j = i + 1;
            while (true) {
                if (j >= nums.length) {
                    break;
                }
                sum += nums[j];
                if (sum == k) {
                    result++;
                }
                j++;
            }
        }
        return result;
    }

    // 输入：head = [1,2,3,4,5]
    //输出：[5,4,3,2,1]
    public ListNode reverseList_test14(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        while (true) {
            if (head == null) {
                break;
            }
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }


    private ListNode front = new ListNode(-1);
    public boolean isPalindrome_test14(ListNode head) {
        if (head == null) {
            return false;
        }
        front.next = head;
        return check(head);

    }

    private boolean check(ListNode head) {
        if (head != null) {
            if (!check(head.next)) {
                return false;
            }
            if (head.val != front.next.val) {
                return false;
            }
            front = front.next;
        }
        return true;
    }

    // 输入：head = [1,2,3,4]
    //输出：[2,1,4,3]
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (true) {
            if (pre.next == null || pre.next.next == null) {
                break;
            }
            ListNode tmp = pre.next;
            ListNode tmp2 = pre.next.next.next;
            pre.next = pre.next.next;
            pre.next.next = tmp;
            tmp.next = tmp2;
            pre = tmp;
        }
        return dummy.next;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        backTracking_0814(candidates, target, result, tmpList, 0, 0);
        return result;
    }

    private void backTracking_0814(int[] candidates, int target, List<List<Integer>> result,
                                   List<Integer> tmpList, int sum, int fromIndex) {
        if (sum >= target) {
            if (sum == target) {
                result.add(new ArrayList<>(tmpList));
            }
            return;
        }

        for (int i = fromIndex; i < candidates.length; i++) {
            tmpList.add(candidates[i]);
            backTracking_0814(candidates, target, result, tmpList, sum + candidates[i], i);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    // 输入: nums = [1,3,5,6], target = 5
    //输出: 2
    public int searchInsert(int[] nums, int target) {

        if (nums == null) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (true) {
            if (left >= right) {
                break;
            }
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }


        @Test
    public void test1() {
        int[] nums = {-4,-1,-1,0,1,2};
        List<List<Integer>> lists = threeSum_test13(nums);
        System.out.println("lists = " + lists);
    }
}
