package Q21;

public class AutoJudge {
	private String[] judgeTypes = { "Presentation Error", "Wrong Answer", "Accepted" };
	private int n;
	
	public AutoJudge() {
		inIt();
	}

	public void judge(String[] answer, String[] submit) {
		
		if(answer.length == submit.length) {
			for(int i=0; i<answer.length; i++) {
				if(!answer[i].equals(submit[i])) {
					compareWithNumbers(answer, submit);
					return;
				}
			}
		}
		else {
			compareWithNumbers(answer, submit);
			return;
		}
		
		System.out.println("Run #"+(n++)+": "+judgeTypes[2]);	
	}
	
	public void compareWithNumbers(String[] answer, String[] submit) {
		String ans = toOnlyNumbers(answer);
		String sub = toOnlyNumbers(submit);
		
		if(ans.equals(sub))
			System.out.println("Run #"+(n++)+": "+judgeTypes[0]);
		else
			System.out.println("Run #"+(n++)+": "+judgeTypes[1]);
	}
	
	public String toOnlyNumbers(String[] strings) {
		String merged = "";
		
		for(String s : strings) 
			merged += s;
		
		merged = merged.replaceAll("[^0-9]", "");
		
		return merged;
	}
	
	public void inIt() {
		this.n = 1;
	}
	
}
