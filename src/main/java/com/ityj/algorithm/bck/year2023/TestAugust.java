package com.ityj.algorithm.bck.dir2022.year2023;

import com.ityj.algorithm.entity.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@Slf4j
public class TestAugust {


    // 203. 移除链表元素
    // https://www.bilibili.com/video/BV18B4y1s7R9/?vd_source=b23569b676ce26126febad3c290b16e8
    public ListNode removeElements(ListNode head, int val) {
        // 如果第一个节点就是val, 那么直接删除head.
        while (head != null && head.val == val) {
            head = head.next;
        }

        // 针对头节点不是val的情况，需要做以下处理
        // cur 算是一个临时变量， 一致循环head的next. 判断是否为val., 所以最终应该把head返回
        ListNode cur = head;
        while (cur != null && cur.next!= null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    // 使用虚拟头节点来实现链表删除指定元素，好处是不用区分头节点和中间节点
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }

    // 495. 提莫攻击
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i + 1] - timeSeries[i] >= duration) {
                result += duration;
            } else {
                result += timeSeries[i + 1] - timeSeries[i];
            }
        }
        return result;
    }


    // 1304. 和为零的 N 个不同整数
    public int[] sumZero(int n) {
        int[] res = new int[n];

        for (int i = 0; i < n - 1; i++) {
            res[i] = i + 1;   // i 会出现[0,0]的错误
        }
        res[n - 1] = -Arrays.stream(res).sum();
        return res;
    }


    @Test
    public void testData() {
        int[] arr1 = new int[]{1,15,6,3};

    }

    public static void main(String[] args) {
        int num = 0;
        while (true) {
            log.info(num + "");
            /*if (Thread.interrupted()) {
                log.info("中断。。。");
                break;
            }*/

            if (num++ == 10) {
                log.info("before Thread.currentThread().interrupt()");
                Thread.currentThread().interrupt();
                log.info("after Thread.currentThread().interrupt()");
            }
        }

    }


}


