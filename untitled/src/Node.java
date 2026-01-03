import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Node {
    private int id;
    private String ip;
    private int port;
    private BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

    public Node(int id, String ip, int port) {
        this.id = id;
        this.ip = ip;
        this.port = port;
    }
    
    public int getId() { return id; }
    public String getIp() { return ip; }
    public int getPort() { return port; }
    public void startNode() {
        new ReceiverThread(this.port, queue).start();
        new ProcessorThread(queue).start();
        System.out.println("Node " + id + " démarré et prêt.");
    }
}
