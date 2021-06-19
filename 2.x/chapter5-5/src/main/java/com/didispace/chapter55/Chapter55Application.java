package com.didispace.chapter55;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class Chapter55Application {

    private static String CHANNEL = "didispace";

    public static void main(String[] args) {
        SpringApplication.run(Chapter55Application.class, args);
    }

    @RestController
    static class RedisController {

        private RedisTemplate<String, String> redisTemplate;

        public RedisController(RedisTemplate<String, String> redisTemplate) {
            this.redisTemplate = redisTemplate;
        }

        @GetMapping("/publish")
        public void publish(@RequestParam String message) {
            // 发送消息
            redisTemplate.convertAndSend(CHANNEL, message);
        }

    }

    @Slf4j
    @Service
    static class MessageSubscriber {

        public MessageSubscriber(RedisTemplate redisTemplate) {
            RedisConnection redisConnection = redisTemplate.getConnectionFactory().getConnection();
            redisConnection.subscribe(new MessageListener() {
                @Override
                public void onMessage(Message message, byte[] bytes) {
                    // 收到消息的处理逻辑
                    log.info("Receive message : " + message);
                }
            }, CHANNEL.getBytes(StandardCharsets.UTF_8));

        }

    }

}
