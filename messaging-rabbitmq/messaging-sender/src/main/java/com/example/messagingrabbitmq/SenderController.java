package com.example.messagingrabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/send")
public class SenderController {

    private final RabbitTemplate rabbitTemplate;

    public SenderController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public void sendPostMessage(@RequestBody String message) {
        rabbitTemplate.convertAndSend(MessagingRabbitmqApplication.topicExchangeName, "foo.bar.baz", message);
        System.out.println("Message send: " + message);
    }
}
