package day02;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class solution {

  public static void main(String[] args) {
    String filePath = "../input.txt";
    PasswordEntry[] entries = new PasswordEntry[1000];

    readInput(filePath, entries);

    System.out.println(partOne(entries));
    System.out.println(partTwo(entries));

  }

  public static int partOne(PasswordEntry[] entries) {
    int count = 0;

    for (int i = 0; i < 1000; i++){
      if (entries[i].isValid()) count++;
    }

    return count;
  }
  
  public static int partTwo(PasswordEntry[] entries) {
	    int count = 0;

	    for (int i = 0; i < 1000; i++){
	      if (entries[i].isValidPartTwo()) count++;
	    }

	    return count;
  }

    private static String readInput(String filePath, PasswordEntry[] entries) {
        StringBuilder contentBuilder = new StringBuilder();
        AtomicInteger counter = new AtomicInteger(0);

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> entries[counter.getAndIncrement()] = new PasswordEntry(s));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

}
