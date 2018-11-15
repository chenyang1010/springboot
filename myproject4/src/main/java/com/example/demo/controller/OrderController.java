package com.example.demo.controller;

import com.dangdang.ddframe.rdb.sharding.keygen.KeyGenerator;
import com.example.demo.entity.Order;
import com.example.demo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping("/insert")
    public Object insert() {
        for (int i = 20; i < 30; i++) {
            Order order = new Order();
            order.setUserId((long) i);
            order.setOrderId((long) i);
            orderMapper.insert(order);
        }
        for (int i = 30; i < 40; i++) {
            Order order = new Order();
            order.setUserId((long) i + 1);
            order.setOrderId((long) i);
            orderMapper.insert(order);
        }

        return "success";
    }

    @RequestMapping("queryById")
    public List<Order> queryById(String orderIds) {
        List<String> strings = Arrays.asList(orderIds.split(","));
        List<Long> orderIdList = strings.stream().map(item -> Long.parseLong(item)).collect(Collectors.toList());
        return orderMapper.queryById(orderIdList);
    }
}