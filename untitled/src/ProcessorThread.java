import java.util.concurrent.BlockingQueue;
public class ProcessorThread extends Thread {
    private final BlockingQueue<Message> queue;

    public ProcessorThread(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                Message msg = queue.take(); 
                System.out.println("[TRAITEMENT] " + msg);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}