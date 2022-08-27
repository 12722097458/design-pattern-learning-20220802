package com.ityj.design.prototype.deepclone;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
*   通过objectStream流实现深克隆
*
* */
@Slf4j
public class DeepCloneTestMain {
    public static void main(String[] args) throws CloneNotSupportedException {

        /*
            深克隆：创建一个新的对象，对象的属性指向新的内存地址
        *
        * */

        Student jack = new Student();
        jack.setName("Jack");
        Award award = new Award();
        award.setStudent(jack);

        writeObject2File(award);

        Award award1 = readObjectFromFile();
        award.show();
        award1.show();
        System.out.println(award.getStudent() == award1.getStudent());




    }

    private static void writeObject2File(Award award) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/prototype/award.dat"))) {
            oos.writeObject(award);
        } catch (Exception e) {
            log.error("Error : ", e);
        }
    }

    private static Award readObjectFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/prototype/award.dat"))) {
            return (Award) ois.readObject();
        } catch (Exception e) {
            log.error("Error : ", e);
        }
        return null;
    }


}
