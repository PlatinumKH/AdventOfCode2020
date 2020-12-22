import java.awt.Color;
import java.util.Map;

public class Passport extends Converter{

	int birthYear;
	int issueYear;
	int expirationYear;
	String height;
	Color hairColor;
	Color eyeColor;
	String passportID;
	int countryID;
	
	Passport(Map<String, Object> values){
		
		for (Map.Entry<String, Object> entry : values.entrySet()) {
			
			String key = entry.getKey();
			Object value = entry.getValue();
			
			assignObject(key, value);
			
		}
	}

	private void assignObject(String key, Object value) {
        switch(key) 
        {
            case "byr":
            	birthYear = (int) convertAcronym(key);
                break; 
            case "iyr":
            	issueYear = (int) convertAcronym(key);
                break; 
            case "eyr": 
            	expirationYear = (int) convertAcronym(key);
                break; 
            case "hgt": 
            	height = (String) convertAcronym(key);
                break; 
            case "hcl": 
            	hairColor = (Color) convertAcronym(key); 
                break; 
            case "ecl": 
            	eyeColor = (Color) convertAcronym(key); 
                break; 
            case "pid":
            	passportID = (String) convertAcronym(key);
            	break;
            case "cid":
            	countryID = (int) convertAcronym(key);
            	break;
            default: 
        } 
	}
	
	private boolean isValidPassport() {
		return birthYear != 0
			&& issueYear != 0
			&& expirationYear != 0
			&& !height.isEmpty()
			&& !hairColor.equals(0)
			&& !eyeColor.equals(0)
			&& !passportID.isEmpty();
	}
	
}
