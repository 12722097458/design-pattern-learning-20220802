package com.ityj.algorithm.year2025;

import com.ityj.algorithm.entity.ListNode;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

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

    // 两个链表右边对齐，对其后一个一个对比即可
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < lengthB - lengthA; i++) {
                headB = headB.next;
            }
        }
        while (true) {
            if (headA == null || headB == null) {
                return null;
            }
            if (headA.equals(headB)) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
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

    // 234. 回文链表   将val放入List中
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        list.add(head.val);
        head = head.next;
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }

    private ListNode frontNode;
    // 递归实现从后到前遍历
    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return false;
        }
        frontNode = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode current) {
        if (current != null) {
             if (!recursivelyCheck(current.next)) {
                 return false;
             }
             if (frontNode.val != current.val) {
                return false;
             }
             frontNode = frontNode.next;
        }
        return true;
    }

    // 141. 环形链表
    // 有环说明存在节点被遍历两次
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // 快慢指针， 如果有环一定会在环里相遇
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowNode = head.next;
        ListNode fastNode = head.next.next;

        while (true) {
            if (fastNode == null || slowNode == null) {
                return false;
            }
            if (slowNode.equals(fastNode)) {
                return true;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if (fastNode == null) {
                return false;
            }
            fastNode = fastNode.next;
        }
    }

    // 142. 环形链表 II
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    // 快慢指针
    // 快慢指针相遇时 快走了2k 慢走了k
    // 加入一个newPtr, newPtr走k，那么slow也又走了k  --> 此时一定相遇(slow k/fast 2k时相遇的)
    // 此时相遇了， 但是不用一定是初次相遇。可能一起走了好几步
    // 因为两者的速度一样，所以相遇点一定是环的入口
    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (true) {
            if (fast == null || slow == null) {
                // 不是环
                return null;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                // 不是环
                return null;
            }
            fast = fast.next;
            if (fast != null && slow != null && fast.equals(slow)) {
                // 相遇了
                ListNode newPtr = head;
                while (true) {
                    if (newPtr.equals(slow)) {
                        // 环的入口
                        return newPtr;
                    }
                    newPtr = newPtr.next;
                    slow = slow.next;
                }
            }
        }
    }

    // 21. 合并两个有序链表
    // 强行解决
    //组装一个顺序的list
    //根据list组装一个Node
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> list = new ArrayList<>();
        while (true) {
            if (list1 == null) {
                break;
            }
            list.add(list1.val);
            list1 = list1.next;
        }

        while (true) {
            if (list2 == null) {
                break;
            }
            list.add(list2.val);
            list2 = list2.next;
        }
        if (list.isEmpty()) {
            return null;
        }
        System.out.println(list.size());
        list = list.stream().sorted().collect(Collectors.toList());
        System.out.println(list);
        return buildNode(list);
    }

    private ListNode buildNode(List<Integer> list) {
        ListNode tailNode = new ListNode(list.get(list.size() - 1));
        for (int i = list.size() - 2; i >= 0 ; i--) {
            ListNode current = new ListNode(list.get(i));
            current.next = tailNode;
            tailNode = current;
        }
        return tailNode;
    }

    private ListNode buildNode2(List<Integer> list) {
        ListNode tmpNode = new ListNode(-1);
        ListNode prev = tmpNode;
        for (Integer num : list) {
            prev.next = new ListNode(num);
            prev = prev.next;
        }
        return tmpNode.next;
    }

    // 递归
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val > list2.val) {
            list2.next = mergeTwoLists2(list2.next, list1);
            return list2;
        } else {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        }
    }

    public ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode tmp = new ListNode(-1);
        ListNode prev = tmp;
        while (true) {
            if (list1 == null || list2 == null) {
                break;
            }
            if (list1.val > list2.val) {
                prev.next = list2;
                list2 = list2.next;
            } else {
                prev.next = list1;
                list1 = list1.next;
            }
            prev = prev.next;
        }

        prev.next = list1 == null ? list2 : list1;
        return tmp.next;
    }

    // 2. 两数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmpNode = new ListNode(-1);
        ListNode prev = tmpNode;

        int tmpNum = 0;
        while (true) {
            if ((l1 == null && l2 == null) && tmpNum == 0) {
                break;
            }
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
            int sum = l1.val + l2.val + tmpNum;
            tmpNum = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            prev.next = new ListNode(sum % 10);
            prev = prev.next;
        }
        return tmpNode.next;
    }

    // 19. 删除链表的倒数第 N 个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int num = 1;
        while (head != null) {
            map.put(num++, head.val);
            head = head.next;
        }
        ListNode tmpNode = new ListNode();
        ListNode prev = tmpNode;
        int target = map.size() - n + 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (key == target) {
                continue;
            }
            prev.next = new ListNode(value);
            prev = prev.next;
        }
        return tmpNode.next;
    }

    // 直接对要删除的节点进行解绑
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int length = getLength(head);
        ListNode tmpNode = new ListNode(-1, head);
        ListNode prev = tmpNode;
        int targetIndex = length - n;
        for (int i = 0; i < targetIndex; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return tmpNode.next;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    // 24. 两两交换链表中的节点
    // https://www.bilibili.com/video/BV1YT411g7br?spm_id_from=333.788.videopod.sections&vd_source=b23569b676ce26126febad3c290b16e8

    // dummyHead -> 1 -> 2 -> 3 -> 4 -> 5 -> null
    //  (1)dummyHead指向 2， 此时1和3都已经断开了，链表无意义。所以需要将1和3暂存起来   dummyHead -> 2
    //  (2) dummyHead -> 2 -> 1
    //  (3) dummyHead -> 2 -> 1 -> 3 -> 4 -> 5 -> null
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        while (curr.next != null && curr.next.next != null) {
            ListNode node1 = curr.next;
            ListNode node2 = curr.next.next.next;

            curr.next = curr.next.next;
            curr.next.next = node1;
            node1.next = node2;
            curr = curr.next.next;
        }
        return dummyHead.next;
    }

    // 148. 排序链表
    // dummyHead -> 3 -> 2 -> 1 -> 5 -> 9 -> null
    // 超时了 todo
    public ListNode sortList(ListNode head) {
        if (head ==null || head.next == null) {
            return head;
        }
        int length = getLength(head);

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        for (int i = 0; i < length - 1; i++) {
            while (curr.next != null && curr.next.next != null) {
                ListNode tempNode = curr.next;
                ListNode tempNode2 = curr.next.next.next;
                if (curr.next.val > curr.next.next.val) {
                    curr.next = curr.next.next;
                    curr.next.next = tempNode;
                    tempNode.next = tempNode2;
                }
                curr = curr.next;
            }
            curr = dummyHead;
        }
        return dummyHead.next;
    }


    @Test
    public void testMethod() throws Throwable {
        int num = 15 & 66;
        System.out.println("num = " + num);

        System.gc();
        finalize();

        int[] arr = {2, 1};
        firstMissingPositive(arr);
    }
}
