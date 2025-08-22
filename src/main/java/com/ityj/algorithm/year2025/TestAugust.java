package com.ityj.algorithm.year2025;

import com.ityj.algorithm.entity.ListNode;
import org.junit.jupiter.api.Test;

import java.util.*;

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

    // 78. 子集
    //
    //输入：nums = [1,2,3]
    //输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        sub(nums, list, tmpList, 0);
        return list;
    }

    private void sub(int[] nums, List<List<Integer>> result, List<Integer> tmpList, int fromIndex) {
        result.add(new ArrayList<>(tmpList));
        for (int i = fromIndex; i < nums.length; i++) {
            tmpList.add(nums[i]);
            sub(nums, result, tmpList, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    // 17. 电话号码的字母组合   todo
    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));
        char[] charArray = digits.toCharArray();
        List<List<Character>> dataList = new ArrayList<>();
        for (char ch : charArray) {
            dataList.add(map.get(ch));
        }
        System.out.println("dataList = " + dataList);
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        letterCombin(dataList, result, sb, 0);
        return result;
    }

    private void letterCombin(List<List<Character>> dataList, List<String> result, StringBuilder sb, int fromIndex) {
        // 如果输入三个数字，那么每个数字都需要有一个字母
        if (dataList.size() == fromIndex) {
            result.add(new String(sb));
        } else {
            List<Character> letters = dataList.get(fromIndex);

            for (int i = fromIndex; i < letters.size(); i++) {
                sb.append(letters.get(i));
                letterCombin(dataList, result, sb, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    // 239. 滑动窗口最大值
    //  队首 1,2,3  队尾
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return null;
        }
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        // 维护一个 递减链表
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
                queue.removeLast();
            }
            queue.offerLast(nums[i]);  //放队尾
        }
        result[index++] = queue.peekFirst();

        for (int i = k; i < nums.length; i++) {
//            System.out.println("nums[i - k] = " + nums[i - k]);
            // nums[i - k] 就是当前循环要删除的元素（最老的元素）
            if (!queue.isEmpty() && queue.peekFirst() == nums[i - k]) {
                queue.removeFirst();
            }

            // 删除所有比自己小的元素
            while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
                queue.removeLast();
            }
            queue.offerLast(nums[i]);  //放队尾
            result[index++] = queue.peekFirst();
        }
        return result;
    }


    // 76. 最小覆盖子串
    // 输入：s = "ADOBECODEBANC", t = "ABC"
    //输出："BANC"
    //265 / 268 超时
    public String minWindow_todo(String s, String t) {
        String result = "";
        char[] charArray = s.toCharArray();

        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (left > right) {
                if (containsAllTarget(sb, t)) {
                    if (result.isEmpty()) {
                        result = sb.toString();
                    } else {
                        result = result.length() > sb.length() ? sb.toString() : result;
                    }
                }
                break;
            }
            if (containsAllTarget(sb, t)) {
                System.out.println(sb);
                if (result.isEmpty()) {
                    result = sb.toString();
                } else {
                    result = result.length() > sb.length() ? sb.toString() : result;
                }
                left++;
                sb.deleteCharAt(0);
            } else if (right < s.length()) {
                sb.append(charArray[right]);
                right++;
            } else {
                break;
            }
        }
        return result;
    }

    private boolean containsAllTarget(StringBuilder sb, String t) {
        char[] sourceArr = sb.toString().toCharArray();
        char[] targetArr = t.toCharArray();
        boolean[] targetRes = new boolean[targetArr.length];

        for (int i = 0; i < targetArr.length; i++) {
            for (int j = 0; j < sourceArr.length; j++) {
                if (sourceArr[j] == targetArr[i]) {
                    targetRes[i] = true;
                    sourceArr[j] = '0';
                    break;
                }
            }
        }
        for (boolean boo : targetRes) {
            if (!boo) {
                return false;
            }
        }
        return true;
    }


        @Test
    public void test1() {
        int[] nums = {-7,-8,7,5,7,1,6,0};

            int[] ints = maxSlidingWindow(nums, 4);
            System.out.println(Arrays.toString(ints));

            String string = "aavb";
            String string1 = string.replaceFirst("a", "");
            System.out.println("string1 = " + string1);


        }
}
