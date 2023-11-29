package com.holub.application.repository;

import com.holub.application.setting.SetUp;

public class OrderRepository {
    private static OrderRepository instance;
    private static final SetUp setup = SetUp.getInstance();

    private OrderRepository() {

    }

    public static synchronized OrderRepository getInstance() {
        if (instance == null) {
            instance = new OrderRepository();
        }
        return instance;
    }

    public void insert(String description, double cost, String date) {
        setup.order.insert(new Object[]{description, cost, date});
    }

    public String selectOrderBy(String orderBy) {
        return setup.selectOrderOrderBy(orderBy);
    }
}
