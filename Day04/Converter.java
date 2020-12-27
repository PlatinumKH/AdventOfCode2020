import java.util.HashMap;
import java.util.Map;

public class Converter {
	static Map<String, Object> acronyms = new HashMap<String, Object>();
	
	Converter() {
		acronyms.put("byr", new Integer(0));
		acronyms.put("iyr", new Integer(0));
		acronyms.put("eyr", new Integer(0));
		acronyms.put("hgt", new String());
		acronyms.put("hcl", new String());
		acronyms.put("ecl", new String());
		acronyms.put("pid", new String());
		acronyms.put("cid", new Integer(0));
	}
	
	static Object convertAcronym(String key){
		return acronyms.get(key);
	}
	
}
