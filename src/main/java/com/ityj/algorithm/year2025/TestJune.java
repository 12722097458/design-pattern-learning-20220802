package com.ityj.algorithm.year2025;

import com.ityj.algorithm.entity.ListNode;
import com.ityj.algorithm.entity.Student;
import com.ityj.algorithm.entity.TreeNode;
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

    // 1 -> 2 -> 3 -> 4
    public ListNode reverseList33(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = null;
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = curr;
            curr = tmp;
        }
        return curr;
    }

    // 169. 多数元素
    // hash
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (k, v) -> (v == null) ? 1 : map.get(num) + 1);
            if (map.get(num) * 2 > nums.length) {
                return num;
            }
        }
        return -1;
    }

    // 1, 2, 2, 2
    // 1, 2, 3, 3, 3
    // 存在这个数， 那么index = length / 2 一定是
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 94. 二叉树的中序遍历
    // 左 根 右
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        middle(result, root);
        return result;
    }

    private void middle(List<Integer> result, TreeNode curr) {
        if (curr == null) {
            return;
        }
        middle(result, curr.left);
        result.add(curr.val);
        middle(result, curr.right);
    }

    // 104. 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 226. 翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    // 101. 对称二叉树
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }

    // 543. 二叉树的直径 todo
    public int diameterOfBinaryTree(TreeNode root) {
        int result = 0;


        return result;
    }

    public int firstMissingPositive2(int[] nums) {
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

        int maxValue = nums.length;
        // set <=0 and > n to 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > maxValue) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int index = Math.abs(value) - 1;
            nums[index] = -Math.abs(nums[index]);  // -1 refer to exist
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return maxValue + 1;
    }

    // 1 -> 2 -> 2 -> 1
    private ListNode palindrome22LeftNode = new ListNode(-1);
    public boolean isPalindrome22(ListNode head) {
        if (head == null) {
            return false;
        }
        palindrome22LeftNode = head;
        return checkIsPalindrome22(head);
    }

    private boolean checkIsPalindrome22(ListNode curr) {
        if (curr != null) {
            if (!checkIsPalindrome22(curr.next)) {
                return false;
            }
            if (palindrome22LeftNode.next.val != curr.val) {
                return false;
            }
            palindrome22LeftNode = palindrome22LeftNode.next;
        }
        return true;
    }

    public ListNode mergeTwoLists22(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        while (true) {
            if (list1.val <= list2.val) {
                ListNode tmp = list1;
                list1 = list1.next;
                curr.next = tmp;
                curr = curr.next;
            } else {
                ListNode tmp = list2;
                list2 = list2.next;
                curr.next = tmp;
                curr = curr.next;
            }
            if (list1 == null) {
                curr.next = list2;
                break;
            }
            if (list2 == null) {
                curr.next = list1;
                break;
            }

        }
        return dummyHead.next;
    }

    // 删除倒数第n个节点
    // 双指针
    public ListNode removeNthFromEnd222(ListNode head, int n) {
        if (head == null || n < 0) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode left = dummyHead;
        ListNode right = head;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        while (true) {
            if (right == null) {
                break;
            }
            left = left.next;
            right = right.next;
        }
        if (left.next != null) {
            left.next = left.next.next;
        }
        return dummyHead;
    }

    // 560. 和为 K 的子数组
    public int subarraySum(int[] nums, int k) {
        int result = 0;

        



        return result;
    }

    // 73. 矩阵置零
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows[i] || columns[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    // 239. 滑动窗口最大值  todo
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return null;
        }
        int[] resultArr = new int[nums.length - k + 1];
        int index = 1;
        List<Integer> subList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                subList.add(nums[i]);
            } else if (i == k - 1) {
                subList.add(nums[i]);
                Integer max = subList.stream().max(Comparator.comparingInt(o -> o)).get();
                resultArr[0] = max;
            } else if (i > k - 1) {
                subList.remove(0);
                subList.add(nums[i]);
                Integer max = subList.stream().max(Comparator.comparingInt(o -> o)).get();
                resultArr[index++] = max;
            }
        }
        return resultArr;
    }

    public static List<Long> getPerfectNumber(Long start, Long end) {
        List<Long> result = new ArrayList<>();
        assert start > 0;
        assert end > start;
        while (start <= end) {
            long sum = 0L;
            for (int i = 1; i < start; i++) {
                if (start % i == 0) {
                    sum += i;
                }
                if (sum > start) {
                    break;
                }
            }
            if (sum == start) {
                result.add(start);
            }

            start++;
        }

        return result;
    }


    // 一个数的因子就是所有可以整除这个数的数，不包括这个数自身。比如，6的因子是1，2，3
    //一个数如果恰好等于它的因子之和，这个数就称为“完数“。 例如6=1＋2＋3
    //请编写一个函数，入参是一个正整数n，返回值是0到n之间（闭区间）的完数的个数

    public static List<Integer> getPerfectNumber2(int n) {
        List<Integer> result = new ArrayList<>();
        if (n <= 1) {
            return result;
        }
        // 筛选法计算真因子
        int[] factorSum = new int[n + 1]; // 0 - n  索引0到n
        // 找到i是谁的因子
        for (int i = 1; i <= n / 2; i++) {
            // 2i 3i 4i 5i
            for (int j = 2 * i; j <= n; j = j + i) {
                factorSum[j] = factorSum[j] + i;  // 计算因子之和
            }
        }

        for (int i = 2; i < factorSum.length; i++) {
            if (factorSum[i] == i) {
                result.add(factorSum[i]);
            }
        }
        System.out.println("factorSum = " + Arrays.toString(factorSum));
        return result;
    }

    // 75. 颜色分类
    // [2,0,2,1,1,0]
    public void sortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }

    }

    // [2,0,2,1,1,0]
    // 单指针
    public void sortColors2(int[] nums) {
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = tmp;
                ptr++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int tmp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = tmp;
                ptr++;
            }
        }
    }

    // 35. 搜索插入位置
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            } else {
                if (nums[i] > target) {
                    return i;
                }
            }
        }
        return nums.length;
    }

    // 二分查找
    // [1,3,5,6]   2
    //  0,1,2,3
    public int searchInsert2(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (true) {
            if (leftIndex > rightIndex) {
                break;
            }
            int middleIndex = (leftIndex + rightIndex) / 2;
            int middleValue = nums[middleIndex];
            if (middleValue < target) {
                leftIndex = middleIndex + 1;
            } else if (middleValue == target) {
                return middleIndex;
            } else {
                rightIndex = middleIndex - 1;
            }
        }
        return leftIndex;
    }

    // 74. 搜索二维矩阵
    public boolean searchMatrix(int[][] matrix, int target) {
        int columnIndex = findTargetColumnIndex(matrix, target);
        System.out.println("columnIndex = " + columnIndex);
        return findTargetRow(matrix[columnIndex], target);
    }

    private boolean findTargetRow(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;
        while (left > right) {
            int middleIndex = (left + right) / 2;
            int value = row[middleIndex];
            if (value == target) {
                return true;
            }
            if (value < target) {
                left = middleIndex + 1;
            } else {
                right = middleIndex - 1;
            }
        }
        return false;
    }

    private int findTargetColumnIndex(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (true) {
            if (left > right) {
                break;
            }
            int middleIndex = (left + right) / 2;
            int value = matrix[middleIndex][0];
            if (target < value) {
                left = middleIndex + 1;
            } else if (target == value) {
                return middleIndex;
            } else {
                right = middleIndex - 1;
            }
        }
        return left;
    }

    // 20. 有效的括号
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                // 左括号
                stack.push(ch);
            } else {
                // 右括号
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop != map.get(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // 394. 字符串解码  todo
    // 输入：s = "2[abc]3[cd]ef"
    //输出："abcabccdcdcdef"
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            stack.push(ch);
        }

        StringBuilder reversedStr = new StringBuilder();
        StringBuilder reversedTmpStr = new StringBuilder();
        boolean strFlag = false;
        while (true) {
            if (stack.isEmpty()) {
                break;
            }
            Character pop = stack.pop();
            if (pop == ']') {
                strFlag = true;
                continue;
            } else if (pop == '[') {
                strFlag = false;
                continue;
            } else if (Character.isDigit(pop)) {
                for (int i = 0; i < pop - '0'; i++) {
                    reversedStr.append(reversedTmpStr);
                }
                reversedTmpStr = new StringBuilder();
                continue;
            }
            if (strFlag) {
                reversedTmpStr.append(pop);
            } else {
                reversedStr.append(pop);
            }
        }
        return reversedStr.reverse().toString();
    }

    public ListNode mergeTwoLists2222(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        while (true) {
            if (list1 == null || list2 == null) {
                break;
            }
            if (list1.val < list2.val) {
                ListNode tmp = list1;
                list1 = list1.next;
                curr.next = tmp;
                curr = curr.next;
            } else {
                ListNode tmp = list2;
                list2 = list2.next;
                curr.next = tmp;
                curr = curr.next;
            }
        }
        if (list1 == null) {
            curr.next = list2;
        } else {
            curr.next = list1;
        }
        return dummyHead.next;
    }

    // [100,4,200,1,3,2]
    public int longestConsecutive_test(int[] nums) {
        int max = 0;
        if (nums == null || nums.length == 0) {
            return max;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (Integer num : set) {
            // num -1 如果存在，说明不是最合适的
            if (set.contains(num - 1)) {
                continue;
            }
            int count = 1;
            while (true) {
                if (!set.contains(++num)) {
                    max = Math.max(max, count);
                    break;
                } else{
                    // ++num存在 继续判断
                    count++;
                }
            }
        }
        return max;
    }

    public TreeNode invertTree_test(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree_test(root.left);
        TreeNode right = invertTree_test(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // 15. 三数之和
    // -1,0,1,2,-1,-4
    // -4,-1,-1,0,1,2
    public List<List<Integer>> threeSum222(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int num = nums[i];
            while (true) {
                if (left >= right) {
                    break;
                }
                int twoSum = nums[left] + nums[right];
                if (num + twoSum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(num);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;
                    right--;
                    // 删除重复元素
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (num + twoSum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    // 121. 买卖股票的最佳时机
    public int maxProfit(int[] prices) {
        int[] rightMaxArr = new int[prices.length];
        int index = prices.length - 1;
        int max = prices[index];
        while (index >= 0) {
            int curr = prices[index];
            max = Math.max(max, curr);
            rightMaxArr[index] = max;
            index--;
        }

        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            result = Math.max(result, rightMaxArr[i] - prices[i]);
        }
        return result;
    }

    // 一次遍历
    public int maxProfit22(int[] prices) {
        int result = 0;
        int minPrice = prices[0];
        for (int curr : prices) {
            if (curr < minPrice) {
                minPrice = curr;
            } else if (curr - minPrice > result) {
                result = curr - minPrice;
            }
        }
        return result;
    }

    // 70. 爬楼梯
    // f(n) = f(n - 1) + f(n - 2)
    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        return climb(n, arr);
    }

    private int climb(int n, int[] arr) {
        if (arr[n] > 0) {
            return arr[n];
        }
        if (n == 1) {
            arr[n] = 1;
        } else if (n == 2) {
            arr[n] = 2;
        } else {
            arr[n] = climb(n - 1, arr) + climb(n - 2, arr);
        }
        return arr[n];
    }

    // head = [1,2,3,4]
    public ListNode swapPairs_test(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        while (dummyHead.next != null && dummyHead.next.next != null) {
            ListNode temp = curr.next;
            ListNode temp2 = curr.next.next.next;

            curr.next = curr.next.next;
            head.next.next = temp;
            temp.next = temp2;
            curr = curr.next.next;
        }
        return dummyHead.next;
    }

    public ListNode getIntersectionNode_test(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        // A长
        if (lengthA > lengthB) {
            int diff = lengthA - lengthB;
            for (int i = 0; i < diff; i++) {
                headA = headA.next;
            }
        } else {
            int diff = lengthB - lengthA;
            for (int i = 0; i < diff; i++) {
                headB = headB.next;
            }
        }
        while (true) {
            // 任何一个指向null， 就是没有相交
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

    // 1-> 2 -> 3 -> 4 -> null
    public ListNode reverseList_test(ListNode head) {
        ListNode curr = null;
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = curr;
            curr = tmp;
        }
        return curr;
     }

    // 1,2,2,1
    private ListNode front = null;
    public boolean isPalindrome_test(ListNode head) {
        if (head == null) {
            return false;
        }
        front = head;
        return checkPalindrome(head);
    }

    private boolean checkPalindrome(ListNode curr) {
        if (curr != null) {
            if (!checkPalindrome(curr.next)) {
                return false;
            }
            if (curr.val != front.val) {
                return false;
            }
            front = front.next;
        }
        return true;
    }

    public boolean hasCycle_test(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (true) {
            // 如果没有环，fast一定会先结束
            if (fast == null || fast.next == null) {
                return false;
            }
            // 快慢相遇
            if (slow.equals(fast)) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
    }

    public ListNode detectCycle_test(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (true) {
            // 如果没有环，fast一定会先结束
            if (fast == null || fast.next == null) {
                return null;
            }
            // 快慢相遇
            if (slow.equals(fast)) {
                ListNode tmp = head;
                while (true) {
                    if (tmp.equals(slow)) {
                        return tmp;
                    }
                    tmp = tmp.next;
                    slow = slow.next;
                }
            }
            slow = slow.next;
            fast = fast.next.next;
        }
    }

    public ListNode mergeTwoLists_test(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;

        while (true) {
            if (list1 == null || list2 == null) {
                break;
            }
            if (list1.val < list2.val) {
                ListNode tmp = list1;
                list1 = list1.next;
                curr.next = tmp;
                curr = curr.next;
            } else {
                ListNode tmp = list2;
                list2 = list2.next;
                curr.next = tmp;
                curr = curr.next;
            }
        }
        if (list1 == null) {
            curr.next = list2;
        } else {
            curr.next = list1;
        }
        return dummyHead.next;
    }

    public ListNode addTwoNumbers_test(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        int tmp = 0;
        while (true) {
            if (l1 == null && l2 == null) {
                break;
            }
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            curr.next = new ListNode((l1Val + l2Val + tmp) % 10);
            tmp = (l1Val + l2Val + tmp) / 10;
            curr = curr.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (tmp != 0) {
            curr.next = new ListNode(tmp);
        }
        return dummyHead.next;
    }

    public ListNode removeNthFromEnd_test(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }

        if (head == null) {
            // skip first
            curr.next = curr.next.next;
            return dummyHead.next;
        }
        while (true) {
            if (head.next == null) {
                // 切断下一个node
                curr.next.next = curr.next.next.next;
                break;
            }
            curr = curr.next;
            head = head.next;
        }
        return dummyHead.next;
    }

    public ListNode swapPairs_test2(ListNode head) {
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
            pre = pre.next.next;
        }
        return dummyHead.next;
    }

    public ListNode reverseList_test2(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = pre;
            pre = tmp;
        }
        return pre;
    }

    public int firstMissingPositive_test(int[] nums) {
        int result = -1;
        // 看1是否存在'
        boolean oneExist = false;
        for (int num : nums) {
            if (num == 1) {
                oneExist = true;
            }
        }
        if (!oneExist) {
            return 1;
        }
        int n = nums.length;
        // set to 1 if  <=0 and >nums.length
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            nums[index - 1] = -Math.abs(nums[index - 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result = i + 1;
                break;
            }
        }
        return result == -1 ? n + 1 : result;
    }



        @Test
    public void testMethod() throws Throwable {
    int[] arr = {-1,0,1,2,-1,-4};
    List<List<Integer>> lists = threeSum222(arr);
    System.out.println("lists = " + lists);
        String s = try_catch_finally();
        System.out.println("final 实参 s = " + s);
        Student student = try_catch_finally222();
        System.out.println("final student = " + student);

        String s1 = try_catch_finally2223();
        System.out.println("s1 = " + s1);

    }

    // 返回值为 return_value_1
    public static String try_catch_finally() {
        String string = "return_value_1";
        try {
            System.out.println(111);
            return string;
        } finally {
            string = "return_value_2";
            System.out.println("string = " + string);
        }
    }

    public static Student try_catch_finally222() {
        Student s = new Student();
        s.setName("AAA");
        try {
            System.out.println(s);
            return s;
        } finally {
            s.setName("Updated");
            System.out.println("s = " + s);
        }
    }

    public static String try_catch_finally2223() {
        Student s = new Student();
        s.setName("AAA");
        try {
            System.out.println(s);
            return s.getName();
        } finally {
            s.setName("Updated");
            System.out.println("s = " + s);
        }
    }
}
