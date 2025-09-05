package com.ityj.design.strategy.test;

import java.math.BigDecimal;

/*
 *   策略模式  灵活替换算法，消除条件判断
 * */
public class TestMain {

    public static void main(String[] args) {

        PaymentService paymentService = new PaymentService();
        paymentService.pay(PaymentTypeEnum.CREDIT, new BigDecimal("6666"));
        paymentService.pay(PaymentTypeEnum.ALIPAY, new BigDecimal("16666"));
        paymentService.pay(PaymentTypeEnum.WECHAT, new BigDecimal("26666"));

    }

}
