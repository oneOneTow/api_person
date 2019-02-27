package com.ccbcfx.learn.config;


import com.ccbcfx.learn.constant.StaffConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

public class RabbitConfig {
    @Bean
    public Queue getQueue(){
        return new Queue(StaffConstant.QUEUE_NAME,false);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(StaffConstant.EXCHANGE);
    }
    @Bean
    Binding bindingExchangeA(Queue Queue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(Queue).to(fanoutExchange);
    }



}
