package com.ryansgrt.restaurant.kafka.producer;

import com.ryansgrt.restaurant.kafka.utils.KafkaUtils;
import com.ryansgrt.restaurant.model.Restaurant;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class RestaurantProducer {
    private static final String TOPIC = KafkaUtils.TOPICS.RESTAURANT_CREATE_TOPIC;

    private static final Logger log = LoggerFactory.getLogger(RestaurantProducer.class);

    @Autowired
    private KafkaTemplate<String, Restaurant> kafkaTemplate;

    public void produce(Restaurant restaurant) {
        log.info("Producing " + restaurant);
        ListenableFuture<SendResult<String, Restaurant>> future = kafkaTemplate.send(TOPIC, restaurant);
        future.addCallback(new KafkaSendCallback<String, Restaurant>() {

            @Override
            public void onSuccess(SendResult<String, Restaurant> result) {
                log.info("Successfully produced " + result.getRecordMetadata());
            }

            @Override
            public void onFailure(KafkaProducerException e) {
                ProducerRecord<String, Restaurant> failedProducerRecord = e.getFailedProducerRecord();
                log.error("Failed to produce " + failedProducerRecord.value());
            }
        });
    }
}
