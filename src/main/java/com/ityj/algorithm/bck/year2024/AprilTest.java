package com.ityj.algorithm.bck.year2024;

import com.ityj.algorithm.entity.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class AprilTest {

    // 1592. 重新排列单词间的空格
    public String reorderSpaces(String text) {
        int spaceCount = 0;
        String tmpStr = "";
        List<String> strList = new ArrayList<>();
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                spaceCount++;
                if (tmpStr.length() != 0) {
                    strList.add(tmpStr);
                    tmpStr = "";
                }
            } else {
                tmpStr += c;
            }
        }
        if (tmpStr.length() != 0) {
            strList.add(tmpStr);
        }
        if (strList.size() == 1) {
            return strList.get(0) + convertSpaceStr(spaceCount);
        }
        int averageSpaceCount = spaceCount / (strList.size() - 1);
        int lastSpaceCount = spaceCount % (strList.size() - 1);

        String result = "";
        String spaces = convertSpaceStr(averageSpaceCount);
        for (String str : strList) {
            result = result + str + spaces;
        }
        return result.trim() + convertSpaceStr(lastSpaceCount);
    }

    private String convertSpaceStr(int count) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < count; i++) {
            str.append(" ");
        }
        return str.toString();
    }

    // 1652. 拆炸弹
    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        if (k == 0) {
            return result;
        }

        if (k > 0) {
            for (int i = 0; i < code.length; i++) {
                // 接下来k个值之和
                int resNum = 0;
                for (int j = 1; j <= k; j++) {
                    resNum += code[(i + j) % code.length];
                }
                result[i] = resNum;
            }
            return result;
        }

        /*int[] codeReversed = new int[code.length];
        for (int i = 0; i < code.length; i++) {
            codeReversed[i] = code[code.length -1 - i];
        }

        for (int i = 0; i < codeReversed.length; i++) {
            // 接下来k个值之和
            int resNum = 0;
            for (int j = 1; j <= -k; j++) {
                resNum += codeReversed[((codeReversed.length - i - 1) + j) % codeReversed.length];
            }
            result[i] = resNum;
        }
        return result;*/

        for (int i = 0; i < code.length; i++) {
            // 前面k个值之和
            int resNum = 0;
            int n = Math.abs(k);
            for (int j = 1; j <= -k; j++) {
                if (i - j >= 0) {
                    resNum += code[(i - j) % code.length];
                } else {
                    resNum += code[(i + code.length - j) % code.length];
                }
            }
            result[i] = resNum;
        }
        return result;
    }

    // 404. 左叶子之和
    public int sumOfLeftLeaves(TreeNode root) {
        return calculateLeftLeaves(root, 0);
    }

    public int calculateLeftLeaves(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null) {
            return calculateLeftLeaves(right, sum);
        } else if (left.left == null && left.right == null) {
            sum += left.val;
        }
        int leftRes = calculateLeftLeaves(left, sum);
        return calculateLeftLeaves(right, leftRes);
    }

    // 110. 平衡二叉树   平衡二叉树 是指该树所有节点的左右子树的深度相差不超过 1。
    // todo
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    // 2913. 子数组不同元素数目的平方和 I
    public int sumCounts(List<Integer> nums) {
        List<Set<Integer>> allSubList = new ArrayList<>();
        for (int i = 1; i <= nums.size(); i++) {
            allSubList.addAll(getSubSet(i, nums));
        }
        double sum = 0;
        for (Set<Integer> set : allSubList) {
            sum += set.size() * set.size();
        }
        return (int) (sum % (Math.pow(10, 9) + 7));
    }

    private List<Set<Integer>> getSubSet(int size, List<Integer> nums) {
        List<Set<Integer>> result = new ArrayList<>();
        int index = 0;
        while (true) {
            if (index + size > nums.size()) {
                break;
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < size; i++) {
                set.add(nums.get(index + i));
                if ((index + i) == (nums.size() - 1)) {
                    break;
                }
            }
            result.add(set);
            index++;
        }
        System.out.println("result = " + result);
        return result;
    }

    // 993. 二叉树的堂兄弟节点
    public boolean isCousins(TreeNode root, int x, int y) {



        return false;
    }


    @Test
    public void testCase2() {
        List<Integer> integers = List.of(1, 2, 1);
        int i = sumCounts(integers);
        System.out.println("i = " + i);
    }

    @Test
    public void testCase() {
        TreeNode fourLeft = new TreeNode(4, null, new TreeNode(8, null, null));
        TreeNode left = new TreeNode(2, fourLeft, new TreeNode(5, null, null));
        TreeNode right = new TreeNode(3, new TreeNode(6, null, null), null);
        TreeNode root = new TreeNode(1, left, right);
        boolean balanced = isBalanced(root);
        System.out.println("balanced = " + balanced);
    }

}
