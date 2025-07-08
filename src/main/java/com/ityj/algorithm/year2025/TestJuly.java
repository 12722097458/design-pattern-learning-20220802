package com.ityj.algorithm.year2025;

import com.ityj.algorithm.entity.ListNode;
import com.ityj.algorithm.entity.Student;
import com.ityj.algorithm.entity.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestJuly {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = pre;
            pre = tmp;
        }
        return pre;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        middle(list, root);
        return list;

    }

    private void middle(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        middle(list, root.left);
        list.add(root.val);
        middle(list, root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        return climb(arr, n);
    }

    private int climb(int[] arr, int n) {
        if (arr[n] != 0) {
            return arr[n];
        }
        if (n == 1) {
            arr[n] = 1;
        } else if (n == 2) {
            arr[n] = 2;
        } else {
            arr[n] = climb(arr, n -1) + climb(arr, n - 2);
        }
        return arr[n];
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
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
        return dummyHead.next;
    }

    // 279. 完全平方数
    public int numSquares(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.MAX_VALUE;
            // f[n] = Math.min(f[n - j * j] + 1, f[n]);
            for (int j = 1; j * j <= i; j++) {
                arr[i] = Math.min(arr[i - j * j] + 1, arr[i]);
            }
        }
        return arr[n];
    }

    // [0,1,0,3,12]
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (true) {
            if (left > right || right > nums.length - 1) {
                break;
            }
            if (nums[right] != 0) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                left++;
                right++;
            } else {
                right++;
            }
        }
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (true) {
            if (left > right) {
                break;
            }
            int leftHeight = height[left];
            int rightHeight = height[right];
            int area = (right - left) * Math.min(leftHeight, rightHeight);
            max = Math.max(area, max);
            if (leftHeight > rightHeight) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
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
                int leftValue = nums[left];
                int rightValue = nums[right];
                if (leftValue + rightValue + first == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(first);
                    list.add(leftValue);
                    list.add(rightValue);
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
                } else if (leftValue + rightValue + first > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }


    public int firstMissingPositive(int[] nums) {
        int result = 1;
        if (nums == null) {
            return result;
        }
        boolean oneExist = false;
        for (int num : nums) {
            if (num == 1) {
                oneExist = true;
                break;
            }
        }
        if (!oneExist) {
            return result;
        }

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > n || nums[i] <= 0) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int value = Math.abs(nums[i]);
            nums[value - 1] = -Math.abs(nums[value - 1]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result = i + 1;
                break;
            }
        }
        return result == 1 ? n + 1 : result;
    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows[i] || columns[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public ListNode swapPairs_test(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;

        while (true) {
            if (cur.next == null || cur.next.next == null) {
                break;
            }
            ListNode tmp = cur.next;
            ListNode tmp2 = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = tmp;
            tmp.next = tmp2;
            cur = tmp;
        }
        return dummyHead.next;
    }

    // 92. 反转链表 II
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return head;
        }
        int count = 0;
        ListNode dummyHead = new ListNode(-1);
        ListNode leftNode = dummyHead;
        ListNode middleNode = null;
        while (true) {
            if (head == null) {
                break;
            }
            count++;
            System.out.println("count = " + count);
            if (count < left) {
                leftNode.next = head;
                leftNode = leftNode.next;
                head = head.next;
            } else if (left <= count && count <= right) {
                ListNode tmp = head;
                head = head.next;
                tmp.next = middleNode;
                middleNode = tmp;
                System.out.println("middleNode = " + middleNode.val);
            } else {
                break;
            }
        }

        if (middleNode == null) {
            while (head != null) {
                leftNode.next = head;
                head = head.next;
                leftNode = leftNode.next;
            }
        } else {
            while (middleNode != null) {
                System.out.println("middleNode.val = " + middleNode.val);
                leftNode.next = middleNode;
                middleNode = middleNode.next;
                leftNode = leftNode.next;
            }
            while (head != null) {
                leftNode.next = head;
                head = head.next;
                leftNode = leftNode.next;
            }
        }
        return dummyHead.next;
    }

    public int majorityElement(int[] nums) {
        if (nums == null) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int winner = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            if (val == winner) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    winner = val;
                    count = 1;
                }
            }
        }
        return winner;
    }

    public ListNode swapPairs_test2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (true) {
            if (cur.next == null || cur.next.next == null) {
                break;
            }
            ListNode tmp = cur.next;
            ListNode tmp2 = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = tmp;
            tmp.next = tmp2;
            cur = tmp;
        }
        return dummyHead.next;
    }

    public int majorityElement_test(int[] nums) {
        if (nums == null) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int count = 1;
        int winner = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            if (value == winner) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    winner = value;
                    count = 1;
                }
            }
        }
        return winner;
    }

    // 560. 和为 K 的子数组
    public int subarraySum(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        int result = 0;

        int left = 0;
        int right = 0;
        int sum = 0;
        while (true) {
            if (left >= nums.length) {
                break;
            }
            sum += nums[right];
            right++;
            if (sum == k) {
                result++;
            }
            if (right >= nums.length) {
                sum = 0;
                left++;
                right = left;
            }
        }
        return result;
    }

    public static int countOccurrences(String str, String subStr) {
        if (str == null || subStr == null || str.isEmpty() || subStr.isEmpty()) {
            return 0;
        }
        if (subStr.length() > str.length()) {
            return 0;
        }
        int result = 0;
        int left = 0;
        int right = subStr.length();
        while (true) {
            if (right > str.length()) {
                break;
            }
            String cur = str.substring(left, right);
            if (subStr.equals(cur)) {
                result++;
            }
            left++;
            right++;
        }
        return result;
    }

    public ListNode swapPairs_test8(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (true) {
            if (cur.next == null || cur.next.next == null) {
                break;
            }
            ListNode tmp = cur.next;
            ListNode tmp2 = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = tmp;
            tmp.next = tmp2;
            cur = tmp;
        }
        return dummyHead.next;
    }


        @Test
    public void testMethod() throws Throwable {
        int[] arr = {1, 1, 1};
        int i = subarraySum(arr, 2);
        System.out.println("i = " + i);

        int i1 = countOccurrences("abababab", "ab");
        System.out.println("i1 = " + i1);
        }

}
