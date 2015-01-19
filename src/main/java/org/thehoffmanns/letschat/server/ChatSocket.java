package org.thehoffmanns.letschat.server;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

/**
 *
 * @author Zack Hoffmann
 */
@WebSocket
public class ChatSocket {
    
    private Session ses;
    
    @OnWebSocketConnect
    public void onConnect(Session ses) {
        // TODO test session hashcode and map that?
        this.ses = ses;
    }
    
    @OnWebSocketClose
    public void onClose(Session ses, int code, String reason) {
        
    }
    
    @OnWebSocketMessage
    public void onMessage(Session ses, String msg) {
        try {
            
            Logger.getLogger(ChatSocket.class.getName()).log(Level.FINE, msg);
            // TODO Gson msg into Message object
            if (this.ses.equals(ses)) {
                ses.getRemote().sendString(msg);
            } else {
                ses.getRemote().sendString("NOT EQUAL!!!");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ChatSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
