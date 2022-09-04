package com.ityj.design.responsibility;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LeaveRequest {
    private String name;
    private int leaveDays;
    private String comments;
}
