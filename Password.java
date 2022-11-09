import java.util.Scanner;

public class Password {

	/**
	 * main 
	 */
	public static void main(String args[]) {
		int mode = start(); 

		// call normal()
		if (mode == 1) {
			String[] generatedPassword = normal();
			outputPassword(generatedPassword);
			return;
		} 	
		// call secure()
		else if (mode == 2) {
			String[] unsortedNewPassword = secure();
			String[] generatedPassword = randomize(unsortedNewPassword);
			outputPassword(generatedPassword);
			return;
		}
		// call custom()
		else if (mode == 3) {
			String[] unsortedNewPassword = custom();
			String[] generatedPassword = randomize(unsortedNewPassword);
			outputPassword(generatedPassword);
			return;
		}			
	}

	private static int start() {
		Scanner input = new Scanner(System.in);
		int mode;

		System.out.println("Welcome! Create a new password! :D");
		System.out.println("Please choose a mode: Normal(1), Secure(2) or Custom(3)");

		mode = input.nextInt();
		if (mode != 1 && mode != 2 && mode != 3) {
			System.out.println("Error: No such mode found!");
		}
		
		return mode;
	}

	/**
	 * randomize 
	 * @param unsortedNewPassword from secure() or custom()
	 * @return final generated password
	 */
  	private static String[] randomize(String[] unsortedNewPassword) {
        String[] generatedPassword = new String[unsortedNewPassword.length];
		int random;

		for (int i = 0; i < generatedPassword.length; i++) {
			random = (int) (Math.random() * generatedPassword.length);  
			if (unsortedNewPassword[random] == "invalid") {
				i--;
			} 
			else {
				generatedPassword[i] = unsortedNewPassword[random];
				unsortedNewPassword[random] = "invalid";
			}     
		}
		return generatedPassword;
  	}

	/**
	 * outputPassword 
	 * @param generatedPassword final generated password
	 * @return 
	 */
	private static void outputPassword(String[] generatedPassword) {
		System.out.println("New generated password:");
		for (String chars: generatedPassword) {
			System.out.print(chars);
		}
		System.out.println();
		System.out.println();
		return;
	}

	/**
	 * normal
	 * @return final generated password
	 */
	private static String[] normal() {
		String [] strings = {"0", "1" , "2" , "3" , "4" , "5", "6" , "7" , "8", "9", "a",  "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
		"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "!", "$", "%", "&", "#", "?", "-", "_", "*", ",", ";", "+", ".", "=", "~", 
		"^", "(", ")", "{", "}", "[", "]", "|", ":", "/"};

		// Check if inputs for this mode are valid
		int passwordLength;
		Scanner input = new Scanner(System.in);

		System.out.print("Please enter the length of your new password (0 - 256): ");

		do {
			passwordLength = input.nextInt();
			if (passwordLength < 0 || passwordLength > 256) {
				System.out.print("Please enter a number in the range 0 - 256: ");
			} 
		} while(passwordLength < 0 || passwordLength > 256);

		System.out.println();

		// Generate final password
		int randomNumber; 
		String [] generatedPassword = new String [passwordLength]; 

		for (int i = 0; i < passwordLength; i++) {
			randomNumber = (int) (Math.random() * (strings.length)); 
			generatedPassword[i] = strings[randomNumber];
		}
		return generatedPassword;
	}

	/**
	 * secure
	 * @return unsorted password
	 */
  	private static String[] secure() {
    	String[] symbols = {"!", "$", "%", "&", "#", "?", "-", "_", "*", ",", ";", "+", ".", "=", "~", "^", "(", ")", "{", "}", "[", "]", "|", ":", "/"};
    	String[] numbers = {"0", "1" , "2" , "3" , "4" , "5", "6" , "7" , "8", "9"};
		String[] smallCharacters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		String[] capitalCharacters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		String [] strings = {"0", "1" , "2" , "3" , "4" , "5", "6" , "7" , "8", "9", "a",  "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
		"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "!", "$", "%", "&", "#", "?", "-", "_", "*", ",", ";", "+", ".", "=", "~", 
		"^", "(", ")", "{", "}", "[", "]", "|", ":", "/"};

		Scanner input = new Scanner(System.in);
    	int passwordLength;
		int random;

		// Check if inputs are valid
		System.out.println("Secure-mode:");
		System.out.print("Please enter the length of your new password (8-256): ");

		do {
			passwordLength = input.nextInt();
			if (passwordLength < 8 || passwordLength > 256) {
				System.out.print("Please enter a valid length (8-256): ");
			}
		} while(passwordLength < 8 || passwordLength > 256);

		System.out.println();

		// Generate unsorted password with conditions:
		String[] newPassword = new String[passwordLength];

		for (int i = 0; i < passwordLength / 4; i++) {
			random = (int) (Math.random() * symbols.length);
			newPassword[i] = symbols[random];
		}

		for (int i = passwordLength / 4; i < passwordLength / 4 + passwordLength / 8; i++) {
			random = (int) (Math.random() * numbers.length);
			newPassword[i] = numbers[random];
		}

		for (int i = passwordLength / 4 + passwordLength / 8; i < passwordLength / 4 + passwordLength / 8 + passwordLength / 8; i++) {
			random = (int) (Math.random() * smallCharacters.length);
			newPassword[i] = smallCharacters[random];
		}

		for (int i = passwordLength / 4 + passwordLength / 8 + passwordLength / 8; i < passwordLength / 4 + passwordLength / 8 + passwordLength / 8 + passwordLength / 8; i++) {
			random = (int) (Math.random() * capitalCharacters.length);
			newPassword[i] = capitalCharacters[random];
		}

		for (int i = passwordLength / 4 + passwordLength / 8 + passwordLength / 8 + passwordLength / 8; i < passwordLength; i++) {
			random = (int) (Math.random() * strings.length);
			newPassword[i] = strings[random];
		}

		return newPassword;
	}

