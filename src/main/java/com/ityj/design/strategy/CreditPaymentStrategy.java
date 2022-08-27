package com.ityj.design.strategy;

import java.math.BigDecimal;

public class CreditPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(BigDecimal money) {
        System.out.println("银行卡支付：" + money.toPlainString() + "元！");
    }
}
