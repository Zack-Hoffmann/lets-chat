package org.thehoffmanns.letschat.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 *
 * @author Zack Hoffmann
 */
public class Launcher {

    public static void main(String... args) {
        Server serv = new Server(1234);

        ServletContextHandler ctx = new ServletContextHandler(ServletContextHandler.SESSIONS);
        ctx.setContextPath("/");
        ctx.addServlet(new ServletHolder(new ChatSocketServlet()), "/*");

        serv.setHandler(ctx);

        try {
            serv.start();
            serv.join();
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
}
