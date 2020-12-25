import java.awt.Color;
import java.util.Map;

public class Passport extends Converter{

	int birthYear = 0;
	int issueYear = 0;
	int expirationYear = 0;
	String height = "";
	String hairColor = "";
	String eyeColor = "";
	String passportID = "";
	int countryID = 0;
	
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
            	birthYear = (int) Integer.parseInt(value.toString());
                break; 
            case "iyr":
            	issueYear = (int) convertAcronym(key);
            	issueYear = (int) Integer.parseInt(value.toString());
                break; 
            case "eyr": 
            	expirationYear = (int) convertAcronym(key);
            	expirationYear = (int) Integer.parseInt(value.toString());
                break; 
            case "hgt": 
            	height = (String) convertAcronym(key);
            	height = (String) value;
                break; 
            case "hcl": 
            	hairColor = (String) convertAcronym(key); 
            	hairColor = (String) value;
                break; 
            case "ecl": 
            	eyeColor = (String) convertAcronym(key); 
            	eyeColor = (String) value;
                break; 
            case "pid":
            	passportID = (String) convertAcronym(key);
            	passportID = (String) value;
            	break;
            case "cid":
            	countryID = (int) convertAcronym(key);
            	countryID = (int) Integer.parseInt(value.toString());
            	break;
            default: 
        } 
	}
	
	boolean isValidPassport() {
    return birthYear != 0
        && issueYear != 0
        && expirationYear != 0
        && !height.isEmpty()
        && !hairColor.isEmpty()
        && !eyeColor.isEmpty()
        && !passportID.isEmpty();
		
	}
	
}
