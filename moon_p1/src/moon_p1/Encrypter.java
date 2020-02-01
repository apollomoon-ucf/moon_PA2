// Brian Moon
// Encrypter/Decrypter Encrypter.java
// COP3330



package moon_p1;


public class Encrypter {

	
	//public static Object encrypt;

	public static int[] encrypt(int[] numToEncrypt)
	{
		// declare variables to store number to encrypt and swap variables
		int[] eachDigitOfNumberToEncrypt = numToEncrypt;
		int tempForSwap = 0;
		int[] encryptedNumber = {0, 0, 0, 0};
		int i = 0;
		
		// perform encryption on entered number
		// add 7 and divide result by 10
		eachDigitOfNumberToEncrypt[0] = (eachDigitOfNumberToEncrypt[0] + 7) % 10; 
		eachDigitOfNumberToEncrypt[1] = (eachDigitOfNumberToEncrypt[1] + 7) % 10; 
		eachDigitOfNumberToEncrypt[2] = (eachDigitOfNumberToEncrypt[2] + 7) % 10; 
		eachDigitOfNumberToEncrypt[3] = (eachDigitOfNumberToEncrypt[3] + 7) % 10; 
		// swap first digit with the third
		tempForSwap = eachDigitOfNumberToEncrypt[0];
		eachDigitOfNumberToEncrypt[0] = eachDigitOfNumberToEncrypt[2];
		eachDigitOfNumberToEncrypt[2] = tempForSwap;
		// swap second digit with the fourth
		tempForSwap = eachDigitOfNumberToEncrypt[1];
		eachDigitOfNumberToEncrypt[1] = eachDigitOfNumberToEncrypt[3];
		eachDigitOfNumberToEncrypt[3] = tempForSwap;
		
		// loop through array and store the encrypted number in its own array so code is more readable
		for(i = 0; i < 4; i++)
		{
			encryptedNumber[i] = eachDigitOfNumberToEncrypt[i];
		}
		// return encrypted number array
		return encryptedNumber;
		
	}

}
