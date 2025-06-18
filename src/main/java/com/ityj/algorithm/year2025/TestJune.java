package com.ityj.algorithm.year2025;

import com.ityj.algorithm.entity.ListNode;
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
        Set<Integer> set = new HashSet<>();  // 并没有从小到大排序， [1,2,3,100,4,200]
        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            // 当x-1在集合中时，直接continue，即可  --> 比如当前是2， 里面有更小的1 所以12连续，按1来计算
            if (set.contains(num - 1)) {
                continue;
            }
            // 当x-1不在集合中时，说明在x可以作为第一个值来计算最长连续区间。重新计算x往后的连续序列，并和之前的比较。
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

    // 利用异或的特性 相同两数异或为0
    public int singleNumber2(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }

    // 53. 最大子数组和
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum < 0) {
                max = Math.max(max, sum);
                sum = 0;
            } else {
                max = Math.max(max, sum);

            }
        }
        return max;
    }

    // 56. 合并区间
    public int[][] merge(int[][] intervals) {
        // intervals = [[1,3],[2,6],[8,10],[15,18]]
        Arrays.sort(intervals, Comparator.comparingInt(p -> p[0])); // 按照左端点从小到大排序
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if (list.size() == 0) {
                list.add(interval);
                continue;
            }
            int[] arr = list.get(list.size() - 1);
            int left = arr[0];
            int right = arr[1];

            if (interval[0] > right) {  // 待比较的区间完全在 arr后面 --》 断开了
                list.add(interval);
                continue;
            }

            if (interval[1] > right) {
                arr[1] = interval[1];
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    // 189. 轮转数组
    public void rotate(int[] nums, int k) {
        // 输入: nums = [1,2,3,4,5,6,7], k = 3
        //输出: [5,6,7,1,2,3,4]
        if (k <= 0 || nums.length <= 1 ) {
            return;
        }
        if (k >= nums.length) {
            k = k % nums.length;
        }
        int[] firstArr = new int[nums.length - k];
        int[] kArr = new int[k];

        int index = 0;
        int kIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= firstArr.length) {
                kArr[kIndex++] = nums[i];
            } else {
                firstArr[index++] = nums[i];
            }
        }
        index = 0;
        kIndex = 0;
        for (int i = 0; i < nums.length; i++) {
          if (i < kArr.length) {
              nums[i] = kArr[kIndex++];
          } else {
              nums[i] = firstArr[index++];
          }
        }
    }

    // 三次翻转
    public void rotate2(int[] nums, int k) {
        // 输入: nums = [1,2,3,4,5,6,7], k = 3
        //输出: [5,6,7,1,2,3,4]
        if (k <= 0 || nums.length <= 1 ) {
            return;
        }
        if (k >= nums.length) {
            k = k % nums.length;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[end];
            nums[end] = nums[start];
            nums[start] = tmp;
            start++;
            end--;
        }
    }

    // 238. 除自身以外数组的乘积
    // tech: 数组分成两半，双指针处理，维护两个数组计算对应左边和右边的值
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int leftMultiple = 1;
        int rightMultiple = 1;
        int leftIndex = 1;
        int rightIndex = nums.length - 2;
        int[] leftSumArr = new int[nums.length];
        leftSumArr[0] = 1;
        int[] rightSumArr = new int[nums.length];
        rightSumArr[nums.length - 1] = 1;
        while (true) {
            if (leftIndex > nums.length - 1) {
                break;
            }
            leftSumArr[leftIndex] = leftMultiple * nums[leftIndex - 1];
            leftMultiple = leftSumArr[leftIndex];
            leftIndex++;
            rightSumArr[rightIndex] = rightMultiple * nums[rightIndex + 1];
            rightMultiple = rightSumArr[rightIndex];
            rightIndex--;
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = leftSumArr[i] *rightSumArr[i];
        }
        return result;
    }

    // 41. 缺失的第一个正数
    // 数字是从1开始连续的，排序后找到不连续的即可
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 1;
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i < nums.length + 1; i++) {
            result = i;
            if (!set.contains(i)) {
                return result;
            }
        }
        return result + 1;
    }

    // 160. 相交链表
    // tech Node相等可以用equals()判断
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        set.add(headA);
        ListNode nextA = headA.next;
        while (true) {
            if (nextA == null) {
                break;
            }
            set.add(nextA);
            nextA = nextA.next;
        }

        ListNode nextB = headB;
        while (true) {
            if (nextB == null) {
                break;
            }
            if (set.contains(nextB)) {
                return nextB;
            }
            nextB = nextB.next;
        }
        return null;
    }

    // 206. 反转链表
    // tech 链接中断，双指针
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode current = head;
        while (true) {
            if (current == null) {
                break;
            }
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }


    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        return reverse(null, head);
    }

    private ListNode reverse(ListNode pre, ListNode current) {
        if (current == null) {
            return pre;
        }
        ListNode tmp = current.next;
        current.next = pre;
        pre = current;
        return reverse(pre, tmp);
    }

    // 234. 回文链表  todo
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode reverse = reverseList(head);
        while (true) {

            if (reverse == null || head == null) {
                break;
            }
            if (reverse.val != head.val) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }
        return true;

    }


    @Test
    public void testMethod() throws Throwable {
        System.gc();
        finalize();

        int[] arr = {2, 1};
        firstMissingPositive(arr);
    }
}
