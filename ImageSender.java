package mode_non_connect.Image;

import java.io.*;
import java.net.*;

public class ImageSender {
    public static void main(String[] args) {
        String host = "localhost"; // Adresse du destinataire
        int port = 12345; // Port du destinataire
        String imagePath = "./ai.jpg"; // Chemin de l'image à envoyer

        sendImage(host, port, imagePath);
    }

    public static void sendImage(String host, int port, String imagePath) {
        try {
            // Lecture de l'image depuis le fichier
            File file = new File(imagePath);
            FileInputStream fis = new FileInputStream(file);
            byte[] imageData = new byte[(int) file.length()];
            System.out.println(imageData.length);
            fis.read(imageData);
            fis.close();

           // Création du paquet contenant l'image
            DatagramSocket socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName(host);
            DatagramPacket packet = new DatagramPacket(imageData, imageData.length, address, port);

            // Envoi du paquet
            socket.send(packet);
            System.out.println("Image envoyée avec succès.");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
