import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class solution {
	
	public static void main(String[] args) {
		String filePath = "Day06/input.txt";
		
		List<Group> groups = new ArrayList<Group>();
		
		readInput(filePath, groups);
		
	}
	
	static void readInput(String filePath, List<Group> groups) {
		List<Person> current = new ArrayList<Person>();
		
		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> {
            	if (!s.isEmpty()) {
            		current.add(new Person(s));
            	} else {
            		groups.add(new Group(current));
            		current.clear();
            	}
            });

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}
	
	static int partOneSolver(List<String> seatIDs) {
		return -1;
	}
	
}
