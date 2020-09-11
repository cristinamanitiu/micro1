package com.example.micro1;

import lombok.Data;

@Data
public class SnsNotification {
    private String Type;
    private String MessageId;
    private String TopicArn;
    private String Subject;
    private String Message;
    private String Timestamp;
    private String signatureVersion;
    private String Signature;
    private String SigningCertURL;
    private String UnsubscribeURL;
}
