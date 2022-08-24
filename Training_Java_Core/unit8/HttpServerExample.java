import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpsServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class HttpServerExample {
    private static HttpHandler testHandler;

    public static void main(String[] args) throws IOException {
        HttpsServer server = HttpsServer.create(new InetSocketAddress(8080), 0);
        TestHandler testHandler = new TestHandler();
        server.createContext("/test",testHandler);
        server.setExecutor(Executors.newFixedThreadPool(5));
        server.start();
    }
}
