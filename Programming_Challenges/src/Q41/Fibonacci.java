package Q41;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
	
	private List<BigInteger> fiboList;
	private BigInteger maxValue;
	
	public Fibonacci(BigInteger maxValue) {
		this.maxValue = maxValue;
		makeFiboList();
	}
	
	public int countFibo(BigInteger num_0, BigInteger num_1) {
		int count = 0;
		
		for(int i=0; i<fiboList.size(); i++) {
			BigInteger current = fiboList.get(i);
			if(current.compareTo(num_0) >= 0 && current.compareTo(num_1) <= 0)
				count++;
			if(current.compareTo(num_1) > 0)
				return count;
		}
		
		return count;
	}
	
	private void makeFiboList() {
		fiboList = new ArrayList<>();
		fiboList.add(BigInteger.ONE);
		fiboList.add(BigInteger.ONE);
		
		while(true) {
			int lastIndex = fiboList.size()-1;
			BigInteger currentValue = fiboList.get(lastIndex).add(fiboList.get(lastIndex-1));
			
			if(currentValue.compareTo(maxValue) > 0)
				break;
			else
				fiboList.add(currentValue);
		}
	}

}
