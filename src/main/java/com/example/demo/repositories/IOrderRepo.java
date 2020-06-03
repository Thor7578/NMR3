package com.example.demo.repositories;

import com.example.demo.models.Order;
import com.example.demo.models.Season;

import java.util.List;

public interface IOrderRepo {
    public boolean create(Order order);

    public Order read (int mID, Season season);

    public List<Order> readAll();

    public boolean update(Order order);

    public boolean delete(int mID);
}
