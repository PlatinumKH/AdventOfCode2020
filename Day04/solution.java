import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class solution {
	
	public static void main(String[] args) {
		String filePath = "Day04/input.txt";
		
		List<Passport> passports = new ArrayList<Passport>();
		
		readInput(filePath, passports);
		
		System.out.println(partOneSolver(passports));
	}
	
	static void readInput(String filePath, List<Passport> passports) {
		Map<String, Object> values = new HashMap<String, Object>();
		try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> {
            	if(!s.isEmpty()) {
            		String[] words = s.split("\\s+");
            		for (String data : words) {
            			String entry[] = data.split(":"); 
            			values.put(entry[0], entry[1]);
            		}
            		
            	} else {
            		Passport newEntry = new Passport(values);
            		passports.add(newEntry);
            		values.clear();
            	}
            });
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}
	
	static int partOneSolver(List<Passport> passports) {
		int noOfValidPassports = 0;
		
		for (Passport passport : passports) {
			if (passport.isValidPassport()) noOfValidPassports++;
		}
		
		return noOfValidPassports;
		
	}
}
