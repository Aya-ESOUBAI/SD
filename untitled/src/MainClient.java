public class MainClient {
    public static void main(String[] args) {
        Node nodeA = new Node(1, "localhost", 5000);
        NetworkClient client = new NetworkClient();
        client.sendTo(nodeA, "Hello from node B");
    }
}
