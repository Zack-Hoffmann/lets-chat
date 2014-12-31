package org.thehoffmanns.letschat.server;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

/**
 *
 * @author Greyhound
 */
@WebSocket
public class ChatSocket {
    
    @OnWebSocketMessage
    public void onMessage(Session ses, String msg) {
        Logger.getLogger(ChatSocket.class.getName()).log(Level.INFO, msg);
        try {
            ses.getRemote().sendString(msg);
        } catch (IOException ex) {
            Logger.getLogger(ChatSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
