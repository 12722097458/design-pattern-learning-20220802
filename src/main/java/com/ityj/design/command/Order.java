package com.ityj.design.command;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private int tableNo;
    private Map<String, Integer> foodMap;

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public Map<String, Integer> getFoodMap() {
        return foodMap;
    }

    public void addFood(String foodName, int foodCount) {
        if (getFoodMap() == null) {
            foodMap = new HashMap<>();
        }
        foodMap.put(foodName, foodCount);
    }
}
