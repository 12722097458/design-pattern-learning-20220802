package com.ityj.design.strategy;

import java.math.BigDecimal;

public class AlipayPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(BigDecimal money) {
        System.out.println("支付宝支付：" + money.toPlainString() + "元！");
    }
}
