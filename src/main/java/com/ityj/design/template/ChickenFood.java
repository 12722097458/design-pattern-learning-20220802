package com.ityj.design.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChickenFood extends AbstractCook {

    @Override
    protected void cook() {
        log.info("准备食材，开始做鸡肉饭！");
    }
}
