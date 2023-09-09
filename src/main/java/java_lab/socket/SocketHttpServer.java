package java_lab.socket;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SocketHttpServer {
    private Integer port = 9000;
    private HttpServer server = null;
    public SocketHttpServer() throws IOException {
        System.out.println("SocketHttpServer Start! port : 9000");
        server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/test", new SocketHttpServerHandler());
        server.setExecutor(null);
        server.start();
    }

    public static void main(String[] args) throws IOException {
        SocketHttpServer socketHttpServer = new SocketHttpServer();
    }
}
