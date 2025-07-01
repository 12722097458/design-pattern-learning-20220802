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

    @Test
    public void testMethod() throws Throwable {
        int[] arr = {-1,0,1,2,-1,-4};
    }

}
