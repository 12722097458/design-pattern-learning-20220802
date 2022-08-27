package com.ityj.design.strategy.test;

import java.math.BigDecimal;

public class PaymentService {

    public void pay(PaymentTypeEnum type, BigDecimal money) {
        PaymentTypeEnum.getPaymentStrategy(type).pay(money);
    }
}
