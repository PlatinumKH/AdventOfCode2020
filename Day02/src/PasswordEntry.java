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
    return (countChar(this.password, this.letter) >= this.min)
        && (countChar(this.password, this.letter) <= this.max);
  }

  public int countChar(String str, char c) {
    int count = 0;

    for(int i=0; i < str.length(); i++)
    {    if(str.charAt(i) == c)
            count++;
    }

    return count;
  }

}
