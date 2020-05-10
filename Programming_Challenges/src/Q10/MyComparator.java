package Q10;

import java.util.Comparator;

public class MyComparator implements Comparator<String> {
	
	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		String numbers = "23456789TJQKA";
		int o1Value = numbers.indexOf(s1.charAt(0));
		int o2Value = numbers.indexOf(s2.charAt(0));
		
		return o2Value - o1Value;
	}

}