	/**
	 * custom
	 * @return unsorted password
	 */
	private static String[] custom() {
		String[] symbols = {"!", "$", "%", "&", "#", "?", "-", "_", "*", ",", ";", "+", ".", "=", "~", "^", "(", ")", "{", "}", "[", "]", "|", ":", "/"};
		String[] numbers = {"0", "1" , "2" , "3" , "4" , "5", "6" , "7" , "8", "9"};
		String[] smallCharacters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		String[] capitalCharacters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		String [] strings = {"0", "1" , "2" , "3" , "4" , "5", "6" , "7" , "8", "9", "a",  "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
		"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "!", "$", "%", "&", "#", "?", "-", "_", "*", ",", ";", "+", ".", "=", "~", 
		"^", "(", ")", "{", "}", "[", "]", "|", ":", "/"};

		Scanner input = new Scanner(System.in);

		int passwordLength;
		int amountSymbols;
		int amountNumbers;
		int amountSmallCharacters;
		int amountCapitalCharacters;
		int random;

		// Check if inputs are valid
		System.out.println("Custom-mode:");
		System.out.print("Please enter the length of your new password (0-256): ");

		do {
			passwordLength = input.nextInt();
			if (passwordLength < 0 || passwordLength > 256) {
				System.out.print("Please enter a number in the range 0 - 256: ");
			} 
		} while(passwordLength < 0 || passwordLength > 256);

		System.out.println();

		System.out.print("Please enter the amount of symbols in your new password: ");

		do {
			amountSymbols = input.nextInt();
			if (amountSymbols > passwordLength) {
				System.out.print("Too many arguments! Enter a different amount of symbols in your new password: ");
			} 
			else if (amountSymbols < 0) {
				System.out.print("Negative numbers are invalid! Enter a different amount of symbols in your new password: ");
			}
		} while(amountSymbols < 0 || amountSymbols > passwordLength);

		System.out.print("Please enter the amount of numbers in your new password: ");

		do {
			amountNumbers = input.nextInt();
			if (amountSymbols + amountNumbers > passwordLength) {
				System.out.print("Too many arguments! Enter a different amount of numbers in your new password: ");
			} 
			else if (amountNumbers < 0) {
				System.out.print("Negative numbers are invalid! Enter a different amount of numbers in your new password: ");
			}
		} while(amountNumbers < 0 || amountSymbols + amountNumbers > passwordLength);

		System.out.print("Please enter the amount of small characters in your new password: ");

		do {
			amountSmallCharacters = input.nextInt();
			if (amountSymbols + amountNumbers + amountSmallCharacters > passwordLength) {
				System.out.print("Too many arguments! Enter a different amount of small characters in your new password: ");
			} 
			else if (amountSmallCharacters < 0) {
				System.out.print("Negative numbers are invalid! Enter a different amount of small characters in your new password: ");
			}
		} while(amountSmallCharacters < 0 || amountSymbols + amountNumbers + amountSmallCharacters > passwordLength);

		System.out.print("Please enter the amount of capital characters in your new password: ");

		do {
			amountCapitalCharacters = input.nextInt();
			if (amountSymbols + amountNumbers + amountSmallCharacters + amountCapitalCharacters > passwordLength) {
				System.out.print("Too many arguments! Enter a different amount of capital characters in your new password: ");
			} 
			else if (amountCapitalCharacters < 0) {
				System.out.print("Negative numbers are invalid! Enter a different amount of capital characters in your new password: ");
			}
		} while(amountCapitalCharacters < 0 || amountSymbols + amountNumbers + amountSmallCharacters + amountCapitalCharacters > passwordLength);


		// Symbols are being randomly chosen 
		String[] newPassword = new String[passwordLength];

		for (int i = 0; i < amountSymbols; i++) {
			random = (int) (Math.random() * symbols.length);
			newPassword[i] = symbols[random];
		}

		// Numbers are being randomly chosen
		for (int i = amountSymbols; i < amountSymbols + amountNumbers; i++) {
		random = (int) (Math.random() * numbers.length);
		newPassword[i] = numbers[random];
		}

		// Small characters are being randomly chosen
		for (int i = amountSymbols + amountNumbers; i < amountSymbols + amountNumbers + amountSmallCharacters; i++) {
			random = (int) (Math.random() * smallCharacters.length);
			newPassword[i] = smallCharacters[random];
		}

		// Capital characters are being randomly chosen
		for (int i = amountSymbols + amountNumbers + amountSmallCharacters; i < amountSymbols + amountNumbers + amountSmallCharacters + amountCapitalCharacters; i++) {
			random = (int) (Math.random() * capitalCharacters.length);
			newPassword[i] = capitalCharacters[random];
		}

		// Everything else is being randomly chosen
		for (int i = amountSymbols + amountNumbers + amountSmallCharacters + amountCapitalCharacters; i < passwordLength; i++) {
			random = (int) (Math.random() * strings.length);
			newPassword[i] = strings[random];
		}

		System.out.println();
		return newPassword;
	}
}