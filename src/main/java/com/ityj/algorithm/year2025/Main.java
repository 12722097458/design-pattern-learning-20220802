package com.ityj.algorithm.year2025;

import java.util.*;
import java.util.stream.Collectors;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        Set<Integer> set = new HashSet<>();
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            set.add(in.nextInt());
        }
        Collection<Integer> collect = set.stream().sorted().collect(Collectors.toList());
        for (int i : collect) {
            System.out.println(i);
        }
    }
}