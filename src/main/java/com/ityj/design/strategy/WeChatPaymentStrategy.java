package com.ityj.design.strategy;

import java.math.BigDecimal;

public class WeChatPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(BigDecimal money) {
        System.out.println("微信支付：" + money.toPlainString() + "元！");
    }
}
