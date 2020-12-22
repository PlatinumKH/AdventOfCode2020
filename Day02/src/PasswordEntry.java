package day02;
import java.util.Scanner;

public class PasswordEntry {

  int min;
  int max;
  char letter;
  String password;
  private Scanner scanner;

  PasswordEntry(String entry){

  entry = entry.replace("-", " ");
  entry = entry.replace(":", "");

  scanner = new Scanner(entry);

  min = scanner.nextInt();
  max = scanner.nextInt();
  letter = scanner.next().charAt(0);
  password = scanner.next();

  }

  boolean isValid() {
    return (countChar(password, letter) >= min)
        && (countChar(password, letter) <= max);
  }

  // Part one
  public int countChar(String str, char c) {
    int count = 0;

    for(int i=0; i < str.length(); i++)
    {    if(str.charAt(i) == c)
            count++;
    }

    return count;
  }
  
  // Part two
  boolean isValidPartTwo() {
	  
	  return !((password.charAt(min - 1) == letter) 
		&& password.charAt(max - 1) == letter)
	    && ((password.charAt(min - 1) == letter) 
	    || password.charAt(max - 1) == letter);
  }

}
