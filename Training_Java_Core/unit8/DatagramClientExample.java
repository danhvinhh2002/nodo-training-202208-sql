import java.io.IOException;
import java.net.*;

public class DatagramClientExample {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        InetAddress address = InetAddress.getByName("localhost");
        byte[] bytes = "Client say xin chao ".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length,address,4445);
        socket.send(packet);
        packet = new DatagramPacket(bytes, bytes.length);
        socket.receive(packet);

        System.out.println("From Server: "+new String(packet.getData(),0,packet.getLength()));
        socket.close();
    }
}
