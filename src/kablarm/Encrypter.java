/**
 * Course: SE 2811 - 051
 * Winter 2019
 * Lab 3 - Strategy-based Encryption
 * Names: Milan Kablar
 * Modified: 1/8/2020
 */
package kablarm;

/**
 * Interface for Encrypter class.
 * Requires classes to implement decrypt and encrypt methods.
 */
public interface Encrypter {

	public byte[] decrypt(byte[] bytes);

	public byte[] encrypt(byte[] bytes);

}