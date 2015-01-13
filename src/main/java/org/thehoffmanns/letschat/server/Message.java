package org.thehoffmanns.letschat.server;

public class Message {

    private static final String KEEP_ALIVE = "KAL";
    private static final String OPEN = "OPN";
    private static final String STANDARD = "STD";
    private static final String ACKNOWLEDGE = "ACK";
    private static final String CLOSE = "CLS";

    private String type;
    private String sessionId;
    private long sequenceNum;
    private String body;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
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
