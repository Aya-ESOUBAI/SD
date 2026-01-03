public class Message {
    private String content;
    private int senderId;

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