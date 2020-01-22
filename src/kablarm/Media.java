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
 * Class that stores the byte array of encrypted data
 */
public class Media {
	private byte[] bytes;

	/**
	 * Accessor method for byte array
	 * @return byte[] array
	 */
	public byte[] get(){
		return bytes;
	}

	/**
	 * Mutator method for byte array
	 * @param bytes byte[] array
	 */
	public void set(byte[] bytes){
		this.bytes = bytes;
	}

	/**
	 * Mutator method for byte array
	 * @param str String
	 */
	public void set(String str){
		bytes = str.getBytes(StandardCharsets.UTF_8);
	}

	/**
	 * toString method for byte arrray.
	 * @return String representation of byte array
	 */
	public String toString() {
		return (new String(bytes, StandardCharsets.UTF_8));
	}

	/**
	 * toString method for byte array
	 * @return hex representation of byte array
	 */
	public String toStringHex(){
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		for (byte Byte : bytes) {
			sb.append(String.format("%02x", Byte)).append(" ");
		}

		return sb.toString();
	}

}