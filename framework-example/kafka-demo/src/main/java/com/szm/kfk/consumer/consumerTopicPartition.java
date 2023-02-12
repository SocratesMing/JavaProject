package com.szm.kfk.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

public class consumerTopicPartition {
    public static void main(String[] args) {
        Properties properties = new Properties();

        // 配置信息，booststrap、key、value
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.6:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "0");

        // 创建消费之
        KafkaConsumer consumer = new KafkaConsumer<String, String>(properties);

        // 订阅主题
        ArrayList<TopicPartition> topics = new ArrayList<>();
        topics.add(new TopicPartition("second",0));
        consumer.assign(topics);

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
