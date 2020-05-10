package Q28;

/**
 * 
 * @author wkj11
 * Programming Challenges Q28. Longest Nap (낮잠 오래 자기)
 * 
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int day = 1;
		
		LongestNapService lns = new LongestNapService();
		while(sc.hasNextLine()) {
			int n = sc.nextInt();
			Appointment[] appointments = new Appointment[n];
			
			sc.nextLine();
			for(int i=0; i<n; i++) {
				String appointment = sc.nextLine();
				appointments[i] = new Appointment(appointment);
			}
			
			lns.setAppointments(appointments, day++);
			lns.solution();
		}
		
		sc.close();
	}
}
