package com.ityj.algorithm.test;

import com.ityj.algorithm.entity.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestFebruary {

    // 100. 相同的树
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q != null) {
            return false;
        }

        if (p != null && q == null) {
            return false;
        }

        if (p == null && q == null) {
            return true;
        }

        if (p.val != q.val) {
            return false;
        }
        boolean leftRes = isSameTree(p.left, q.left);
        boolean rightRes = isSameTree(p.right, q.right);
        return leftRes && rightRes;
    }

    // 剑指 Offer 26. 树的子结构  ==>B是A的子结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        // 约定空树不是任意一个树的子结构: 所以如果B为空，返回false
        // 如果A为null, 那么A就没有子树了
        if (A == null || B == null) {
            return false;
        }
        // root先判断A/B是否相等
        // 再通过递归，一层一层拿left right  进行判断  ==> 最终目的是找到A的某一个节点.val 和 B相等，再层层递归看是否B是A的一部分(dfs())
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }


    // 深度优先搜索(DFS)
    public boolean dfs(TreeNode p, TreeNode q) {
        // 先判断B是否为空，如果B为空，说明B已经遍历完毕，那么B就是A的子树（前面判断了root A/B都不为空）。
        if (q == null) {
            return true;
        }

        // B不为空的情况下，如果A为空，说明不会满足子树条件
        if (p == null) {
            return false;
        }

        // 如果root.val相等， 那么就开始判断两者的左子树与右子树是否满足B是A的一部分 ==》 B先遍历完，即先返回NULL
        if (p.val == q.val) {
            boolean left = dfs(p.left, q.left);
            boolean right = dfs(p.right, q.right);
            return left && right;
        }

        return false;

    }


    // 建议先做这道题：100. 相同的树，并注意与这道题的区别：剑指 Offer 26. 树的子结构。与字符串对比的话，子树就相当于字符串的子串（要求连续），树的子结构就相当于字符串的子序列（不要求连续）
    // 572. 另一棵树的子树
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 用来递归，会出现root.child为  NULL, 题目说了subRoot节点大于0
        if (root == null) {
            return false;
        }
        // 先判断root, 然后判断left和right
        return dfs2(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean dfs2(TreeNode root, TreeNode subRoot) {
        // 遍历出现root和subRoot都结束时，表示二者相等
        if (root == null && subRoot == null) {
            return true;
        }
        // 当然如果出现一个null, 一个有值，表示二者不等，需返回false.  在下面做的判断处理
        // root.val相等， 如果两者的所有子节点也等，则满足条件，返回true.
        if ((root != null && subRoot!= null) && root.val == subRoot.val) {
            boolean left = dfs2(root.left, subRoot.left);
            boolean right = dfs2(root.right, subRoot.right);
            return left && right;
        }
        return false;
    }


    // 1281. 整数的各位积和之差
    public int subtractProductAndSum(int n) {
        int sum = 0;
        // 设置一个特殊值
        int product = 1;

        while (true) {
            int remainder = n % 10;
            int left = n / 10;
            sum += remainder;
            product *= remainder;
            // 更新n的值
            n = left;
            // 除以10后，只有余数则返回
            if (left == 0) {
                break;
            }
        }
        return product - sum;
    }



    /*
    *   二叉搜索树（BST，Binary Search Tree），也称二叉排序树或二叉查找树。
        二叉搜索树：一棵二叉树，可以为空；如果不为空，满足以下性质：

        非空左子树的所有键值小于其根结点的键值。
        非空右子树的所有键值大于其根结点的键值。
        左、右子树都是二叉搜索树。
    * */
    // 700. 二叉搜索树中的搜索
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        // root 和 val相等，则直接返回
        if (root.val == val) {
            return root;
        }
        // root 大于了value， 最终结果就在root的左子树里
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        // root 小于了value， 最终结果就在root的右子树里
        return searchBST(root.right, val);
    }



    // 283. 移动零: 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
    public void moveZeroes_(int[] nums) {
        int currentIndex = 0;
        // 一次遍历，遇到0就找当前索引后面的最近一个非0值，给他替换过来。 效率很低
        while (true) {

            if (currentIndex == nums.length - 1) {
                return;
            }

            if (nums[currentIndex] == 0) {
                int rightLatestNotZeroIndex =  getRightLatestNotZeroIndex(nums, currentIndex);
                nums[currentIndex] = nums[rightLatestNotZeroIndex];
                nums[rightLatestNotZeroIndex] = 0;
            }
            currentIndex++;
        }
    }

    public int getRightLatestNotZeroIndex(int[] nums, int currentIndex) {
        while (true) {
            if (currentIndex == nums.length - 1) {
                break;
            }
            if (nums[currentIndex] != 0) {
                break;
            }
            currentIndex++;
        }
        return currentIndex;
    }


    public void moveZeroes(int[] nums) {
        // 这个索引表示前面的数都是非零
        int notZeroIndex = 0;
        // 将非0的值放到最前面
        for (int num : nums) {
            if (num != 0) {
                nums[notZeroIndex++] = num;
            }
        }

        // 将0放在后面
        for (int i = notZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    // 1233. 删除子文件夹
    public List<String> removeSubfolders(String[] folder) {
        // 将所有全路径去重，放入set里
        Set<String> folderSet = new HashSet<>(Arrays.asList(folder));
        List<String> result = new ArrayList<>();
        for (String s : folder) {
            boolean isSubFolderFlag = false;
            for (int i = s.length() - 1; i > 0; i--) {
                // /bgif/bwmi/ccnw/ccnx/ccum/ccwy/ccxo
                // 倒叙遍历， 遇到/就截取字符串，判断是否在folderSet里。 在的话就是subFolder
                if (s.charAt(i) == '/' && folderSet.contains(s.substring(0, i))) {
                    isSubFolderFlag = true;
                    break;
                }
            }
            if (!isSubFolderFlag) {
                result.add(s);
            }
        }
        return result;
    }

    // 2129. 将标题首字母大写
    public String capitalizeTitle(String title) {
        title = title.toLowerCase(Locale.ROOT);
        String[] strings = title.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String str : strings) {
            if (str.length() <= 2) {
                sb.append(str).append(" ");
            } else {
                sb.append(beginerUpperCase(str)).append(" ");
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    private String beginerUpperCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                sb.append((char) (str.charAt(0) - 32));    // A65  a97
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    // 561. 数组拆分
    // 1 3 5 7 。。。 求和即可
    public int arrayPairSum(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                res += nums[i];
            }
        }
        return res;
    }

    // 1832. 判断句子是否为全字母句
    public boolean checkIfPangram(String sentence) {
        Set<Character> directory = new HashSet<>();

        sentence.chars().forEach(x -> {
            directory.add((char) x);
        });
        return directory.size() == 26;
    }


    // 202. 快乐数
    public boolean isHappy(int n) {
        while (true) {
            int temp = 0;
            // 遍历n, 进行各个数字求和
            while (true) {
                int suffix = n % 10;
                int prefix = n / 10;
                temp += suffix * suffix;
                n = prefix;
                if (prefix == 0 ) {
                    break;
                }
            }
            n = temp;
            if (n < 10) {
                // 1 和 7 最终都能收敛到1
                return n == 1 || n == 7;
            }
        }

    }

    // 557. 反转字符串中的单词 III
    public String reverseWords(String s) {
        String[] splitArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : splitArr) {
            sb.append(new StringBuilder(str).reverse()).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    // 2379. 得到 K 个黑块的最少涂色次数
    public int minimumRecolors(String blocks, int k) {
        Integer result = null;

        // 滑动窗口。每次移动一格，看格子里白色块最少的就是最终结果
        for (int i = 0; i < blocks.length() - (k - 1); i++) {
            String windowStr = blocks.substring(i, i + k);
            int whiteCount = 0;
            for (char c : windowStr.toCharArray()) {
                if (c == 'W') {
                    whiteCount++;
                }
            }
            if (result == null) {
                result = whiteCount;
            } else {
                result = Math.min(result, whiteCount);
            }
        }
        return result;

    }

    // 1732. 找到最高海拔
    public int largestAltitude(int[] gain) {

        int height = 0;
        for (int i = 0; i < gain.length; i++) {
            height += gain[i];
            gain[i] = height;
        }

        int max = 0;  // 初识海拔0
        for (int i : gain){
            if (i > max) {
                max = i;
            }
        }
        return max;

    }

    // 剑指 Offer 58 - I. 翻转单词顺序
    public String reverseWords2(String s) {
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            if ("".equals(str)) {
                continue;
            }
            sb.insert(0, " ").insert(0, str);
        }
        if (sb.length() == 0) {
            return "";
        }
        return sb.substring(0, sb.length() - 1);
    }

    // LCS 02. 完成一半题目
    public int halfQuestions(int[] questions) {
        int personNum = questions.length / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : questions) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<Integer> values = new ArrayList<>();
        map.forEach((x, y) -> {
            values.add(y);
        });

        values.sort(Comparator.reverseOrder());
        int sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum += values.get(i);
            if (sum >= personNum) {
                return i + 1;
            }
        }
        return 0;
    }

    // 1295. 统计位数为偶数的数字
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    // 2169. 得到 0 的操作数
    public int countOperations(int num1, int num2) {
        int result = 0;
        while (true) {
            if (num1 == 0 || num2 == 0) {
                break;
            }
            if (num1 >= num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
            result++;
        }
        return result;
    }

    // 剑指 Offer 15. 二进制中1的个数
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            /*
            *   总结：两位同时为1，结果才为1，否则结果为0。
                例如：3&5 即 0000 0011& 0000 0101 = 0000 0001，因此 3&5 的值得1。
            *
            * */
            if ((n & 1) == 1) {
                result++;
            }

            // 无符号位移，向右移动一位(除以2)，最高位符号位补0
            n = n >>> 1;
        }
        return result;
    }

    // 509. 斐波那契数
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // 0 1 1 2 3 5
    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // 一次遍历，记录下n-2 和 n-1的值，直接返回。 无需两次递归
        int n2 = 0;  // default n=0  --> 0
        int n1 = 1;  // default n=1  --> 1
        int sum = 0;  // 记录n-2 + n-1
        for (int i = 2; i <= n; i++) {
            sum = n2 + n1;
            n2 = n1;
            n1 = sum;
        }
        return sum;
    }

    // 1480. 一维数组的动态和
    public int[] runningSum(int[] nums) {
        Integer sum = null;
        for (int i = 0; i < nums.length; i++) {
            if (sum == null) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            nums[i] = sum;
        }
        return nums;
    }

    // 414. 第三大的数
    public int thirdMax(int[] nums) {
        int[] ints = Arrays.stream(nums).distinct().sorted().toArray();
        if (ints.length < 3) {
            return ints[ints.length - 1];
        }
        return ints[ints.length - 3];
    }

    // 面试题 01.02. 判定是否互为字符重排
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (char c : s1.toCharArray()) {
            s2 = s2.replaceFirst(String.valueOf(c), "");
        }
        return "".equals(s2);
    }

    // 944. 删列造序
    public int minDeletionSize(String[] strs) {
        // 存不是递增出现对应的索引
        List<Integer> list = new ArrayList<>();
        if (strs.length == 1) {
            return 0;
        }
        // 前一个字符串
        String str0 = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            // 拿当前的字符串和前一个比较，如果对应索引的值是递减的，那么这一列是需要删除的。存入list里
            for (int j = 0; j < str0.length(); j++) {
                if (list.contains(j)) {
                    continue;
                }
                if (str.charAt(j) < str0.charAt(j)) {
                    list.add(j);
                }
            }
            str0 = strs[i];
        }
        return list.size();
    }

    // 958. 二叉树的完全性检验
    // 递层遍历， 从左到右第一个出现null终止，如果右边还有节点。那么就是不完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>(); // ArrayQueue不能放null
        queue.offer(root);   // addLast

        TreeNode cur;
        boolean hasNullFlag = false;
        while ((cur = queue.poll()) != null) {  // 拿队列里第一个Node, 可以保证递层遍历tree
            // 出现了Null, 并且后面又出现了节点(右边，或下一层)，不是完全二叉树
            if (hasNullFlag && (cur.left != null || cur.right != null)) {
                return false;
            }

            // 出现null， 做标记
            if (!hasNullFlag && (cur.left == null || cur.right == null)) {
                hasNullFlag = true;
                // 此节点左null, 右有值.  false
                if (cur.left == null && cur.right != null) {
                    return false;
                }
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return true;  // 满二叉树
    }

    // 1051. 高度检查器
    public int heightChecker(int[] heights) {
        int[] cloneArr = heights.clone();
        Arrays.sort(cloneArr);
        int result = 0;
        for (int i = 0; i < cloneArr.length; i++) {
            if (cloneArr[i] != heights[i]) {
                result++;
            }
        }
        return result;
    }

    // 938. 二叉搜索树的范围和
    public int rangeSumBST(TreeNode root, int low, int high) {
        return sumTreeNode(root, low, high, 0);
    }

    public int sumTreeNode(TreeNode root, int low, int high, int sum) {
        if (root != null) {
            if (root.val >= low && root.val <= high) {
                sum += root.val;
            }
            sum = sumTreeNode(root.left, low, high, sum);
            sum = sumTreeNode(root.right, low, high, sum);
        }
        return sum;
    }

    // 2465. 不同的平均值数目
    public int distinctAverages(int[] nums) {
        Set<Double> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            set.add(((double) (nums[i] + nums[nums.length -1 - i]) / 2));
        }
        return set.size();
    }

    // 2000. 反转单词前缀
    public String reversePrefix(String word, char ch) {
        if (!word.contains(String.valueOf(ch))) {
            return word;
        }
        String toReverse = word.substring(0, word.indexOf(ch) + 1);
        String last = word.substring(word.indexOf(ch) + 1);
        // 把不反转的放入sb
        StringBuilder sb = new StringBuilder(last);
        for (char c : toReverse.toCharArray()) {
            // 依次插入到sb的最前面
            sb.insert(0, c);
        }
        return sb.toString();
    }

    // 2027. 转换字符串的最少操作次数
    public int minimumMoves(String s) {
        int resultCount = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'O') {
                // 啥也不干i+1， 继续下次遍历
                continue;
            }
            // 第一个就是X，需要转换
            resultCount++;
            i += 2;
        }
        return resultCount;
    }

    // 94. 二叉树的中序遍历  ==> 左根右
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    /*
    *   https://www.bilibili.com/video/BV1Wh411S7xt/?from=search&seid=5284955273268085565&vd_source=b23569b676ce26126febad3c290b16e8
    *  递归三要素：
    *   1. 确定递归函数的参数和返回值
    *   2. 确定终止条件
    *   3. 确定单层递归的逻辑
    *
    * */
    public void inorder(TreeNode cur, List<Integer> data) {
        if (cur == null) {
            return;
        }
        inorder(cur.left, data);
        data.add(cur.val);
        inorder(cur.right, data);
    }

    // 1991. 找到数组的中间位置
    public int findMiddleIndex(int[] nums) {
        // 总和
        int sum = Arrays.stream(nums).sum();
        // 左边的数字和
        int sumLeft = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sumLeft == sum - sumLeft - nums[i]) {
                return i;
            }
            sumLeft += nums[i];
        }
        return -1;
    }

    // 1619. 删除某些元素后的数组均值
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int exclude = arr.length / 20;
        for (int i = 0; i < exclude; i++) {
            arr[i] = 0;
            arr[arr.length - 1 - i] = 0;
        }
        // 精度问题不能忽略   integer 转成double再进行计算。。   int / int ==> int
        return Arrays.stream(arr).asDoubleStream().sum() / (arr.length - 2 * exclude);
    }

    // 520. 检测大写字母
    public boolean detectCapitalUse2(String word) {
        return word.matches("^[a-z]+$")
                || word.matches("^[A-Z]+$")
                || word.matches("^[A-Z][a-z]*$");
    }

    public boolean detectCapitalUse(String word) {
        // 所有字母都是小写
       if (word.toLowerCase(Locale.ROOT).equals(word)) {
           return true;
       }
       // 所有字母都是大写
       if (word.toUpperCase(Locale.ROOT).equals(word)) {
           return true;
       }
       // 第二位开始变小写， 如果和原来的word一样。 说明1. 后面都是小写  有因为不可能同为大写或小写(前面校验)， 所以2. 开头必为大写
        if (word.substring(1).toLowerCase(Locale.ROOT).equals(word.substring(1))) {
            return true;
       }
       return false;
    }

    // 1137. 第 N 个泰波那契数
    public int tribonacci_timeout(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        //3次递归，超出时间限制
        return tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
    }

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = result;
        }
        return result;
    }


    // 884. 两句话中的不常见单词
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] s1Arr = s1.split(" ");
        String[] s2Arr = s2.split(" ");
        Map<String, Integer> map = new HashMap<>();

        Arrays.stream(s1Arr).forEach(x -> {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        });
        Arrays.stream(s2Arr).forEach(x -> {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        });


        List<String> collect = map.entrySet().stream().filter(e -> 1 == e.getValue()).map(Map.Entry::getKey).collect(Collectors.toList());
        String[] result = new String[collect.size()];
        // 将ArrayList对象转换成数组
        collect.toArray(result);
        return result;
    }

    // 258. 各位相加
    public int addDigits(int num) {
        int sum = 0;
        while (true) {
            int left = num / 10;
            int right = num % 10;
            sum += right;
            num = left;

            if (left < 10) {
                sum += left;
                if (sum < 10) {
                    return sum;
                }
                num = sum;
                // 重置计数器
                sum = 0;
            }
        }
    }


    // 2016. 增量元素之间的最大差值
    public int maximumDifference2(int[] nums) {
        int result = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] <= nums[i]) {
                    continue;
                }
                int cur = nums[j] - nums[i];
                if (result == -1) {
                    result = cur;
                }
                if (cur > result) {
                    result = cur;
                }
            }
        }
        return result;
    }

    // 评论说的一个股票题？
    public int maximumDifference(int[] nums) {
        // min 代表的是循环出来的最小元素
        int min = Integer.MAX_VALUE;
        int max = -1;

        for (int num : nums) {
            if (num < min) {
                min = num;
            } else if (num > min) {
                // 取 当前元素-最小元素  和   之前确认好的max进行比较。 取大值
                max = Math.max(max, num - min);
            }
        }
        return max;
    }

    // 257. 二叉树的所有路径
    public List<String> binaryTreePaths(TreeNode root) {
        return null;
    }


    // 268. 丢失的数字  数学思维，求和 -  已有的  = 缺的那个
    public int missingNumber(int[] nums) {
        int allNum = (nums.length * (nums.length + 1)) / 2;
        return allNum - Arrays.stream(nums).sum();
    }






    @Test
    public void testDemo() {
        int[] ints = {4,8,4,10,0,7,1,3,7,8,8,3,4,1,6,2,1,1,8,0,9,8,0,3,9,10,3,10,1,10,7,3,2,1,4,9,10,7,6,4,0,8,5,1,2,1,6,2,5,0,7,10,9,10,3,7,10,5,8,5,7,6,7,6,10,9,5,10,5,5,7,2,10,7,7,8,2,0,1,1};
        double v = trimMean(ints);
        System.out.println("v = " + v);

    }

}


