package Q21;

public class AutoJudge {
	private String[] judgeTypes = { "Presentation Error", "Wrong Answer", "Accepted" };
	private int n;
	
	public AutoJudge() {
		inIt();
	}

	public void call(String[] answer, String[] submit) {
		judge(answer, submit);
	}
	
	private void judge(String[] answer, String[] submit) {
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
	
	private void compareWithNumbers(String[] answer, String[] submit) {
		String ans = transToNumbers(answer);
		String sub = transToNumbers(submit);
		
		if(ans.equals(sub))
			System.out.println("Run #"+(n++)+": "+judgeTypes[0]);
		else
			System.out.println("Run #"+(n++)+": "+judgeTypes[1]);
	}
	
	private String transToNumbers(String[] strings) {
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
