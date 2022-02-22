package com.ryansgrt.restaurant.kafka.service;

import com.ryansgrt.restaurant.model.Restaurant;
import com.ryansgrt.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantConsumerServiceImpl implements RestaurantKafkaService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public void handleAddNewRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }
}
