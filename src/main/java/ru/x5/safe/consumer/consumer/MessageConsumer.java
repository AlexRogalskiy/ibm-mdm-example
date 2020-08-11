package ru.x5.safe.consumer.consumer;

import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import java.io.IOException;

@Component
public class MessageConsumer {
    private final FileService fileService;

    public MessageConsumer(FileService fileService) {
        this.fileService = fileService;
    }

    @JmsListener(destination = "${masterdata.queue.name}", containerFactory = "jmsFactory")
    public void receiveMessage(Message message) throws JMSException, IOException {
        System.out.println(message);
        fileService.writeFile(message.getJMSMessageID(), message.getBody(String.class));
    }
}
