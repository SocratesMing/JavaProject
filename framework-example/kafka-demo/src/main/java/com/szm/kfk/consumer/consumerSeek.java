package com.szm.kfk.consumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class consumerSeek {
    public static void main(String[] args) {
        Properties properties = new Properties();

        // 配置信息，booststrap、key、value
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.6:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "demo3");

        // 设置分区分配策略
        properties.put(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY_CONFIG, RoundRobinAssignor.class.getName());
        // properties.put(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY_CONFIG, StickyAssignor.class.getName());

        // 创建消费之
        KafkaConsumer consumer = new KafkaConsumer<String, String>(properties);

        // 订阅主题
        ArrayList<String> topics = new ArrayList<>();
        topics.add("second");
        consumer.subscribe(topics);

        // 等待和集中交互
        Set<TopicPartition> set = new HashSet<>();
        while (set.size() == 0) {
            consumer.poll(Duration.ofSeconds(1));
            set = consumer.assignment();
        }

        // 指定偏移量
        for (TopicPartition partition : set) {
            consumer.seek(partition, 0);
        }

        // 开始消费
        while (true) {
            ConsumerRecords<String, String> poll = consumer.poll(Duration.ofSeconds(1));
            for (ConsumerRecord<String, String> record : poll) {
                System.out.println(record);
                System.out.println(record.value());

            }
        }

    }
}
