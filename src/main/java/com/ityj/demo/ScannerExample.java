package com.ityj.demo;

import java.util.Scanner;

// https://blog.csdn.net/qq_34826261/article/details/97616358
public class ScannerExample {
    public static void main(String[] args) {
        // 创建Scanner对象，关联标准输入流
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入您的姓名: ");
        String name = scanner.nextLine();  // 读取整行文本

        System.out.print("请输入您的年龄: ");
        int age = scanner.nextInt();       // 读取整数

        System.out.print("请输入您的身高(m): ");
        double height = scanner.nextDouble();  // 读取浮点数

        System.out.printf("姓名: %s, 年龄: %d, 身高: %.2f\n", name, age, height);

        // 关闭Scanner（重要！避免资源泄漏）
        scanner.close();
    }
}
