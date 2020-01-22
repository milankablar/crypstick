/**
 * Course: SE 2811 - 051
 * Winter 2019
 * Lab 3 - Strategy-based Encryption
 * Names: Milan Kablar
 * Modified: 1/8/2020
 */
package kablarm;

/**
 * XOREncrypter strategy class that implements Encrypter interface
 */
public class XOREncrypter implements Encrypter {

	private byte[] key;

	/**
	 * Constructor for XOREncrypter class
	 * @param key byte[] array
	 */
	public XOREncrypter(byte[] key){
		this.key = key;
	}

	/**
	 * Method that decrypts byte array by XORing it.
	 * @param XORed input encrypted byte array
	 * @return output original byte array
	 */
	public byte[] decrypt(byte[] XORed){
		byte[] original = new byte[XORed.length];
		for(int i = 0; i < XORed.length; i++){
			original[i] = (byte) (XORed[i]^key[i%key.length]);
		}
		return original;
	}

	/**
	 * Method that encrypts byte array by XORing it.
	 * @param original input original byte array
	 * @return output encrypted byte array
	 */
	public byte[] encrypt(byte[] original){
		byte[] XORed = new byte[original.length];
		for(int i = 0; i < original.length; i++){
			XORed[i] = (byte) (original[i]^key[i%key.length]);
		}
		return XORed;
	}

}