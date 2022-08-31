package com.ityj.design.singleton.singletonbreak.issue.seri;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/*
 *  破坏单例，通过反序列化创建两个对象
 * */
@Slf4j
public class IssueTest {
    public static void main(String[] args) {
        //writeObject2File();
        readObjectFromFile();
        readObjectFromFile();
    }

    public static void writeObject2File() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/singleton/singleton.data"));) {
            oos.writeObject(SingletonSerializableIssue.getInstance());
            log.info("文件导出成功！");
        } catch (IOException e) {
            log.error("Error occurred:", e);
        }
    }

    public static void readObjectFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/singleton/singleton.data"));) {
            SingletonSerializableIssue instance = (SingletonSerializableIssue) ois.readObject();
            log.info("instance is : {}", instance);
        } catch (IOException | ClassNotFoundException e) {
            log.error("Error occurred:", e);
        }
    }
}
