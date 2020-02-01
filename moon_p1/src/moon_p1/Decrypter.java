// Brian Moon
// Encrypter/Decrypter Decrypter.java
// COP3330


package moon_p1;


public class Decrypter {

	public static int[] decrypt(int[] numToDecrypt)
	{
		// declare variables to store number to decrypt and swap variables
		int[] eachDigitOfNumberToDecrypt = numToDecrypt;
		int tempForSwap = 0;
		int[] decryptedNumber = {0, 0, 0, 0};
		int i = 0;
		
		// perform decryption on entered number
		// swap second digit with the fourth
		tempForSwap = eachDigitOfNumberToDecrypt[1];
		eachDigitOfNumberToDecrypt[1] = eachDigitOfNumberToDecrypt[3];
		eachDigitOfNumberToDecrypt[3] = tempForSwap;
		// swap first digit with the third
		tempForSwap = eachDigitOfNumberToDecrypt[0];
		eachDigitOfNumberToDecrypt[0] = eachDigitOfNumberToDecrypt[2];
		eachDigitOfNumberToDecrypt[2] = tempForSwap;

		
		// add 7 and divide result by 10
		eachDigitOfNumberToDecrypt[0] = ((eachDigitOfNumberToDecrypt[0] + 10) - 7) % 10; 
		eachDigitOfNumberToDecrypt[1] = ((eachDigitOfNumberToDecrypt[1] + 10) - 7) % 10; 
		eachDigitOfNumberToDecrypt[2] = ((eachDigitOfNumberToDecrypt[2] + 10) - 7) % 10; 
		eachDigitOfNumberToDecrypt[3] = ((eachDigitOfNumberToDecrypt[3] + 10) - 7) % 10;
		
		// loop through array and store the decrypted number in its own array so code is more readable
		for(i = 0; i < 4; i++)
		{
			decryptedNumber[i] = eachDigitOfNumberToDecrypt[i];
		}
		// return decrypted number array
		return decryptedNumber;
		
	}
	
}
