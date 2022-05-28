package com.rabbitmq.publisher.service;

import com.rabbitmq.publisher.model.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

  @Autowired
  private AmqpTemplate amqpTemplate;

  @Value("${nygman98.rabbitmq.exchange}")
  private String exchangeName;

  @Value("${nygman98.rabbitmq.routingkey}")
  private String routingkey;

  public void send(Employee emp) {
    amqpTemplate.convertAndSend(exchangeName, routingkey, emp);
  }
}
