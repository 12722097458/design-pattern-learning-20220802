package com.ityj.algorithm.bck.dir2022.year2023;

import com.ityj.algorithm.entity.ListNode;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TestJune {


    // 1897. 重新分配字符使所有字符串都相等
    public boolean makeEqual(String[] words) {
        // 思路：统计所有字符出现的个数，看是否为数组长度的倍数
        Map<Character, Integer> map = new HashMap<>();
        Arrays.stream(words).forEach(word -> {
            for (char c : word.toCharArray()) {
                map.merge(c, 1, (oldValue, newValue) -> oldValue + 1);
            }
        });

        for (Integer count : map.values()) {
            if (count % words.length != 0) {
                return false;
            }
        }
        return true;
    }

    //1925. 统计平方和三元组的数目
    public int countTriples(int n) {
        // 1 <= a, b, c <= n
        // 没有说 i 和 j 的大小关系， 所以假设 i < j ，将最终结果 X 2
        int result = 0;
        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (i * i + j * j == k * k) {
                        result++;
                    }
                }
            }
        }
        return result * 2;
    }

    // 剑指 Offer II 024. 反转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (true) {
            if (cur == null) {
                return pre;
            }
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }


    // 69. x 的平方根
    // 注意越界异常, a*a = b 会越界 ，那就用 b/a 和 a作比较。。。。
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int result = x / 2;

        while (true) {
            if (result == 0) {
                return 0;
            }
            if (x / result < result) {
                if (x / (result - 1) >= (result - 1)) {    // x / (result - 1)  向下取整，x-1都比你大， 所以结果还比你大
                    return result - 1;
                } else {
                    result = result / 2;
                }
            } else {
                if (x / (result + 1)  < (result + 1)) {
                    return result;
                } else {
                    result = (x + result) / 2;
                }
            }
        }
    }

    // 1021. 删除最外层的括号
    // "(()())(())(()(()))"
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                sb.append(s.charAt(i));
            }
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
        }
        return sb.toString();
    }

    // 2485. 找出中枢整数
    public int pivotInteger(int n) {
        int sum = n * (1 + n) / 2;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 1; i <= n; i++) {
            rightSum = sum - leftSum - i;
            if (leftSum == rightSum) {
                return i;
            }
            // leftSum 不计算当前的num[i]
            leftSum += i;
        }
        return -1;
    }

    // 剑指 Offer II 012. 左右两边子数组的和相等
    public int pivotIndex(int[] nums) {
        int numSum = Arrays.stream(nums).sum();
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum = numSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            // leftSum 不计算当前的num[i]
            leftSum += nums[i];
        }
        return -1;
    }

    @Test
    public void testDemo() throws IOException, URISyntaxException, NoSuchAlgorithmException {
        String s = "(()())(())(()(()))";
        String[] arr = {"hit"};


        File file1 = new File("C:\\Users\\ayinj\\Desktop\\test\\a.txt");
        File file2 = new File("C:\\Users\\ayinj\\Desktop\\test\\a.txtbck");
        int copy = FileCopyUtils.copy(file1, file2);
        System.out.println("copy = " + copy);

        boolean sameFile = Files.isSameFile(Paths.get(file1.toURI()), Paths.get(file2.toURI()));
        System.out.println("sameFile = " + sameFile);

        String hash1 = getFileHash(file1.getPath(), "MD5");
        String hash2 = getFileHash(file2.getPath(), "MD5");

        if (hash1.equals(hash2)) {
            System.out.println("The files have the same content.");
        } else {
            System.out.println("The files have different content.");
        }

        System.out.println("=================");
        boolean b = FileUtils.contentEquals(file1, file2);
        System.out.println("b = " + b);

    }

    private static String getFileHash(String filePath, String algorithm) throws IOException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        try (FileInputStream fis = new FileInputStream(filePath);
             DigestInputStream dis = new DigestInputStream(fis, digest)) {
            while (dis.read() != -1) {
                // Read the file to update the digest
            }
            byte[] hash = digest.digest();
            return bytesToHex(hash);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}


