package org.thehoffmanns.letschat.server;

import javax.servlet.annotation.WebServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

/**
 *
 * @author Zack Hoffmann
 */
@WebServlet(name = "Chat Servlet", urlPatterns = "chat")
public class ChatSocketServlet extends WebSocketServlet {

    @Override
    public void configure(WebSocketServletFactory wssf) {
        wssf.register(ChatSocket.class);
    }
    
}