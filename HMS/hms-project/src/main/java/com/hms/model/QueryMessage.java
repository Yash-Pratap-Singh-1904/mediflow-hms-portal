
package com.hms.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class QueryMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String id;
    private final String senderId;
    private final String senderRole;
    private final String recipientId;
    private final String description;
    private final LocalDateTime timestamp;
    private String reply;
    private String status; // PENDING, RESOLVED

    public QueryMessage(String id, String senderId, String senderRole, String recipientId, String description) {
        this.id = id;
        this.senderId = senderId;
        this.senderRole = senderRole;
        this.recipientId = recipientId;
        this.description = description;
        this.timestamp = LocalDateTime.now();
        this.status = "PENDING";
    }

    public String getId() { return id; }
    public String getSenderId() { return senderId; }
    public String getSenderRole() { return senderRole; }
    public String getRecipientId() { return recipientId; }
    public String getDescription() { return description; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getReply() { return reply; }
    public void setReply(String reply) { this.reply = reply; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}