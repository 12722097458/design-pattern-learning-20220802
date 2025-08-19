package com.ityj.demo.tech.threadlocal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalTest {


    /*
    * 从名字我们就可以看到ThreadLocal 叫做本地线程变量，意思是说，ThreadLocal 中填充的的是当前线程的变量，该变量对其他线程而言是封闭且隔离的，
    * ThreadLocal 为变量在每个线程中创建了一个副本，这样每个线程都可以访问自己内部的副本变量。

        `从字面意思很容易理解，但是实际角度就没那么容易了，作为一个面试常问的点，使用场景也是很丰富。

        1、在进行对象跨层传递的时候，使用ThreadLocal可以避免多次传递，打破层次间的约束。
        2、线程间数据隔离
        3、进行事务操作，用于存储线程事务信息。
        4、数据库连接，Session会话管理。`
    *
    * */
    private static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) throws InterruptedException {

        threadLocal.set("hhh");

        log.info(Thread.currentThread().getName() + "     " + threadLocal.get());

        //threadLocal.remove();
        Thread thread = new Thread(() -> {
            log.info(Thread.currentThread().getName() + "     " + threadLocal.get());
            threadLocal.set("inner thread");
            log.info(Thread.currentThread().getName() + "     " + threadLocal.get());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info(Thread.currentThread().getName() + "     " + threadLocal.get());
        });
        thread.start();
        Thread.sleep(2322);
        log.info(Thread.currentThread().getName() + "     " + threadLocal.get());
        threadLocal.remove();
        log.info(Thread.currentThread().getName() + "     " + threadLocal.get());
    }


}
