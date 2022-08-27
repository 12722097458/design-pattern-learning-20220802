package com.ityj.design.strategy.test;

import com.ityj.design.strategy.AlipayPaymentStrategy;
import com.ityj.design.strategy.CreditPaymentStrategy;
import com.ityj.design.strategy.PaymentStrategy;
import com.ityj.design.strategy.WeChatPaymentStrategy;

public enum PaymentTypeEnum {
    CREDIT,
    ALIPAY,
    WECHAT;

    public static PaymentStrategy getPaymentStrategy(PaymentTypeEnum type) {
        switch (type) {
            case CREDIT:
                return new CreditPaymentStrategy();
            case ALIPAY:
                return new AlipayPaymentStrategy();
            case WECHAT:
                return new WeChatPaymentStrategy();
            default:
                throw new RuntimeException("Payment Type is invalid!");
        }
    }
}
