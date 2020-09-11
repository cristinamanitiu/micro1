package com.example.micro1;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.SubscribeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SnsSubscriber {
    @Autowired
    AmazonSNS amazonSNS;

    private final String SNS_TOPIC_NAME="my-topic";

    @PostConstruct
    public void registerToTopic(){
        CreateTopicResult topic = amazonSNS.createTopic(SNS_TOPIC_NAME);
        SubscribeRequest request = new SubscribeRequest(topic.getTopicArn(),"http","http://micro1:8082/test1");
        amazonSNS.subscribe(request);
    }

    @Scheduled(fixedDelayString = "${scheduler.timer}")
    public void doNothing(){

    }


}
