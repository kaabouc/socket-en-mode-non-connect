package mode_non_connect.Image;

import java.io.*;
import java.net.*;

public class ImageReceiver {
    // public static void main(String[] args) {
    //     int port = 12345; // Port du récepteur

    //     receiveImage(port);
    // }

    public static void receiveImage(int port) {
        try {
            // Création du socket pour recevoir les données
            DatagramSocket socket = new DatagramSocket(port);

            // Création du tampon pour stocker les données reçues
            byte[] buffer = new byte[65507]; // Taille maximale du paquet UDP

            // Réception du paquet contenant l'image
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            // Récupération des données de l'image
            byte[] imageData = packet.getData();
            int imageSize = packet.getLength();

            // Sauvegarde de l'image dans un fichier
            String imagePath = "received_image.jpg"; // Chemin pour enregistrer l'image reçue
            FileOutputStream fos = new FileOutputStream(imagePath);
            fos.write(imageData, 0, imageSize);
            fos.close();

            System.out.println("Image reçue et enregistrée avec succès : " + imagePath);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
