package com.szm.kfk.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class msg {

    @Autowired
    KafkaTemplate<String, String> kafka;

    @GetMapping("/kafka")
    public String get(String msg) {
        log.info("接收到消息{}", msg);
        kafka.send("second", msg);
        return "OK";
    }

    @KafkaListener(topics = "second")
    public void receive(String msg) {
        log.info("receive->{}",msg);

    }
}
