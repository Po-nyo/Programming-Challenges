package Q29;

public class Work implements Comparable<Work> {
	
	private int workDays;
	private int finePerDays;
	private int index;
	
	public Work(int workDays, int finePerDays, int index) {
		this.workDays = workDays;
		this.finePerDays = finePerDays;
		this.index = index;
	}

	@Override
	public int compareTo(Work other) {
		// TODO Auto-generated method stub
		/*
		 * (작업 소요일/하루당 벌금) 으로 정렬
		 */
		double thisWork = (double)this.workDays/this.finePerDays;
		double otherWork = (double)other.workDays/other.finePerDays;
		
		if(thisWork - otherWork > 0)
			return 1;
		else if(thisWork - otherWork == 0)
			return 0;
		else
			return -1;
	}

	public int getIndex() {
		return index;
	}

}
