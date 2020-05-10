package Q28;

public class Appointment implements Comparable<Appointment> {
	
	private String startTime;
	private String endTime;
	
	public Appointment(String appointment) {
		String[] temp = appointment.split(" ");
		this.startTime = temp[0];
		this.endTime = temp[1];
	}

	@Override
	public int compareTo(Appointment o) {
		// TODO Auto-generated method stub
		return this.startTime.compareTo(o.startTime);
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

}
