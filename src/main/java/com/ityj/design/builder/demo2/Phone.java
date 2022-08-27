package com.ityj.design.builder.demo2;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Phone {
    private String screen;
    private String battery;
    private String chip;
    private String os;
}
