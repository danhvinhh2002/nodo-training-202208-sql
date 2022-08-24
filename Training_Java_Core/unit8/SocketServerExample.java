import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerExample {
    public SocketServerExample(int serverPort) throws Exception{
        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("Server listening....");
        while (true){
            Socket socket = serverSocket.accept();
            new Thread(() ->{
               try(InputStream input = new DataInputStream(socket.getInputStream());
                   DataOutputStream output = new DataOutputStream(socket.getOutputStream())
               ) {
                   System.out.println("Client Say: "+ ((DataInputStream) input).readUTF());
                   output.writeUTF("Iam a socket server !");
               } catch (IOException e) {
                   throw new RuntimeException(e);
               }
            }).start();
        }
    }

    public static void main(String[] args) throws Exception {
        new SocketServerExample(9245);
    }
}
