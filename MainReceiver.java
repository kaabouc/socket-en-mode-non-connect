package mode_non_connect.Image;

public class MainReceiver {
    public static void main(String[] args) {
        int port = 12345; // Port du récepteur

        ImageReceiver.receiveImage(port);
    }
}
