import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class solution {
	
	public static void main(String[] args) {
		String filePath = "Day04/input.txt";
		
		List<Map<String, Object>> passports = new ArrayList<Map<String, Object>>();
		
		readInput(filePath, passports);
	}
	
	static void readInput(String filePath, List<Map<String, Object>> passports) {
		// Change to scanner?
		try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> {
            	if(s.isEmpty()) {
            		// To-do: Save all recorded entries so far and save them into a passport
            	};
            });
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}
	
}
