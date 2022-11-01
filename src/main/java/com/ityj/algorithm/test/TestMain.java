package com.ityj.algorithm.test;

import com.ityj.algorithm.entity.ListNode;
import com.ityj.algorithm.entity.Node;
import com.ityj.algorithm.entity.TreeNode;
import com.ityj.design.command.Chef;
import com.ityj.design.command.Order;
import com.ityj.design.command.OrderCommand;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestMain {
    public static void main(String[] args) {
        Order order = new Order();
        order.setTableNo(1);
        order.addFood("汉堡", 3);
        order.addFood("可乐", 1);
        order.addFood("雪碧", 2);
        OrderCommand orderCommand = new OrderCommand();
        orderCommand.setOrder(order);
        orderCommand.setReceiver(new Chef());

        Order order2 = new Order();
        order2.setTableNo(1);
        order2.addFood("披萨", 3);
        order2.addFood("牛奶", 1);
        OrderCommand orderCommand2 = new OrderCommand();
        orderCommand2.setOrder(order2);
        orderCommand2.setReceiver(new Chef());

        /*Waiter waiter = new Waiter();
        waiter.setCommands(List.of(orderCommand, orderCommand2));
        waiter.execCommand();*/
    }

    public boolean checkString(String s) {
        /*int lastIndexOfA = s.lastIndexOf("a");
        int firstIndexOfB = s.indexOf("b");
        if (lastIndexOfA == -1) {
            return true;
        }
        if (firstIndexOfB == -1) {
            return true;
        }
        return lastIndexOfA < firstIndexOfB;*/
        return !s.contains("ba");
    }


    public int[] rearrangeArray1(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        Arrays.sort(nums);
        int[] arrResult = new int[nums.length];
        int lastIndex = arrResult.length - 1;
        int firstIndex = 1;
        arrResult[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] * 2 != nums[i - 1] + nums[i + 1]) {
                arrResult[firstIndex++] = nums[i];
            } else {
                arrResult[lastIndex--] = nums[i];
            }
        }
        arrResult[firstIndex] = nums[nums.length - 1];
        return arrResult;
    }


    public int[] rearrangeArray2(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] * 2 == nums[i - 1] + nums[i + 1]) {
                int tempNum = nums[i];
                nums[i] =nums[i - 1];
                nums[i - 1] = tempNum;
            }
        }
        return nums;
    }

    public int[] rearrangeArray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        while (true) {
            boolean isSuccess = true;
            for (int i = 1; i < list.size() - 1; i++) {
                if (list.get(i) * 2 == list.get(i - 1) + list.get(i + 1)) {
                    Collections.shuffle(list);
                    isSuccess = false;
                    break;
                }
            }
            if (isSuccess) {
                int[] res = new int[nums.length];
                for (int i = 0; i < list.size(); i++) {
                    res[i] = list.get(i);
                }
                return res;
            }
        }
    }



    // a:97
    public boolean squareIsWhite(String coordinates) {
        char[] chars = coordinates.toCharArray();
        return Integer.sum(chars[0], chars[1]) % 2 != 0;
    }




    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.val == head.val) {
            head = deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }


    @Test
    public void ttt() {
        int[] nums = new int[]{1,2,3,4,5};
        int[] ints = rearrangeArray(nums);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }

        System.out.println((int ) 'a');

        System.out.println(Integer.parseInt("101", 2));

    }


    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        fillNodeValues(list, root);

        for (int i = 0; i < list.size() - 1; i++) {
            Integer firstData = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (k - firstData == list.get(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void fillNodeValues(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        fillNodeValues(list, node.left);
        fillNodeValues(list, node.right);
        if (node.left != null) {
            list.add(node.left.val);
        }
        if (node.right != null) {
            list.add(node.right.val);
        }
    }

    public boolean isMonotonic(int[] nums) {

        if (nums.length <= 2) {
            return true;
        }
        boolean orderFlag = nums[0] > nums[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1] && (nums[i] > nums[i + 1]) != orderFlag) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void teNum() {
        int[] arr = new int[] {6,5,4,4};
        boolean monotonic = isMonotonic(arr);
        System.out.println("monotonic = " + monotonic);
    }


    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        StringBuilder binaryStr = new StringBuilder();
        while (head != null) {
            binaryStr.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(binaryStr.toString(), 2) ;
    }

    public int getDecimalValue2(ListNode head) {
        if (head == null) {
            return 0;
        }
        int res = 0;
        while (head != null) {
            res = (res << 1) + head.val;
            head = head.next;
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        String characters = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for (int i = 0; i < characters.length() / 2; i++) {
            if (characters.charAt(i) != characters.charAt(characters.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void testIsPalindrome() {
        String str = "A man, a plan, a canal: Panama";
        boolean palindrome = isPalindrome(str);
        System.out.println("palindrome = " + palindrome);
    }

    public int percentageLetter(String s, char letter) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                result++;
            }
        }
        //return (int) ((double) result / s.length() * 100);
        return result * 100 / s.length();
    }


    @Test
    public void testPercentageLetter() {
        String str = "kue";
        int o = percentageLetter(str, 'e');
        System.out.println("o = " + o);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }

        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        String strRes = sb.toString();
        for (int i = 0; i < strRes.length() / 2; i++) {
            if (strRes.charAt(i) != strRes.charAt(strRes.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    //双指针 迭代法
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // 递归法
    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }

    public ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode temp = cur.next;
        cur.next = pre;

        return reverse(cur, temp);
    }


    // 递归tree
    public int numColor(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Set<Integer> result = new HashSet<>();
        listTreeNodes(root, result);
        return result.size();
    }

    public void listTreeNodes(TreeNode root, Set<Integer> allNodes) {
        if (root == null) {
            return;
        }
        listTreeNodes(root.left, allNodes);
        listTreeNodes(root.right, allNodes);
        allNodes.add(root.val);
    }

    public String kthDistinct(String[] arr, int k) {
        if (arr == null) {
            return "";
        }
        Map<String, Integer> dataMap = new LinkedHashMap<>();
        for (String s : arr) {
            if (!dataMap.containsKey(s)) {
                dataMap.put(s, 1);
            } else {
                dataMap.put(s, dataMap.get(s) + 1);
            }
        }
        List<String> resultList = new ArrayList<>();
        for (String key : dataMap.keySet()) {
            Integer count = dataMap.get(key);
            if (count == 1) {
                resultList.add(key);
            }
        }
        return k > resultList.size() ? "" : resultList.get(k - 1);
    }


    // 559. N 叉树的最大深度
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        List<Node> children = root.children;
        List<Integer> childrenDepth = new ArrayList<>();
        for (Node child : children) {
            childrenDepth.add(maxDepth(child));
        }

        int maxNum = 0;
        for (Integer num : childrenDepth) {
            if (num > maxNum) {
                maxNum = num;
            }
        }

        return maxNum + 1;

    }


    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> result = new ArrayList<>();
        int maxCandies = 0;
        for (int candy : candies) {
            if (candy > maxCandies) {
                maxCandies = candy;
            }
        }
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }
        return result;
    }

    public boolean haveConflict(String[] event1, String[] event2)  {

        String event1_start = event1[0];
        String event1_end = event1[1];

        String event2_start = event2[0];
        String event2_end = event2[1];

        return (isNotAfter(event1_start, event2_start) && isNotAfter(event2_start, event1_end))
                || (isNotAfter(event2_start, event1_start) && isNotAfter(event1_start, event2_end));

    }

    public boolean haveConflict2(String[] event1, String[] event2)  {
        String event1_start = event1[0];
        String event1_end = event1[1];

        String event2_start = event2[0];
        String event2_end = event2[1];
        return event1_start.compareTo(event2_start) < 0 ? event1_end.compareTo(event2_start) > 0 : event1_start.compareTo(event2_end) <= 0;
    }

    public boolean isNotAfter(String dateStr1, String dateStr2) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            Date date1 = sdf.parse(dateStr1);
            Date date2 = sdf.parse(dateStr2);
            return !date1.after(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }


    // ["14:13","22:08"]
    //["02:40","08:08"]
    @Test
    public void testHaveConflict() throws ParseException {
        boolean b = haveConflict2(new String[] {"14:13","22:08"}, new String[] {"02:40","08:08"});
        System.out.println("b = " + b);

    }

    public int missingNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);

        if (nums[0] != 0) {
            return 0;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] != 1) {
                return nums[i] + 1;
            }
        }
        return nums[nums.length - 1] + 1;
    }



    public int missingNumber2(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }



        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return nums.length * (nums.length - 1) / 2 - sum;

    }

    public int minArray(int[] numbers) {
        int min = numbers[0];
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    public String licenseKeyFormatting(String s, int k) {
        if (s == null) {
            return null;
        }

        if (k < 0) {
            return null;
        }
        s = s.replace("-", "").toUpperCase(Locale.ROOT);
        if (s.length() == 0) {
            return "";
        }
        int headLength = s.length() % k;
        int beginIndex = 0;
        int endIndex = headLength == 0 ? k : headLength;
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(s.substring(beginIndex, endIndex)).append("-");
            int temp = endIndex;
            endIndex = endIndex + k;
            beginIndex = temp;
            if (beginIndex == s.length()) {
                break;
            }
            if (endIndex > s.length()) {
                sb.append(s.substring(beginIndex)).append("-");
                break;
            }
        }
       return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public String licenseKeyFormatting2(String s, int k) {
        if (s == null) {
            return null;
        }

        if (k < 0) {
            return null;
        }
        s = s.replace("-", "").toUpperCase(Locale.ROOT);
        if (s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = sb.length() - k; i > 0 ; i = i - k) {
            sb.insert(i, "-");
        }
        return sb.toString();
    }

    @Test
    public void testSp() {
        String str = "r";
        String s = licenseKeyFormatting(str, 2);
        System.out.println("s = " + s);
    }


    public boolean isAlienSorted(String[] words, String order) {
        if (order == null || "".equals(order)) {
            return false;
        }

        if (words == null) {
            return false;
        }

        if (words.length == 1) {
            return true;
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (j == words[i + 1].length()) {
                    return false;
                }
                if (order.indexOf(words[i].charAt(j)) > order.indexOf(words[i + 1].charAt(j))) {
                    return false;
                } else if (order.indexOf(words[i].charAt(j)) < order.indexOf(words[i + 1].charAt(j))) {
                    break;
                }
            }
        }

        return true;
    }

    @Test
    public void isAlienSortedTest() {
        String[] str = new String[] {"word","world"};
        String order = "worldabcefghijkmnpqstuvxyz";
        boolean alienSorted = isAlienSorted(str, order);
        System.out.println("alienSorted = " + alienSorted);
    }

    public List<Integer> addToArrayForm(int[] num, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = num.length - 1; i >= 0 ; i--) {
            int lastData = num[i];
            int sumData = lastData + k;
            if (i == 0 && k > 0) {
                sb.append(new StringBuilder(String.valueOf(sumData)).reverse().toString());
            } else {
                sb.append(sumData % 10);
            }
            k = sumData / 10;
        }
        String str = sb.reverse().toString();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            res.add(Integer.valueOf(str.charAt(i) + ""));
        }
        return res;
    }

    @Test
    public void addToArrayFormTest() {
        int[] num = new int[] {2,1,5};
        int add = 806;
        List<Integer> integers = addToArrayForm(num, add);
        System.out.println("integers = " + integers);
    }


    public static int[] twoSum(int[] nums, int target) {

        int[] index = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int firstNum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - firstNum) {
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }
        return index;
    }

}


