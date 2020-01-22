/**
 * Course: SE 2811 - 051
 * Winter 2019
 * Lab 3 - Strategy-based Encryption
 * Names: Milan Kablar
 * Modified: 1/8/2020
 */
package kablarm;

/**
 * Class that stores Encrypter object and Media object
 */
public class CrypStick {

	public Encrypter encrypter;
	public Media media = new Media();

	/**
	 * Mutator method for media
	 * @param media Media object
	 */
	protected void setMedia(Media media) {
		this.media = media;
	}

	/**
	 * Accessor method for media
	 * @return Media object
	 */
	protected Media getMedia(){
		return media;
	}

	/**
	 * Accessor method for message
	 * @return String message
	 */
	public String getMessage(){
		return media.toString();
	}

	/**
	 * Mutator method for message
	 * @param message String message
	 */
	public void setMessage(String message){
		media.set(message);
	}

	/**
	 * Mutator method for encrypter
	 * @param encrypter Encrypter object
	 */
	public void setEncryptionStrategy(Encrypter encrypter){
		this.encrypter = encrypter;
	}

	/**
	 * Accessor method for encrypter
	 * @return Encrypter object
	 */
	public Encrypter getEncrypter() {
		return encrypter;
	}
}