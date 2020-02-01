// Brian Moon
// Encrypter/Decrypter Application.java
// COP3330


package moon_p1;

import java.util.Scanner;

public class Application 
{
	public static int[] getNumberToEncrypt()
	{
		// prompt user and receive input (number to encrypt)
		// declare variables to store the user input
		final int ARRAY_SIZE = 4;
		String numberAsStringToEncrypt = " ";
		int numberToEncrypt = 0;
		int[] eachDigitOfNumberToEncrypt = new int[ARRAY_SIZE];
		int checkIfUserEnteredNumberLargerThanFourDigits = 0;
		
		// get number from user to encrypt
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a 4-digit number to encrypt: ");
		numberAsStringToEncrypt = in.next();
		
		// getting length of input to make sure it is a 4 digit number
		checkIfUserEnteredNumberLargerThanFourDigits = numberAsStringToEncrypt.length();
		
		// if the input is less than or greater than 4, we want to tell user that the input was not 4 digits and prompt again
		while(checkIfUserEnteredNumberLargerThanFourDigits > 4 || checkIfUserEnteredNumberLargerThanFourDigits < 4)
		{
			System.out.println("Your input was not 4 digits. Please only enter a 4-digit number to encrypt: ");
			numberAsStringToEncrypt = in.next();
			checkIfUserEnteredNumberLargerThanFourDigits = numberAsStringToEncrypt.length();
		}		
		// convert the string input into an integer so we can use modulus and division to break number apart
		numberToEncrypt = Integer.parseInt(numberAsStringToEncrypt);

		// singling out first digit
		eachDigitOfNumberToEncrypt[0] = (numberToEncrypt % 10000) / 1000;
		// singling out second digit
		eachDigitOfNumberToEncrypt[1] = (numberToEncrypt % 1000) / 100;
		// singling out third digit
		eachDigitOfNumberToEncrypt[2] = (numberToEncrypt % 100) / 10;
		// singling out fourth digit
		eachDigitOfNumberToEncrypt[3] = numberToEncrypt % 10;
		
		// checking to make sure user only entered a 4 digit number
		// return each digit of number entered by user
		return eachDigitOfNumberToEncrypt;	
	}
	
	public static int[] getNumberToDecrypt()
	{
		// prompt user and receive input (number to encrypt)
		// declare variables to store the user data
		final int ARRAY_SIZE = 4;
		String numberAsStringToDecrypt = " ";
		int numberToDecrypt = 0;
		int[] eachDigitOfNumberToDecrypt = new int[ARRAY_SIZE];
		int checkIfUserEnteredNumberLargerThanFourDigits = 0;

		// get number from user to decrypt
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a 4-digit number to decrypt: ");
		numberAsStringToDecrypt = in.next();
		
		// getting length of input to make sure it is a 4 digit number
		checkIfUserEnteredNumberLargerThanFourDigits = numberAsStringToDecrypt.length();

		// if the input is less than or greater than 4, we want to tell user that the input was not 4 digits and prompt again
		while(checkIfUserEnteredNumberLargerThanFourDigits > 4 || checkIfUserEnteredNumberLargerThanFourDigits < 4)
		{
			System.out.println("Your input was not 4 digits. Please only enter a 4-digit number to decrypt: ");
			numberAsStringToDecrypt = in.next();
			checkIfUserEnteredNumberLargerThanFourDigits = numberAsStringToDecrypt.length();
		}		
		// convert the string input into an integer so we can use modulus and division to break number apart
		numberToDecrypt = Integer.parseInt(numberAsStringToDecrypt);

		// singling out first digit
		eachDigitOfNumberToDecrypt[0] = (numberToDecrypt % 10000) / 1000;
		// singling out second digit
		eachDigitOfNumberToDecrypt[1] = (numberToDecrypt % 1000) / 100;
		// singling out third digit
		eachDigitOfNumberToDecrypt[2] = (numberToDecrypt % 100) / 10;
		// singling out fourth digit
		eachDigitOfNumberToDecrypt[3] = numberToDecrypt % 10;

		// close scanner
		in.close();
		
		// return each digit of number entered
		return eachDigitOfNumberToDecrypt;	
	}
	
	public static void printEncryptedNumber(int[] encryptedNum)
	{
		// print out encrypted number for user to see
		int[] encryptedNumber = encryptedNum;
		System.out.printf("Your number encrypted is: %d%d%d%d\n\n", encryptedNumber[0], encryptedNumber[1], encryptedNumber[2], encryptedNumber[3]);
	}
	
	public static void printDecryptedNumber(int[] decryptedNum)
	{
		// print out decrypted number for user to see
		int[] decryptedNumber = decryptedNum;
		System.out.printf("Your number decrypted is: %d%d%d%d\n\n", decryptedNumber[0], decryptedNumber[1], decryptedNumber[2], decryptedNumber[3]);
	}		
	
	public static void main(String[] args) 
	{
		
		// application encrypts and decrypts numbers
		// data is four-digit integers 
		// Replace each digit with the result of:
			// adding 7 to the digit and getting the remainder after dividing the new value by 10
			// then swap the first digit with the third, and swap the second with the fourth
			// then print encrypted integer
			// decrypt by doing the reverse steps
		
		// store number to encrypt in an array so it is easy to work with in encrypter
		int[] numberToEncrypt = getNumberToEncrypt();
		int[] encryptedNumber = Encrypter.encrypt(numberToEncrypt);
		// print encrypted number
		printEncryptedNumber(encryptedNumber);
		// store number to decrypt in an array so it is easy to work with in decrypter
		int[] numberToDecrypt = getNumberToDecrypt();
		int[] decryptedNumber = Decrypter.decrypt(numberToDecrypt);
		// print decrypted number
		printDecryptedNumber(decryptedNumber);

	}

}
