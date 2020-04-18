package Q30;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CDVIIService {
	
	private Map<String, List<Record>> records;
	private int[] fare;
	
	public void calcFare() {
		String[] keys = this.records.keySet().toArray(new String[0]);
		Arrays.sort(keys);
		
		
		for(String carNumber : keys) {
			List<Record> currentList = records.get(carNumber);
			Collections.sort(currentList);
			double fee = 2;
			
			for(int i=0; i<currentList.size()-1; i++) {
				Record current = currentList.get(i);
				Record next = currentList.get(i+1);
				if(current.getDetail().equals("enter") &&
				   next.getDetail().equals("exit")) {
					int distance = Math.abs(Integer.parseInt(current.getSite()) - Integer.parseInt(next.getSite()));
					int enterTime = Integer.parseInt(current.getDateTime().substring(6, 8));
					fee += fare[enterTime]*0.01*distance + 1;
					i++;
				}
			}
			
			if(fee != 2)
				System.out.printf(carNumber+" $%.2f\n", fee);
		}
	}
	
	public void setRecords(Map<String, List<Record>> records) {
		this.records = records;
	}
	
	public void setFare(int[] fare) {
		this.fare = fare;
	}

}
