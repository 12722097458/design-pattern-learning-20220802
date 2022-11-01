package com.ityj.algorithm.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestNovember {
    public int largestInteger(int num) {
        List<Integer> dataList = new ArrayList<>();
        while (true) {
            int last = num % 10;
            num = num / 10;
            dataList.add(last);
            if (num == 0) {
                break;
            }
        }
        Collections.reverse(dataList);
        for (int i = 0; i < dataList.size(); i++) {
            for (int j = i + 1; j < dataList.size(); j++) {
                Integer first = dataList.get(i);
                Integer second = dataList.get(j);
                if (second % 2 != first % 2) {
                    continue;
                }
                if (second <= first) {
                    continue;
                }
                dataList.set(i, second);
                dataList.set(j, first);
            }
        }
        int result = 0;
        for (Integer data : dataList) {
            result = result * 10 + data;
        }
        return result;
    }

    @Test
    public void largestIntegerTest() {
        int i = largestInteger(266);
        System.out.println("i = " + i);
    }
}


