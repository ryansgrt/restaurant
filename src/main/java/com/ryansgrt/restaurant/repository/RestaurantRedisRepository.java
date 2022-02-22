package com.ryansgrt.restaurant.repository;

import com.ryansgrt.restaurant.model.Restaurant;

import java.util.List;

public interface RestaurantRedisRepository {
    Restaurant get(Long id);

    void put(Restaurant restaurant);

    Boolean evict(Long id);

    Boolean hasRestaurant(Long id);

    List<Restaurant> getAll();

    List<Restaurant> getAllDineIn(boolean dineInAvailable);

    void putAll(List<Restaurant> restaurants);

    void putAllDineIn(List<Restaurant> restaurants, boolean dineInAvailable);
}
