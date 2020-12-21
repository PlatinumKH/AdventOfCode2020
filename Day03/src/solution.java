import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class solution {

	public static void main(String[] args) {
		
		String filePath = "input.txt";
		
		char[][] map = new char[323][31];
		
		readInput(filePath, map);
		
		System.out.println(partOne(map));

	}
	
	static int partOne(char[][] map) {
		int column = 0;
		int count = 0;
		
		for (int row = 0; row < 323; row++) {
			if (map[row][column] == '#')
				count++;
			column = (column + 3) % 31;
		}
		
		return count;
	}
	
	private static String readInput(String filePath, char[][] map) {
        StringBuilder contentBuilder = new StringBuilder();
        AtomicInteger counter = new AtomicInteger(0);

        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> populateRow(s, map, counter.getAndIncrement()));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }
	
	static void populateRow(String s, char[][] map, int index){
		for (int i = 0; i < 31; i++) {
			map[index][i] = s.charAt(i);
		}
	}

}
