package com.ryansgrt.restaurant.kafka.service;

import com.ryansgrt.restaurant.model.Restaurant;

public interface RestaurantKafkaService {
    void handleAddNewRestaurant(Restaurant restaurant);
}
