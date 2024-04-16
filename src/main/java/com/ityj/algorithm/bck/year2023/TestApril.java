package com.ityj.algorithm.bck.dir2022.year2023;

import com.ityj.algorithm.entity.ListNode;
import com.ityj.algorithm.entity.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TestApril {

    // 剑指 Offer II 019. 最多删除一个字符得到回文
    // StringBuilder 暴力解法会超时
    public boolean validPalindrome(String s) {
        int begin = 0;
        int end = s.length() - 1;
        while (true) {
            if (begin >= end) {
                return true;
            }
            if (s.charAt(begin) == s.charAt(end)) {
                begin++;
                end--;
            } else {
                // 分别删除left 和 right进行校验;  不能用++begin， 这样在计算第二个条件时，会直接改变begin的值
                return isValidate(s, begin + 1, end) || isValidate(s, begin, end - 1);
            }
        }
    }

    private boolean isValidate(String s, int begin, int end) {
        while (true) {
            if (begin >= end) {
                return true;
            }
            // 出现前后两个值不相等，说明删除这个字符后，还不是回文
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
    }

    // 500. 键盘行
    public String[] findWords(String[] words) {
        Map<Character, Integer> dictionary = new HashMap<>();
        for (char c : "qwertyuiop".toCharArray()) {
            dictionary.put(c, 1);
        }
        for (char c : "asdfghjkl".toCharArray()) {
            dictionary.put(c, 2);
        }
        for (char c : "zxcvbnm".toCharArray()) {
            dictionary.put(c, 3);
        }

        List<String> result = new ArrayList<>();
        Arrays.stream(words).forEach(word -> {
            int tmp = 0;
            for (char c : word.toLowerCase(Locale.ROOT).toCharArray()) {
                if (tmp == 0) {
                    tmp = dictionary.get(c);
                }
                if (tmp != dictionary.get(c)) {
                    return;
                }
            }
            result.add(word);
        });
        return result.toArray(new String[0]);
    }


    // 350. 两个数组的交集 II
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n2Index = 0;
        for (int i = 0; i < nums1.length; i++) {
            int n1 = nums1[i];
            while (true) {
                // n2 遍历完成
                if (n2Index == nums2.length) {
                    break;
                }
                int n2 = nums2[n2Index];
                // nums1[i] 小了， 说明没有匹配的。进行下一个n1
                if (n1 < n2) {
                    break;
                }
                if (n1 == n2) {
                    result.add(n1);
                    n2Index++;
                    break;
                }
                n2Index++;
            }
        }
        return result.stream().mapToInt(x -> x).toArray();
    }


    // 剑指 Offer 24. 反转链表
    // 双指针
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        return reverse(head, null);
    }

    // 递归
    public ListNode reverse(ListNode curr, ListNode pre) {
        if (curr == null) {
            return pre;
        }
        ListNode temp = curr.next;
        curr.next = pre;
        pre = curr;
        curr = temp;
        return reverse(curr, pre);
    }

    //面试题 04.02. 最小高度树
    public TreeNode sortedArrayToBST(int[] nums) {
        // todo


        return null;
    }

    // 821. 字符的最短距离




    @Test
    public void testDemo() {
        String s = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] arr = {"hit"};


        int[] intersect = intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});

    }

}


