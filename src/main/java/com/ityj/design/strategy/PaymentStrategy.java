package com.ityj.design.strategy;

import java.math.BigDecimal;

public interface PaymentStrategy {

    void pay(BigDecimal money);

}
