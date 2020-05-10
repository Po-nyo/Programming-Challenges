package Q20;

public class CryptKicker {
	
	private String[] codedStrings;
	private char[] code;
	private char defaultValue = '0';
	
	public CryptKicker() {
		code = new char['z'+1];
	}
	
	public void call() {
		if(findCode())
			decode();
		else
			System.out.println("No solution.");
	}
	
	private boolean findCode() {
		String original = "the quick brown fox jumps over the lazy dog";
		codeInit();
		
		for(int i=0; i<codedStrings.length; i++) {
			if(codedStrings[i].length() == original.length()) {
				for(int j=0; j<original.length(); j++) {
					char currentChar = codedStrings[i].charAt(j);
					
					if(currentChar == ' ')
						continue;
					if(this.code[currentChar]!='0' && this.code[currentChar]!=original.charAt(j)) {
						codeInit();
						break;
					}
					this.code[currentChar] = original.charAt(j);
				}
				if(isValidCode()) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isValidCode() {
		for(int i='a'; i<='z'; i++)
			if(this.code[i] == '0')
				return false;
		return true;
	}
	
	private void decode() {
		for(int i=0; i<this.codedStrings.length; i++) {
			String current = codedStrings[i];

			String decoded = "";
			for(int j=0; j<current.length(); j++) {
				char currentChar = current.charAt(j);

				if(currentChar == ' ')
					decoded += " ";
				else
					decoded += code[currentChar];
			}
			System.out.println(decoded);
		}
	}
	
	private void codeInit() {
		for(int i='a'; i<='z'; i++)
			this.code[i] = defaultValue;
	}

	public void setCodedStrings(String[] codedStrings) {
		this.codedStrings = codedStrings;
	}

}
