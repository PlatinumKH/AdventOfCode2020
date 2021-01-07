import java.util.List;

public class Person {
	
	boolean[] yes = new boolean[26];
	
	Person(String s) {
		char[] answers = s.toCharArray();
		
		for (char a : answers) {
			yes[(int) a - 97] = true;
		}
	}
	
	List<Character> returnYesAnswers(){
		return null;
	}
}
