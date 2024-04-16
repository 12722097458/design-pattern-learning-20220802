package com.ityj.algorithm.test;

import com.ityj.algorithm.entity.ListNode;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestJuly {

    // 1122. 数组的相对排序
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> directory = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            directory.put(arr2[i], i);
        }


        Comparator<Integer> comparator = (o1, o2) -> {
            // 返回负数时参数的顺序就是排的顺序即:o1,o2
            // 返回正数时参数的反序就是排的顺序即:o2,o1
            if (directory.containsKey(o1) && directory.containsKey(o2)) {
                // 都在arr2
                // directory 的value越小，优先级越高，放左边。
                return directory.get(o1) - directory.get(o2);
            }
            if (directory.containsKey(o1) && !directory.containsKey(o2)) {
                // 一个在， 一个不在
                return -1;
            }
            if (!directory.containsKey(o1) && directory.containsKey(o2)) {
                // 一个在， 一个不在
                return 1;
            }
            // 都不在arr2
            return o1 - o2;
        };
        List<Integer> list = Arrays.stream(arr1).boxed().sorted(comparator).collect(Collectors.toList());
        return list.stream().mapToInt(x -> x).toArray();
    }

    // 1408. 数组中的字符串匹配
    public List<String> stringMatching(String[] words) {

        List<String> result = new ArrayList<>();

        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        List<String> sortedList = Arrays.stream(words).sorted(comparator).collect(Collectors.toList());

        for (int i = 0; i < sortedList.size() - 1; i++) {
            String first = sortedList.get(i);
            for (int j = i + 1; j < sortedList.size(); j++) {
                String second = sortedList.get(j);
                if (second.contains(first)) {
                    result.add(first);
                    break;
                }
            }
        }
        return result;
    }


    // 575. 分糖果
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = Arrays.stream(candyType).boxed().collect(Collectors.toSet());
        return Math.min(candyType.length / 2, set.size());
    }

    // 2710. 移除字符串中的尾随零
    public String removeTrailingZeros(String num) {
        StringBuilder reverse = new StringBuilder();
        boolean zeroFlag = false;

        for (int i = num.length() - 1; i >= 0; i--) {
            if (zeroFlag || num.charAt(i) != '0') {
                if (!zeroFlag) {
                    zeroFlag = true;
                }
                reverse.append(num.charAt(i));
            }
        }
       return reverse.reverse().toString();
    }

    // 2469. 温度转换
    public double[] convertTemperature(double celsius) {
        double[] result = new double[2];
        result[0] = celsius + 273.15;
        result[1] = celsius * 1.80 + 32.00;
        return result;
    }

    // 2535. 数组元素和与数字和的绝对差
    public int differenceOfSum(int[] nums) {
        int allNumSum = Arrays.stream(nums).sum();
        int charSum = 0;
        StringBuilder sb = new StringBuilder("");
        for (int num : nums) {
            sb.append(num);
        }
        char[] chars = sb.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            charSum +=  Character.getNumericValue(chars[i]);
        }
        return Math.abs(allNumSum - charSum);
    }

    // 1207. 独一无二的出现次数
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            //map.merge(num, 1, (oldValue, newValue) -> oldValue + 1);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.keySet().size() == map.values().stream().collect(Collectors.toSet()).size();
    }

    // 1791. 找出星型图的中心节点
    public int findCenter(int[][] edges) {
        if (edges.length < 2) {
            return 0;
        }

        int[] arr = new int[4];
        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                arr[index++] = edges[i][j];
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("arr[j] = " + arr[j]);
                if (arr[j] == arr[i]) {
                    return arr[j];
                }
            }
        }
        return 0;
    }

    // 21. 合并两个有序链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val > list2.val) {
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        } else {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
    }

    // 2733. 既不是最小值也不是最大值
    public int findNonMinOrMax(int[] nums) {
        /*int[] sortedArr = Arrays.stream(nums).distinct().sorted().toArray();
        if (sortedArr.length <= 2) {
            return -1;
        }
        return sortedArr[1];*/

        if (nums.length <= 2) {
            return -1;
        }
        Arrays.sort(nums, 0, 3);
        return nums[1];
    }

    // 521. 最长特殊序列 Ⅰ
    public int findLUSlength(String a, String b) {
        if ("".equals(a) && "".equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }

    // 1544. 整理字符串
    public String makeGood(String s) {
        boolean flag = true;
        while (flag) {
            if ("".equals(s) || s.length() < 2) {
                return s;
            }
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length - 1; i++) {
                if (Math.abs(chars[i] - chars[i + 1]) == 32) {
                    s = s.substring(0, i) + s.substring(i + 2);
                    break;
                }
                if (i == chars.length - 2) {
                    flag = false;
                }
            }
        }
        return s;
    }


    // 961. 在长度 2N 的数组中找出重复 N 次的元素
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }


    // 412. Fizz Buzz
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                answer.add("FizzBuzz");
            } else if (i % 3 == 0) {
                answer.add("Fizz");
            } else if (i % 5 == 0) {
                answer.add("Buzz");
            } else {
                answer.add(String.valueOf(i));
            }
        }
        return answer;
    }




    @Test
    public void testData() {
        int[] arr1 = new int[]{1,15,6,3};
        int[] ints = Arrays.stream(arr1).limit(100).toArray();
        System.out.println("ints.length = " + ints.length);
        Arrays.stream(arr1).forEach(x -> {
            if (x == 15) {
                throw new RuntimeException("ssd");
            }
            System.out.println("x = " + x);
        });

        System.out.println("end");
    }

    public static void main(String[] args) throws Exception{
        StringBuilder stringBuilder = new StringBuilder();
        for(int j=0;j<10;j++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<100;i++){
                        stringBuilder.append("2");
                    }
                }
            }).start();
        }

        Thread.sleep(100);
        System.out.println(stringBuilder.length());


        Double aDouble = new Double("NAN");
        String s = aDouble.toString();
        System.out.println("s = " + s);


    }

}


