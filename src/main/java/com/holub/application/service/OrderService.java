package com.holub.application.service;

import com.holub.application.repository.OrderRepository;

public class OrderService {
    private static OrderService instance;
    private final OrderRepository orderRepository = OrderRepository.getInstance();

    private OrderService() {

    }

    public static synchronized OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    public void insert(String description, double cost, String date) {
         OrderRepository.getInstance().insert(description, cost, date);
    }

    public String selectOrderBy(String orderBy) {
        String s = OrderRepository.getInstance().selectOrderBy(orderBy);
        return s;
    }

}
