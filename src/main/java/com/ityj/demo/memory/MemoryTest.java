package com.ityj.demo.memory;

import com.carrotsearch.sizeof.RamUsageEstimator;
import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MemoryTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Runtime r = Runtime.getRuntime();
        long startRAM = r.freeMemory();
        List<String> listRAM = new ArrayList<>();;
        int loopTimes = 100000000;
        String string = "摘抄自出师表…………太长了，不粘在这里";
        for(int i = 0;i < loopTimes;i++) {
            listRAM.add(string);
        }
        long endRAM = r.freeMemory();
        Field f = ArrayList.class.getDeclaredField("elementData");
        f.setAccessible(true);
        Object[] o = (Object[]) f.get(listRAM);

        //方案1 使用Runtime内存管理类

        System.out.println("startRAM = " + startRAM);
        System.out.println("endRAM = " + endRAM);
        String result = "测试RAM结束，测试占用内存空间约为 : " + (startRAM - endRAM);
        System.out.println(result);

        //方案2 反射的方式查询ArrayList的实际申请长度，然后按照每个字符串申请了2字节进行计算

        result = "测试RAM结束，测试占用内存空间约为 : " + ((long)o.length * (long)string.length() * 2);
        System.out.println(result);

        //方案3 反射的方式查询ArrayList的实际申请长度，然后取字符串的字节数组长度计算

        result = "测试RAM结束，测试占用内存空间约为 : " + ((long)o.length * (long)string.getBytes().length);
        System.out.println(result);
    }

    @Test
    public void testMemory() {
        Runtime r = Runtime.getRuntime();
        long startRAM = r.freeMemory();
        List<Dog> dogList = new ArrayList<>();
        for(int i = 0; i < 10000;i++) {
            Dog dog = new Dog();

            dogList.add(dog);
        }
        long endRAM = r.freeMemory();
        System.out.println("startRAM = " + startRAM);
        System.out.println("endRAM = " + endRAM);
        String result = "测试RAM结束，测试占用内存空间约为 : " + (startRAM - endRAM);
        System.out.println(result);

        //System.out.println("dog::: " + RamUsageEstimator.humanReadableUnits(RamUsageEstimator.alignObjectSize(dogList)));
        String s = RamUsageEstimator.humanSizeOf(dogList);
        System.out.println("s = " + s);

        System.out.println(ClassLayout.parseClass(Dog.class).toPrintable());

    }
}
