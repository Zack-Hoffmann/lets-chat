package org.thehoffmanns.letschat.server;

public class ChatMediator {
    
    private static final ChatMediator i = new ChatMediator();
    
    public static ChatMediator instance() {
        return i;
    }
    
    private ChatMediator() {
        
    }
    
    // TODO register UUID
}
