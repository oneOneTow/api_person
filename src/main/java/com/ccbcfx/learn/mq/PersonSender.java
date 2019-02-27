package com.ccbcfx.learn.mq;

import com.ccbcfx.learn.constant.StaffConstant;
import com.ccbcfx.learn.message.PersonMessage;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonSender {
    @Autowired
    private RabbitTemplate template;

    public void send(PersonMessage message){
        template.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println(message.toString()+replyCode+replyText+exchange+routingKey);
            }
        });
        template.setConfirmCallback((CorrelationData correlationData, boolean ack, String cause)->{
            if(ack){
                System.out.println("消息发送成功");
            }
            System.out.println("消息发送失败"+correlationData.toString()+cause);
        });
        this.template.convertAndSend(StaffConstant.QUEUE_NAME,message);
    }
}
