package mode_non_connect.Image;

public class MainSender {
    public static void main(String[] args) {
        String host = "localhost"; // Adresse du destinataire
        int port = 12345; // Port du destinataire
        String imagePath = "./ai.jpg"; // Chemin de l'image à envoyer

        ImageSender.sendImage(host, port, imagePath);
        
    }
}
