import java.io.PrintWriter;
import java.net.Socket;

public class NetworkClient {

    public void sendTo(Node node, String message) {
        try (
            Socket socket = new Socket(node.getIp(), node.getPort());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            out.println(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


