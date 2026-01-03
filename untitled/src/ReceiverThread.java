import java.io.*;
import java.net.*;
import java.util.concurrent.BlockingQueue;

public class ReceiverThread extends Thread {
    private final int port;
    private final BlockingQueue<Message> queue;

    public ReceiverThread(int port, BlockingQueue<Message> queue) {
        this.port = port;
        this.queue = queue;
    }

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) { 
                Socket socket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = in.readLine();
                if (line != null) {
                    queue.put(new Message(line, 0)); 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}