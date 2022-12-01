package com.ityj.algorithm.test;

import com.ityj.algorithm.entity.ListNode;
import com.ityj.algorithm.entity.Node;
import com.ityj.algorithm.entity.TreeNode;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public class TestNovember {
    public int largestInteger(int num) {
        List<Integer> dataList = new ArrayList<>();
        while (true) {
            int last = num % 10;
            num = num / 10;
            dataList.add(last);
            if (num == 0) {
                break;
            }
        }
        Collections.reverse(dataList);
        for (int i = 0; i < dataList.size(); i++) {
            for (int j = i + 1; j < dataList.size(); j++) {
                Integer first = dataList.get(i);
                Integer second = dataList.get(j);
                if (second % 2 != first % 2) {
                    continue;
                }
                if (second <= first) {
                    continue;
                }
                dataList.set(i, second);
                dataList.set(j, first);
            }
        }
        int result = 0;
        for (Integer data : dataList) {
            result = result * 10 + data;
        }
        return result;
    }

    @Test
    public void largestIntegerTest() {
        int i = largestInteger(266);
        System.out.println("i = " + i);
    }

    public int countPairs(int[] nums, int k) {
        int resultCount = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && i * j % k == 0) {
                    resultCount++;
                }
            }
        }
        return resultCount;
    }


    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        listNodes(result, root);
        return result;

    }

    private void listNodes(List<Integer> list, Node root) {

        if (root == null) {
            return;
        }

        list.add(root.val);
        root.children.forEach(x -> {
            listNodes(list, x);
        });

    }

    // 492. 构造矩形
    public int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        int[] result = new int[2];
        for (int i = 1; i <= sqrt + 1; i++) {
            for (int j = i; j <= area; j++) {
                if (i * j == area) {
                    result[1] = i;
                    result[0] = j;
                }
                if (i * j >= area) {
                    break;
                }
            }
        }
        return result;
    }

    public int[] constructRectangle2(int area) {
        int width = (int) Math.sqrt(area);
        while(true) {
            if (area % width == 0) {
                break;
            }
            width--;
        }
        return new int[] {area / width, width};
    }

    // 10- II. 青蛙跳台阶问题
    public int numWays(int n) {
        // 超出时间限制
        if (n == 0 || n == 1) {
            return 1;
        }
        int ways = numWays(n - 1) + numWays(n - 2);
        return ways % 1000000007;
    }

    public int numWays2(int n) {
        // 超出时间限制
        if (n == 0 || n == 1) {
            return 1;
        }

        int n2 = 1;
        int n1 = 1;
        int result = 0;
        for (int i = 2; i < n + 1; i++) {
            result = (n2 + n1) % 1000000007;
            n2 = n1;
            n1 = result;
        }
        return result;
    }

    // 1018. 可被 5 整除的二进制前缀
    // 注意Integer的最大值范围
    public List<Boolean> prefixesDivBy5(int[] nums) {

        List<Boolean> res = new ArrayList<>();
        int sum = 0;

        for (int num : nums) {
            sum = (sum * 2 + num) % 5;
            res.add(sum == 0);
        }
        return res;
    }


    // 2404. 出现最频繁的偶数元素
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> dataMap = new HashMap<>();
        Arrays.stream(nums).filter(x -> x % 2 == 0)
                .forEach(x -> {
                    if (dataMap.containsKey(x)) {
                        dataMap.put(x, dataMap.get(x) + 1);
                    } else {
                        dataMap.put(x, 1);
                    }
                });
        Collection<Integer> values = dataMap.values();
        int max = 0;
        for (Integer value : values) {
            if (value > max) {
                max = value;
            }
        }
        List<Integer> maxFrequentList = new ArrayList<>();
        int finalMax = max;
        dataMap.forEach((k, v) -> {
            if (v == finalMax) {
                maxFrequentList.add(k);
            }
        });
        List<Integer> result = maxFrequentList.stream().sorted().collect(Collectors.toList());
        return result.size() == 0 ? -1 : result.get(0);
    }

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }


    // 2315. 统计星号
    public int countAsterisks(String s) {

        char[] chars = s.toCharArray();
        Map<Integer, Integer> indexMap = new HashMap<>();
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '|') {
                indexMap.put(++index, i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 1;
        while (i < indexMap.size()) {
            sb.append(s.substring(indexMap.get(i), indexMap.get(i + 1)));
            i = i + 2;
        }
        return getCount(s, '*') - getCount(sb.toString(), '*');

    }

    private int getCount(String str, char tag) {
        int result = 0;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c == tag) {
                result++;
            }
        }
        return result;
    }

    public int countAsterisks2(String s) {

        int count = 0;
        boolean flag = true;

        for (char ch : s.toCharArray()) {

            if ('|' == ch) {
                flag = !flag;
            }

            if (flag && ch == '*') {
                count++;
            }
        }
        return count;
    }



    // 面试题 17.12. BiNode
    public TreeNode convertBiNode(TreeNode root) {

        return null;
    }

    // 2032. 至少在两个数组中出现的值
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        addArr(set, nums1);
        addArr(set, nums2);
        addArr(set, nums3);
        for (int data : set) {
            int num = 0;
            for (int i : nums1) {
                if (data == i) {
                    num++;
                    break;
                }
            }
            for (int i : nums2) {
                if (data == i) {
                    num++;
                    if (num == 2) {
                        result.add(i);
                    }
                    break;
                }
            }
            for (int i : nums3) {
                if (data == i) {
                    num++;
                    if (num == 2) {
                        result.add(i);
                    }
                    break;
                }
            }
        }
        return result;
    }

    private void addArr(Set<Integer> set, int[] nums1) {
        for (int i : nums1) {
            set.add(i);
        }
    }

    // 1805. 字符串中不同整数的数目
    public int numDifferentIntegers(String word) {
        String[] dataArr = word.split("[a-zA-Z]+");
        return (int) Arrays.stream(dataArr).filter(x -> !"".equals(x)).map(this::removeZero).distinct().count();
    }

    public String removeZero(String str) {
        String res = str.replaceAll("^[0]+", "");
        return "".equals(res) ? "0" : res;
    }


    @Test
    public void testDemo() {
        String str = "a1b01c001";
        int i = numDifferentIntegers(str);
        System.out.println("i = " + i);
    }


}


