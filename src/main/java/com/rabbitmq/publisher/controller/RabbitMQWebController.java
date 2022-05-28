package com.rabbitmq.publisher.controller;

import com.rabbitmq.publisher.model.Employee;
import com.rabbitmq.publisher.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/publisher/")
public class RabbitMQWebController {

  @Autowired
  RabbitMQSender rabbitMQSender;

  @GetMapping(value = "/publish")
  public String publish(
    @RequestParam("empName") String empName,
    @RequestParam("empId") String empId
  ) {
    Employee emp = new Employee();
    emp.setEmpId(empId);
    emp.setEmpName(empName);

    rabbitMQSender.send(emp);

    return "Successful publish";
  }
}
