import java.util.Scanner;

public class Password {
  public static void main(String args[]) {
    Scanner standartInput = new Scanner(System.in);
    String mode;

    System.out.println("Willkommen! Erstellen Sie ein zufällig generiertes Passwort!");
    System.out.println("Bitte wählen Sie zunächst einen Modus: Normal(1), Secure(2) oder Custom(3)");

    switch(standartInput.nextInt()) {
      case 1:
        System.out.println("Sie haben 'Normal' ausgewählt.");
        mode = "Normal";
        break;
      case 2:
        System.out.println("Sie haben 'Secure' ausgewählt.");
        mode = "Secure";
        break;
      case 3:
        System.out.println("Sie haben 'Custom' ausgewählt.");
        mode = "Custom";
        break;
      default: 
        System.out.println("ERROR: Ein unerwarteter Fehler ist passiert! Bitte versuchen Sie es erneut.");
        return;
    }

    System.out.println("Bitte wählen Sie die Länge ihres Passwortes!");
    int passwordLength = 0;

    if(mode == "Normal") {
      while (passwordLength == 0 || passwordLength > 256) {
        System.out.println("Please enter the length of your password (not greater than 256):");
        passwordLength = standartInput.nextInt();
      }
    } else if (mode == "Secure") {
        while (passwordLength < 12 || passwordLength > 256) {
          System.out.println("Please enter the length of your password (between 12 and 256):");
          passwordLength = standartInput.nextInt();
        }
      } else {
          while (passwordLength == 0 || passwordLength > 256) {
            System.out.println("Please enter the length of your password (not greater than 256):");
            passwordLength = standartInput.nextInt();
          }
        } 

    
    

    String [] symbolArray = {"0", "1" , "2" , "3" , "4" , "5", "6" , "7" , "8", "9", "a",  "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
     "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "!", "$", "%", "&", "#", "?", "-", "_", "*", ",", ";", "+", ".", "=", "~", 
     "^", "(", ")", "{", "}", "[", "]", "|", ":", "/"};

    int randomNumber; // 47
    String [] passwordArray = new String [passwordLength]; 


    // logic while
    int countSpecial;
    int countNumber;
    if (mode == "Secure") {
      do {
        countSpecial = 0;
        countNumber = 0;
        // create new password
        for (int i = 0; i < passwordLength; i++) {
          randomNumber = (int) (Math.random() * (symbolArray.length)); 
          passwordArray[i] = symbolArray[randomNumber];
        }
        // count if circumstances match with mode "Secure"
        for (int i = 0; i < passwordLength; i++) {
          // vielleicht durch weitere for-Schleife ersetzen:
          if (passwordArray[i] == "!" || passwordArray[i] == "$" || passwordArray[i] == "%" || passwordArray[i] == "&" || passwordArray[i] == "#" || passwordArray[i] == "?" || passwordArray[i] == "/" ||
            passwordArray[i] == "-" || passwordArray[i] == "_" || passwordArray[i] == "*" || passwordArray[i] == "," || passwordArray[i] == ";" || passwordArray[i] == "+" ||
            passwordArray[i] == "." || passwordArray[i] == "=" || passwordArray[i] == "~" || passwordArray[i] == "^" || passwordArray[i] == "(" || passwordArray[i] == ")" ||
            passwordArray[i] == "{" || passwordArray[i] == "}" || passwordArray[i] == "[" || passwordArray[i] == "]" || passwordArray[i] == "|" || passwordArray[i] == ":") {
              countSpecial++;
          } 
          if (passwordArray[i] == "0" || passwordArray[i] == "1" || passwordArray[i] == "2" || passwordArray[i] == "3" || passwordArray[i] == "4" || passwordArray[i] == "5" ||
            passwordArray[i] == "6" || passwordArray[i] == "7" || passwordArray[i] == "8" || passwordArray[i] == "9") {
              countNumber++;
          }
        }
      } while (countSpecial < passwordLength / 3 || countNumber < passwordLength / 4);
    } else {
        for (int i = 0; i < passwordLength; i++) {
          randomNumber = (int) (Math.random() * (symbolArray.length)); 
          passwordArray[i] = symbolArray[randomNumber];
        }
      }
    System.out.println("New generated password:");
    System.out.println();

    for (int i = 0; i < passwordArray.length; i++) {
      System.out.print(passwordArray[i]);
    }
    System.out.println();
    System.out.println();
  }
}