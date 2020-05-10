package Q30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author wkj11
 * Programming Challenges Q30. CDVII
 *
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String line;
		int testCaseNum = sc.nextInt();
		Map<String, List<Record>> records = new HashMap<>();
		CDVIIService cs = new CDVIIService();
		cs.setRecords(records);

		sc.nextLine();
		sc.nextLine();
		for(int i=0; i<testCaseNum; i++) {
			int[] fare = new int[24];

			for(int j=0; j<fare.length; j++)
				fare[j] = sc.nextInt();

			sc.nextLine();
			while(sc.hasNextLine()) {
				line = sc.nextLine();
				if(line.equals(""))
					break;
				filter(records, line);
			}
			cs.setFare(fare);
			cs.call();
			records.clear();
		}
		sc.close();
	}

	public static void filter(Map<String, List<Record>> records, String record) {
		String[] splited = record.split(" ");
		String carNumber = splited[0];
		String dateTime = splited[1];
		String detail = splited[2];
		String site = splited[3];
		Record r = new Record(dateTime, detail, site);

		if(!records.containsKey(carNumber)) {
			List<Record> newList = new ArrayList<>();
			newList.add(r);
			records.put(carNumber, newList);
		}
		else
			records.get(carNumber).add(r);
	}

}
