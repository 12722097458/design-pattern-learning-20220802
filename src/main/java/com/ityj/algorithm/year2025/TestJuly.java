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

    //39. 组合总和
    // 回溯算法
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(candidates, result, list, target, 0, 0);
        return result;
    }

    private void backtracking(int[] candidates, List<List<Integer>> result, List<Integer> tmp, int target, int sum, int fromIndex) {
        if (sum > target) {
            return;
        }
        System.out.println("tmp = " + tmp);

        if (sum == target) {

            result.add(new ArrayList<>(tmp));   // 这样 tmp 保存的是组合的瞬时快照，后续回溯不影响已保存的结果。
            return;
        }

        for (int i = fromIndex; i < candidates.length; i++) {
            System.out.println("sum = " + sum);
            tmp.add(candidates[i]);
            backtracking(candidates, result, tmp, target, sum + candidates[i], i);  // sum + candidates[i] 不能作为临时变量放前面
            System.out.println("remove last tmp = " + tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> threeSum_test10(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 重复
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int first = nums[i];
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
                    // 去重
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

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = head;
        ListNode curr = dummyHead;


        for (int i = 0; i < n; i++) {
            head = head.next;
            if (head == null) {
                // 删除倒数第size个元素， 就是删除第一个。
                return dummyHead.next;
            }
        }

        while (true) {
            if (head.next == null) {
                // 断开下一个
                curr.next = curr.next.next;
                break;
            } else {
                head = head.next;
                curr = curr.next;
            }
        }
        return dummyHead;
    }

    public List<List<Integer>> combinationSum_test10(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> tmpList = new ArrayList<>();
        backtracking_test10(candidates, target, 0, 0, tmpList, result);
        return result;
    }

    private void backtracking_test10(int[] candidates, int target, int sum, int fromIndex, List<Integer> tmpList, List<List<Integer>> result) {
        if (sum >= target) {
            if (sum == target) {
                result.add(new ArrayList<>(tmpList));
            }
            return;
        }
        for (int i = fromIndex; i < candidates.length; i++) {

            tmpList.add(candidates[i]);
            backtracking_test10(candidates, target, sum + candidates[i], i, tmpList, result);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public int searchInsert_test11(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int result = -1;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            if (left > right) {
                break;
            }
            int middle = (left + right) / 2;
            if (target == nums[middle]) {
                result = middle;
                break;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return (result == -1) ? left : result;
    }

    public int majorityElement_test11(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int count = 1;
        int winner = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == winner) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    winner = nums[i];
                    count = 1;
                }
            }
        }
        return winner;
    }


    public List<List<Integer>> combinationSum_test11(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        backtracking_test11(candidates, target, result, tmpList, 0, 0);
        return result;
    }

    private void backtracking_test11(int[] candidates, int target, List<List<Integer>> result, List<Integer> tmpList, int sum, int fromIndex) {
        if (sum >= target) {
            if (sum == target) {
                result.add(new ArrayList<>(tmpList));
            }
            return;
        }
        for (int i = fromIndex; i < candidates.length; i++) {
            tmpList.add(candidates[i]);
            backtracking_test11(candidates, target, result, tmpList, sum + candidates[i], i);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    // LCR 034. 验证外星语词典
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        String[] tmp = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            tmp[i] = words[i];
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int count = Math.min(o1.length(), o2.length());
                for (int i = 0; i < count; i++) {
                    char c1 = o1.charAt(i);
                    char c2 = o2.charAt(i);
                    if (c1 == c2) {
                        continue;
                    } else {
                        return map.get(c1) - map.get(c2);
                    }
                }
                return o1.length() - o2.length();
            }
        });
        System.out.println("words = " + Arrays.asList(words));
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != words[i]) {
                return false;
            }
        }
        return true;
    }

    private void shuffle(Integer[] nums) {
        int num = (int) (-0.6);  // 在Java中，使用`(int)`进行强制类型转换时，对于浮点数，它会将小数部分直接截断（即向零取整）。这与`Math.floor()`（向负无穷取整）和`Math.ceil()`（向正无穷取整）不同
        System.out.println("num = " + num);
        Arrays.sort(nums, (o1, o2) -> (int) Math.floor(Math.random() - 0.5));
        System.out.println(Arrays.asList(nums));
    }

    public List<List<Integer>> combinationSum_test16(int[] candidates, int target) {
        List<List<Integer> > result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backtracking_test16(candidates, target, result, tmp, 0, 0);
        return result;
    }

    private void backtracking_test16(int[] candidates, int target, List<List<Integer>> result, List<Integer> tmp, int sum, int fromIndex) {
        if (sum >= target) {
            if (sum == target) {
                result.add(new ArrayList<>(tmp));
            }
            return;
        }
        for (int i = fromIndex; i < candidates.length; i++) {
            tmp.add(candidates[fromIndex]);
            backtracking_test16(candidates, target, result, tmp, sum + candidates[i], i);
            tmp.remove(tmp.size() - 1);
        }
    }


    // 1 -> 4 -> 2 -> 5 -> 9
    public ListNode swapPairs_test21(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;

        while (true) {
            if (pre.next == null || pre.next.next == null) {
                break;
            }
            ListNode tmp1 = pre.next;
            ListNode tmp2 = pre.next.next.next;
            pre.next = pre.next.next;
            pre.next.next = tmp1;
            tmp1.next = tmp2;
            pre = tmp1;
        }
        return dummyHead.next;
    }


    public List<List<Integer>> combinationSum_test21(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        backtracking_test21(candidates, target, result, tmpList, 0, 0);
        return result;
    }

    private void backtracking_test21(int[] candidates, int target, List<List<Integer>> result, List<Integer> tmpList, int sum, int fromIndex) {

        if (sum >= target) {
            if (sum == target) {
                result.add(new ArrayList<>(tmpList));
            }
            return;
        }

        for (int i = fromIndex; i < candidates.length; i++) {

            tmpList.add(candidates[i]);
            backtracking_test21(candidates, target, result, tmpList, sum + candidates[i], i);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    // 1 3 5 6 7  --> 9
    // 1 3 5 6   --> 2
    public int searchInsert_test21(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = -1;
        int left = 0;
        int right = nums.length - 1;

        while (true) {
            if (left > right) {
                break;
            }
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                result = middle;
                break;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return result == -1 ? left : result;
    }

    // 100,4,200,1,3,2
    public int longestConsecutive_test30(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (Integer num : set) {
            // 去从更小的数找
            if (set.contains(num - 1)) {
                continue;
            }
            int count = 1;
            while (true) {
                if (set.contains(++num)) {
                    count++;
                } else {
                    max = Math.max(count, max);
                    break;
                }
            }
        }
        return max;
    }

    public List<List<Integer>> threeSum_test31(int[] nums) {
        // nums = [-1,0,1,2,-1,-4]
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            if (i != 0 && first == nums[i - 1]) {
                // 避免重复
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;

            while (true) {
                if (left >= right) {
                    break;
                }
                if (first + nums[left] + nums[right] == 0) {
                    List<Integer> data = new ArrayList<>();
                    data.add(first);
                    data.add(nums[left]);
                    data.add(nums[right]);
                    result.add(data);
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


    // 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    //输出：[[1,6],[8,10],[15,18]]
    public int[][] merge_0731(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> data = new ArrayList<>();
        int[] tmp = intervals[0];
        data.add(tmp);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] > tmp[1]) {
                // 断开
                tmp = curr;
                data.add(tmp);
            } else {
                tmp[1] = Math.max(tmp[1], curr[1]);
            }
        }

        return data.stream().toArray(int[][]::new);
    }

    public int firstMissingPositive_test0731(int[] nums) {
        boolean oneExist = false;
        for (int num : nums) {
            if (num == 1) {
                oneExist = true;
                break;
            }
        }
        if (!oneExist) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length ) {
                nums[i] = 1;
            }
        }

        for (int num : nums) {
            int index = Math.abs(num);
            nums[index - 1] = -Math.abs(nums[index - 1]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }


    private ListNode frontHead = new ListNode(-1);
    public boolean isPalindrome_test0731(ListNode head) {
        if (head == null) {
            return false;
        }
        frontHead.next = head;
        return check0731(head);
    }

    private boolean check0731(ListNode head) {
        System.out.println(head.val);
        if (head != null) {
            if (!check0731(head.next)) {
                return false;
            }
            if (head.val != frontHead.next.val) {
                return false;
            }
            frontHead = frontHead.next;
        }
        return true;
    }


    // 输入：head = [1,2,3,4]
    //输出：[2,1,4,3]
    public ListNode swapPairs_test0731(ListNode head) {
        if (head == null || head.next == null) {
            return head;
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

    public List<List<Integer>> combinationSum_test0731(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        backTracking_test0731(candidates, target, result, tmpList, 0, 0);
        return result;
    }

    private void backTracking_test0731(int[] candidates, int target, List<List<Integer>> result, List<Integer> tmpList,
                                       int sum, int fromIndex) {

        if (sum >= target) {
            if (sum == target) {
                result.add(new ArrayList<>(tmpList));
            }
            return;
        }

        for (int i = fromIndex; i < candidates.length; i++) {

            tmpList.add(candidates[i]);
            backTracking_test0731(candidates, target, result, tmpList, sum + candidates[i], i);
            tmpList.remove(tmpList.size() - 1);
        }
    }


    // 输入: nums = [1,3,5,6], target = 5
    public int searchInsert_test0731(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (true) {
            if (left > right) {
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

    public int maxProfit(int[] prices) {
        if (prices == null) {
            return -1;
        }

        int max = 0;
        int lowestPrice = prices[0];
        for (int price : prices) {
            if (price < lowestPrice) {
                lowestPrice = price;
            } else {
                max = Math.max(max, price - lowestPrice);
            }
        }
        return max;
    }

    public int majorityElement_test0731(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int winner = nums[0];
        int count = 1;
        for (int num : nums) {
            if (num == winner) {
                count++;
            } else {
                count--;
                if (count < 1) {
                    winner = num;
                    count = 1;
                }
            }
        }
        return winner;
    }

    public int climbStairs_Test0731(int n) {
        int[] arr = new int[n];
        return climb_0731(arr, n);
    }

    private int climb_0731(int[] arr, int n) {
        if (arr[n - 1] != 0) {
            return arr[n - 1];
        }
        if (n == 1) {
            arr[n - 1] = 1;
        } else if (n == 2) {
            arr[n - 1] = 2;
        } else {
            arr[n - 1] = climb_0731(arr, n -1) + climb_0731(arr, n - 2);
        }
        return arr[n - 1];
    }


    @Test
    public void testMethod() throws Throwable {
        int[] arr = {1, 2, 0};
            int i = firstMissingPositive_test0731(arr);
        }

}
