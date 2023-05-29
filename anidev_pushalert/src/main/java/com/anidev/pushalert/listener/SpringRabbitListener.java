package com.anidev.pushalert.listener;

import com.anidev.pushalert.po.Articles;
import com.anidev.pushalert.service.PushalertService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author suzhengang
 * @create 2023-05-28
 */
@Component
@Slf4j
public class SpringRabbitListener {
    @Autowired
    private PushalertService pushalertService;
    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "push.queue1"),
            exchange=@Exchange(name = "push.exchange",type = ExchangeTypes.TOPIC),
            key="articles.#"))
    public void listenPush(Articles articles) {
        log.info("topic1接收到消息：【" + articles + "】");
        System.out.println("topic1接收到消息：【" + articles + "】");
        pushalertService.push(articles);
    }
}
