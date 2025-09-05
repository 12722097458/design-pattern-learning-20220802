package com.ityj.design.bridge;

/*
*
*  桥接模式
* 、
* 桥接模式在JDK中最经典、最重要的应用就是 JDBC (Java Database Connectivity)。
抽象 (Abstraction)： java.sql.Connection, java.sql.Statement, java.sql.ResultSet 等接口。它们定义了数据库操作的抽象行为（如createStatement, executeQuery）。
精确抽象 (Refined Abstraction)： 通常不存在，因为JDBC API已经设计得很好，应用层代码直接使用标准的Connection等接口。
实现者 (Implementor)： java.sql.Driver 接口。它定义了驱动需要实现的基本连接方法（connect）。这就是那座“桥”。
具体实现者 (Concrete Implementor)： 各大数据库厂商的驱动实现，如：
com.mysql.cj.jdbc.Driver (MySQL)
oracle.jdbc.OracleDriver (Oracle)
org.postgresql.Driver (PostgreSQL)
* */
public class TestMain {
    public static void main(String[] args) {
        OperationSystem os = new Windows(new RmvFile());
        os.playVideo("《Modern Family》");
    }
}
