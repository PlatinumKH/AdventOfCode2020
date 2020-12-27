import java.util.Map;

public class Passport extends Converter {

	int birthYear = 0;
	int issueYear = 0;
	int expirationYear = 0;
	String height = "";
	String hairColor = "";
	String eyeColor = "";
	String passportID = "";
	int countryID = 0;
	
	Passport(Map<String, Object> values) {
		
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
	
	boolean isValidPassportPartTwo() {
	    return birthYearValid()
	        && issueYearValid()
	        && expirationYearValid()
	        && heightValid()
	        && hairColorValid()
	        && eyeColorValid()
	        && passportIDValid();
		}
	
	boolean birthYearValid() {
		return birthYear != 0 
				&& String.valueOf(birthYear).length() == 4
				&& birthYear >= 1920
				&& birthYear <= 2002;
	}
	
	boolean issueYearValid() {
		return issueYear != 0 
				&& String.valueOf(issueYear).length() == 4
				&& issueYear >= 2010
				&& issueYear <= 2020;
	}
	
	boolean expirationYearValid() {
		return expirationYear != 0 
				&& String.valueOf(expirationYear).length() == 4
				&& expirationYear >= 2020
				&& expirationYear <= 2030;
	}
	
	boolean heightValid() {
		if (height != "" && height.length() > 2) {
			char[] heightArray = height.toCharArray();
			
			int length = height.length();
			
			String measurement = "" + heightArray[length - 2] + heightArray[length - 1];
			
			if (measurement.equals("cm") || measurement.equals("in")) {
				String num = "";
				
				for (int i = 0; i < length - 2; i++) {
					num = num + heightArray[i];
				}
				
				int numValue = Integer.parseInt(num);
				
				return (measurement.equals("cm") && numValue >= 150 && numValue <= 193) 
						|| (measurement.equals("in") && numValue >= 59 && numValue <= 76);
			}
		}
		
		return false;
	}
	
	boolean hairColorValid() {
		if (hairColor != "" && hairColor.length() == 7) {
			char[] hairColorArray = hairColor.toCharArray();
			
			if (hairColorArray[0] == '#') {
				for (int i = 1; i < 7; i++) {
					if (!(Character.isDigit(hairColorArray[i]) 
							|| (hairColorArray[i] >= 'a' && hairColorArray[i] <= 'l'))) 
						return false;
				}
				
				return true;
			}
			
		}
		
		return false;
	}
	
	boolean eyeColorValid() {
		return eyeColor.equals("amb")
			|| eyeColor.equals("blu")
			|| eyeColor.equals("brn")
			|| eyeColor.equals("gry")
			|| eyeColor.equals("grn")
			|| eyeColor.equals("hzl")
			|| eyeColor.equals("oth");
	}
	
	boolean passportIDValid() {
		if (passportID.length() == 9) {
			
			char[] passportIDArray = passportID.toCharArray();
			
			for (int i = 0; i < 9; i++) {
				if (!Character.isDigit(passportIDArray[i]))
					return false;
			}
			
			return true;
		}
		
		return false;
	}
	
}
