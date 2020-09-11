package com.example.micro1;

import com.amazonaws.services.sns.AmazonSNS;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@RestController
public class MessagesController {
    @Autowired
    private AmazonSNS amazonSNS;

    @PostMapping(value="test1")
    public void processTopicMessage(@RequestHeader("x-amz-sns-message-type") String header,
                                    @RequestBody String textMessage) throws IOException {

        System.out.println("Micro1 - Received    " + header);
        System.out.println("Micro1 - Plain text = " + textMessage);

        InputStream bytes = new ByteArrayInputStream(textMessage.getBytes());
        Map<String, String> messageMap = new ObjectMapper().readValue(bytes, Map.class);
        System.out.println("Micro1 - Message = " + messageMap.get("Message"));
    }

}
