package com.willow.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitSend {
    @Autowired
    RabbitAdmin rabbitAdmin;

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        rabbitAdmin.getRabbitTemplate().setConfirmCallback(new MsgSendConfirmCallBack());
        rabbitAdmin.getRabbitTemplate().setReturnCallback(new MsgSendReturnCallback());
        return rabbitAdmin;
    }

        /**
         * 方式一：动态声明exchange和queue它们的绑定关系  rabbitAdmin
         *
         * @param exchangeName
         * @param queueName
         */
    protected void declareBinding(String exchangeName, String queueName) {
        if (rabbitAdmin.getQueueProperties(queueName) == null) {
            /*  queue 队列声明
            durable=true,交换机持久化,rabbitmq服务重启交换机依然存在,保证不丢失; durable=false,相反
            auto-delete=true:无消费者时，队列自动删除; auto-delete=false：无消费者时，队列不会自动删除
            排他性，exclusive=true:首次申明的connection连接下可见; exclusive=false：所有connection连接下*/
            Queue queue = new Queue(queueName, true, false, false, null);
            rabbitAdmin.declareQueue(queue);
            TopicExchange directExchange = new TopicExchange(exchangeName);
            rabbitAdmin.declareExchange(directExchange);//声明exchange
            Binding binding = BindingBuilder.bind(queue).to(directExchange).with(queueName);    //将queue绑定到exchange
            rabbitAdmin.declareBinding(binding);      //声明绑定关系
        } else {
            rabbitAdmin.getRabbitTemplate().setQueue(queueName);
            rabbitAdmin.getRabbitTemplate().setExchange(queueName);
            rabbitAdmin.getRabbitTemplate().setRoutingKey(queueName);
        }
    }

    /**
     * 发送消息
     *
     * @param queueName
     * @param message
     * @throws Exception
     */
    public void sendMessage(String queueName, String message) throws Exception {
        declareBinding(queueName, queueName);
        rabbitAdmin.getRabbitTemplate().convertAndSend(queueName, queueName, message);


    }
}
