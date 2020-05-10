package Q25;

import java.util.Arrays;

public class MoveService {
	
	public void call(int[] addresses) {
		System.out.println(distanceSum(addresses));
	}
	
	private int distanceSum(int[] addresses) {
		int newHomeLoc = specifyLocation(addresses);
		
		int d = 0;
		for(int i : addresses)
			d += Math.abs(newHomeLoc-i);
		
		return d;
	}
	
	private int specifyLocation(int[] addresses) {
		Arrays.sort(addresses);
		
		return addresses[addresses.length/2];
	}

}
