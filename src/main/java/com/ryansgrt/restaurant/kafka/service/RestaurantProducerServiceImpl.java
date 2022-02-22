package com.ryansgrt.restaurant.kafka.service;

import com.ryansgrt.restaurant.kafka.producer.RestaurantProducer;
import com.ryansgrt.restaurant.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantProducerServiceImpl implements RestaurantKafkaService {
    @Autowired
    private RestaurantProducer restaurantProducer;

    @Override
    public void handleAddNewRestaurant(Restaurant restaurant) {
        restaurantProducer.produce(restaurant);
    }
}

