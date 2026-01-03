public class MainServer {
    public static void main(String[] args) {
        NetworkServer server = new NetworkServer(5000);
        server.start();
    }
}
