/**
 * Course: SE 2811 - 051
 * Winter 2019
 * Lab 3 - Strategy-based Encryption
 * Names: Milan Kablar
 * Modified: 1/8/2020
 */
package kablarm;

import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CrypStick crypStick = new CrypStick();
        Media media = crypStick.getMedia();

        // Prompts the user for encrypt or decrypt operation.
        System.out.println("Encrypt (e) or Decrypt (d): ");
        String crypt = in.next().toLowerCase();
        while (!crypt.equals("e") && !crypt.equals("d")) {
            System.out.println("Encrypt (e) or Decrypt (d): ");
            crypt = in.next();
        }

        // Prompts the user for an encryption method.
        System.out.println("Method (rev, shift, xor): ");
        String method = in.next().toLowerCase();
        while (!method.equals("rev") && !method.equals("shift") && !method.equals("xor")) {
            System.out.println("Method (rev, shift, xor): ");
            method = in.next().toLowerCase();
        }

        // Initializes the Encrypter object as a specialized strategy.
        if (method.equals("rev")) {
            crypStick.setEncryptionStrategy(new ReverseEncrypter());
        }
        if (method.equals("shift")) {
            System.out.println("Amount: ");
            int amount = in.nextInt();
            crypStick.setEncryptionStrategy(new ShiftEncrypter(amount));
        }
        if (method.equals("xor")) {
            System.out.println("Key: ");
            String key = in.next();
            crypStick.setEncryptionStrategy(new XOREncrypter(key.getBytes()));
        }

        // Prompts the user for a message.
        String message = "";
        System.out.println("Message: ");
        in.nextLine();
        try {
            while (true) {
                message = message + in.nextLine() + "\n";
            }
        } catch (NoSuchElementException e) {
        }

        // Calls the encrypt or decrypt method based on user input.
        if (crypt.equals("e")) {
            media.set(crypStick.getEncrypter().encrypt(message.getBytes()));
            System.out.println(media.toStringHex());
        }
        if (crypt.equals("d")) {
            media.set(hexdumpToBytes(message));
            byte[] decrypted = crypStick.getEncrypter().decrypt(media.get());
            System.out.println(new String(decrypted, StandardCharsets.UTF_8));
        }
    }

    public static byte[] hexdumpToBytes(String hexString) {
        String[] hexArray = hexString.trim().split(" ");
        byte[] byteArray = new byte[hexArray.length];

        for(int i = 0; i < hexArray.length; i++) {
            int firstDigit = Character.digit(hexArray[i].charAt(0), 16);
            int secondDigit = Character.digit(hexArray[i].charAt(1), 16);
            byteArray[i] = (byte) ((firstDigit << 4) + secondDigit);
        }
        return byteArray;
    }
}
