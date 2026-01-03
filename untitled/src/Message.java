public class Message {
    private final String content;
    private final int senderId;

    public Message(String content, int senderId) {
        this.content = content;
        this.senderId = senderId;
    }

    public String getContent() { return content; }
    public int getSenderId() { return senderId; }

    @Override
    public String toString() {
        return "Message de Node " + senderId + ": " + content;
    }
}