package Q25;

import java.util.Arrays;

public class MoveService {
	
	public int distanceSum(int[] addresses) {
		int newHomeLoc = specifyLocation(addresses);
		
		int d = 0;
		for(int i : addresses)
			d += Math.abs(newHomeLoc-i);
		
		return d;
	}
	
	public int specifyLocation(int[] addresses) {
		Arrays.sort(addresses);
		
		return addresses[addresses.length/2];
	}

}
