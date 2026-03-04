package com.ityj.algorithm.bck.year2025;

import com.ityj.algorithm.entity.ListNode;
import com.ityj.algorithm.entity.TreeNode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.RootUriRequestExpectationManager;

import java.util.*;
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

    // 输入：nums = [100,4,200,1,3,2]
    //输出：4
    //解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
    public int longestConsecutive(int[] nums) {
        int max = 0;
        if (nums == null || nums.length == 0) {
            return max;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
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

    //输入: nums = [0,1,0,3,12]
    //输出: [1,3,12,0,0]
    public void moveZeroes_1020(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int left = 0;
        int right = 0;
        while (true) {
            if (left > right || right >= nums.length) {
                break;
            }
            if (nums[right] != 0) {
                // 交换
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                right++;
                left++;
            } else {
                right++;
            }
        }
    }

    // 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
    //输出：[3,3,5,5,6,7]
    // 1
    // 3
    // 3 -1
    // 3 -1 -3   to remove the first (i - k)
    // 5
    // 5 3
    // 6
    // 7
    public int[] maxSlidingWindow_1020(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];


        LinkedList<Integer> queue = new LinkedList<>();
        // 前k个
        int index = 0;
        for (int i = 0; i < k; i++) {
                        while (true) {
                if (!queue.isEmpty() && queue.getLast() < nums[i]) {
                    queue.removeLast();
                } else {
                    queue.offer(nums[i]);
                    break;
                }
            }
        }
        result[index++] = queue.getFirst();

        // 后面的
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


    //输入：nums = [1,2,0]
    //输出：3
    //解释：范围 [1,2] 中的数字都在数组中。

    // 1 2 3
    // 1 1
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
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
            if (nums[i] > nums.length || nums[i] <= 0) {
                nums[i] = 1;
            }
        }
        for (int num : nums) {
            nums[Math.abs(num) - 1] = -Math.abs(nums[Math.abs(num) - 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }


    // 输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
    //输出：Intersected at '2'
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                headA = headA.next;
            }
        } else if (lengthB > lengthA) {
            for (int i = 0; i < lengthB - lengthA; i++) {
                headB = headB.next;
            }
        }

        while (true) {
            if (headA == null || headB == null) {
                return null;
            }
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
    }

    private int getLength(ListNode headA) {
        int result = 0;
        while (headA.next != null) {
            result++;
            headA = headA.next;
        }
        return result;
    }

    // 输入：head = [1,2,3,4,5]
    //输出：[5,4,3,2,1]
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
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

    // 输入：head = [1,2,2,1]
    //输出：true
    private ListNode firstNode;
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        firstNode = head;
        return check(head);
    }

    private boolean check(ListNode head) {
        if (head.next != null) {
            if (!check(head.next)) {
                return false;
            }
            firstNode = firstNode.next;
            return firstNode.val == head.val;
        } else {
            return true;
        }
    }

    // 输入：head = [3,2,0,-4], pos = 1
    //输出：true
    //解释：链表中有一个环，其尾部连接到第二个节点。
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        // 快慢指针， 若能相遇就是成环
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (true) {
            if (fast == null) {
                return false;
            }
            if (fast == slow) {
                return true;
            }
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
    }

    // 输入：head = [1,2,3,4]
    //输出：[2,1,4,3]
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (true) {
            if (pre.next != null && pre.next.next != null) {
                ListNode tmp = pre.next;
                ListNode tmp2 = pre.next.next.next;
                pre.next = pre.next.next;
                pre.next.next = tmp;
                tmp.next = tmp2;
                pre = tmp;
            } else {
                break;
            }
        }
        return dummyHead.next;
    }

    // 输入：root = [1,null,2,3]
    //输出：[1,3,2]
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        populate(result, root);
        return result;
    }

    private void populate(List<Integer> result, TreeNode root) {
        if (root != null) {
            populate(result, root.left);
            result.add(root.val);
            populate(result, root.right);
        }
    }


    public int maxDepth(TreeNode root) {
        int max = 0;
        if (root == null) {
            return max;
        }
        return getMaxDepth(root);
    }

    private int getMaxDepth(TreeNode root) {
        if (root != null) {
            int leftDepth = getMaxDepth(root.left);
            int rightDepth = getMaxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
        return 0;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode rightTree = invertTree(root.right);
        TreeNode leftTree = invertTree(root.left);
        root.left = rightTree;
        root.right = leftTree;
        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        return checkSymmetric(root.left, root.right);


    }

    private boolean checkSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }


        return checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();

        backtracing(candidates, target, result, tmpList, 0, 0);

        return result;
    }

    private void backtracing(int[] candidates, int target, List<List<Integer>> result, List<Integer> tmpList, int fromIndex, int sum) {
        if (sum >= target) {
            if (sum == target) {
                result.add(new ArrayList<>(tmpList));
            }
            return;
        }
        for (int i = fromIndex; i < candidates.length; i++) {
            tmpList.add(candidates[i]);
            backtracing(candidates, target, result, tmpList, i, sum + candidates[i]);
            tmpList.remove(tmpList.size() - 1);
        }
    }


    // 输入: nums = [1,3,5,6], target = 5 / 7 / 0
    // 1 3 5 6        0
    //
    //输出: 2
    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            if (left > right) {
                break;
            }
            int middleIndex = (left + right) / 2;
            if (nums[middleIndex] < target) {
                left = middleIndex + 1;
            } else if (nums[middleIndex] > target) {
                right = middleIndex - 1;
            } else {
                return middleIndex;
            }
        }
        return left + 1;
    }




    @Test
    public void test1() {
        int[] nums = {1};
            int ints = firstMissingPositive(nums);
            System.out.println("lists = " + ints);
        }
}
