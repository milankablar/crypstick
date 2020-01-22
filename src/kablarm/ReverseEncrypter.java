/**
 * Course: SE 2811 - 051
 * Winter 2019
 * Lab 3 - Strategy-based Encryption
 * Names: Milan Kablar
 * Modified: 1/8/2020
 */
package kablarm;

/**
 * ReverseEncrypter strategy class that implements Encrypter interface
 */
public class ReverseEncrypter implements Encrypter {

	/**
	 * Method that decrypts byte array by reversing it.
	 * @param reversed input encrypted byte array
	 * @return output original byte array
	 */
	public byte[] decrypt(byte[] reversed){
		byte[] original = new byte[reversed.length];
		int j = reversed.length - 1;
		for(int i = 0; i < reversed.length; i++) {
			original[j-i] = reversed[i];
		}
		return original;
	}

	/**
	 * Method that encrypts byte array by reversing it.
	 * @param original input original byte array
	 * @return output encrypted byte array
	 */
	public byte[] encrypt(byte[] original){
		byte[] reversed = new byte[original.length];
		int j = original.length - 1;
		for(int i = 0; i < original.length; i++) {
			reversed[j-i] = original[i];
		}
		return reversed;
	}
}