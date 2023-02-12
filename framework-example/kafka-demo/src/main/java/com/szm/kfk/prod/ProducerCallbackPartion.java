package com.szm.kfk.prod;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.sql.Time;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ProducerCallbackPartion {
    public static void main(String[] args) throws InterruptedException {
        Properties properties = new Properties();

        // 配置信息，booststrap、key、value
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.6:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        for (int i = 0; i < 100; i++) {
            // producer.send(new ProducerRecord<String, String>("first", 1,"","from java"),(recordMetadata, e) -> {
            producer.send(new ProducerRecord<String, String>("second",i%2,"", "hello"),(recordMetadata, e) -> {
                if (e == null) {
                    System.out.println("主题"+recordMetadata.topic()+" partion->"+recordMetadata.partition());
                }
            });

        }
        // TimeUnit.MILLISECONDS.sleep(100);
        Thread.sleep(100);

        producer.close();
    }
}
