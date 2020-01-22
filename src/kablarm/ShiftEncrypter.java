/**
 * Course: SE 2811 - 051
 * Winter 2019
 * Lab 3 - Strategy-based Encryption
 * Names: Milan Kablar
 * Modified: 1/8/2020
 */
package kablarm;

import java.nio.charset.StandardCharsets;

/**
 * ShiftEncrypter strategy class that implements Encrypter interface
 */
public class ShiftEncrypter implements Encrypter {
	private int amount;

	/**
	 * Constructor for ShiftEncrypter class
	 * @param amount shift amount
	 */
	public ShiftEncrypter(int amount) {
		this.amount = amount;
	}

	/**
	 * Method that decrypts byte array by shifting it.
	 * @param shifted input encrypted byte array
	 * @return output original byte array
	 */
	public byte[] decrypt(byte[] shifted){
		byte[] original = new byte[shifted.length];
		String stringShifted = new String(shifted, StandardCharsets.UTF_8);
		for(int i = 0; i < stringShifted.length(); i++) {
			int charValue = stringShifted.charAt(i);
			int newCharValue = charValue - amount;
			if(newCharValue < 0) {
				newCharValue += 256;
			}
			original[i] = (byte) newCharValue;
		}
		return original;
	}

	/**
	 * Method that encrypts byte array by shifting it.
	 * @param original input original byte array
	 * @return output encrypted byte array
	 */
	public byte[] encrypt(byte[] original){
		byte[] shifted = new byte[original.length];
		String stringOriginal = new String(original, StandardCharsets.UTF_8);
		for(int i = 0; i < stringOriginal.length(); i++) {
			int charValue = stringOriginal.charAt(i);
			int newCharValue = charValue + amount;
			if(newCharValue > 255) {
				newCharValue -= 256;
			}
			shifted[i] = (byte) newCharValue;
		}
		return shifted;
	}

}