import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class solution {
	
	public static void main(String[] args) {
		String filePath = "Day05/input.txt";
		
		List<String> seatIDs = new ArrayList<String>();
		
		readInput(filePath, seatIDs);
		
		System.out.println(partOneSolver(seatIDs));
		
	}
	
	static void readInput(String filePath,List<String> seatIDs) {
		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> seatIDs.add(s));

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}
	
	static int partOneSolver(List<String> seatIDs) {
		
		int maxSeatNum = 0;
		
		for (String id : seatIDs) {
			int min = 0;
			int max = 127;
			
			char[] seatArray = id.toCharArray();
			
			int i = 0;
			
			for (; i < 7; i++) {
				if (seatArray[i] == 'F') {
					max = (min + max)/2;
				} else if (seatArray[i] == 'B') {
					min = (min + max)/2 + 1;
				}
			}
			
			int row = min;
			
			min = 0;
			max = 7;
			
			for (; i < 10; i++) {
				if (seatArray[i] == 'L') {
					max = (min + max)/2;
				} else if (seatArray[i] == 'R') {
					min = (min + max)/2 + 1;
				}
			}
			
			int col = min;
			
			maxSeatNum = Math.max(maxSeatNum, row * 8 + col);
		}
		
		return maxSeatNum;
	}
	
}
