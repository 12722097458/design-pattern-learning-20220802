package com.ityj.design.singleton.singletonbreak.solve.seri;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class IssueSolveTest {
    public static void main(String[] args) {
        writeObject2File();
        readObjectFromFile();
        readObjectFromFile();
    }

    public static void writeObject2File() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/singleton/singleton_solve.data"));) {
            oos.writeObject(SingletonSerializableSolve.getInstance());
            log.info("文件导出成功！");
        } catch (IOException e) {
            log.error("Error occurred:", e);
        }
    }

    public static void readObjectFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/singleton/singleton_solve.data"));) {
            SingletonSerializableSolve instance = (SingletonSerializableSolve) ois.readObject();
            log.info("instance is : {}", instance);
        } catch (IOException | ClassNotFoundException e) {
            log.error("Error occurred:", e);
        }
    }
}
