package Q28;

import java.util.Arrays;

public class LongestNapService {
	
	private Appointment[] appointments;
	private int day;
	
	public void findLongestNap() {
		Arrays.sort(appointments);
		
		int[] napTime = new int[appointments.length+1];
		int lastIndex = napTime.length-1;
		
		napTime[0] = time(appointments[0].getStartTime()) - time("10:00");
		napTime[lastIndex] = time("18:00") - time(appointments[appointments.length-1].getEndTime());
		
		int longestNapTime = 0;
		int maxIndex = 0;
		
		for(int i=0; i<lastIndex-1; i++) {
			napTime[i+1] = time(appointments[i+1].getStartTime()) - time(appointments[i].getEndTime());
			if(longestNapTime < napTime[i+1]) {
				longestNapTime = napTime[i+1];
				maxIndex = i+1;
			}
		}
		
		if(longestNapTime < napTime[lastIndex]) {
			longestNapTime = napTime[lastIndex];
			maxIndex = lastIndex;
		}
		
		if(maxIndex == 0)
			printNapTime("10:00", longestNapTime);
		else
			printNapTime(appointments[maxIndex-1].getEndTime(), longestNapTime);
	}
	
	private void printNapTime(String startTime, int longestNapTime) {
		int h = longestNapTime/60;
		int m = longestNapTime%60;
		
		System.out.print("Day #"+this.day+": the longest nap starts at "+startTime+
				" and will last for ");
		if(h == 0)
			System.out.println(longestNapTime+" minutes.");
		else {	
			System.out.println(h+" hours and "+m+" minutes.");
		}
	}
	
	private int time(String t) {
		String[] temp = t.split(":");
		return Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
	}
	
	public void setAppointments(Appointment[] appointments, int day) {
		this.appointments = appointments;
		this.day = day;
	}
}
