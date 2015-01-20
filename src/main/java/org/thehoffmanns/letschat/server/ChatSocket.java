package org.thehoffmanns.letschat.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
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

    private static final Map<Session, UUID> SESSION_TO_ID = new HashMap<>();
    private static final Map<UUID, Session> ID_TO_SESSION = new HashMap<>();

    @OnWebSocketConnect
    public void onConnect(Session ses) {
        if (!SESSION_TO_ID.keySet().contains(ses)) {
            SESSION_TO_ID.put(ses, UUID.randomUUID());
            ID_TO_SESSION.put(SESSION_TO_ID.get(ses), ses);
        }
    }

    @OnWebSocketClose
    public void onClose(Session ses, int code, String reason) {
        ID_TO_SESSION.remove(SESSION_TO_ID.get(ses));
        SESSION_TO_ID.remove(ses);
    }

    @OnWebSocketMessage
    public void onMessage(Session ses, String msg) {
        try {

            Logger.getLogger(ChatSocket.class.getName()).log(Level.FINE, msg);
            // TODO Gson msg into Message object

            ses.getRemote().sendString(msg);

        } catch (IOException ex) {
            Logger.getLogger(ChatSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
