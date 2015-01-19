package org.thehoffmanns.letschat.server;

import java.util.UUID;

public class Message {

    public static enum MessageType {
        KEEP_ALIVE("KAL"),
        OPEN("OPN"),
        TRANSMIT("TRS"),
        ACKNOWLEDGE("ACK"),
        CLOSE("CLS");
        
        private String code;
        private MessageType(String code) {
            this.code = code;
        }
        
        @Override
        public String toString() {
            return code;
        }
    }

    private MessageType type;
    private UUID sessionId;
    private long sequenceNum;
    private String body;

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public UUID getSessionId() {
        return sessionId;
    }

    public void setSessionId(UUID sessionId) {
        this.sessionId = sessionId;
    }

    public long getSequenceNum() {
        return sequenceNum;
    }

    public void setSequenceNum(long sequenceNum) {
        this.sequenceNum = sequenceNum;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
