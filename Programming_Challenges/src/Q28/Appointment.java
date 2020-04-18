package Q28;

public class Appointment implements Comparable<Appointment> {
	
	private String startTime;
	private String endTime;
	
	public Appointment(String startTime, String endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public int compareTo(Appointment o) {
		// TODO Auto-generated method stub
		return this.startTime.compareTo(o.startTime);
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
