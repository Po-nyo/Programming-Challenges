package Q41;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 
 * @author wkj11
 * Programming Challenges Q41. How many Fibs? (피보나치 수의 개수)
 *
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BigInteger num_0, num_1;
		
		String max = "1";
		for(int i=0; i<100; i++)
			max += "0";
		
		BigInteger maxValue = new BigInteger(max);
		Fibonacci fibo = new Fibonacci(maxValue);
		
		while(true) {
			num_0 = sc.nextBigInteger();
			num_1 = sc.nextBigInteger();
			
			if(num_0.equals(BigInteger.ZERO) && num_1.equals(BigInteger.ZERO))
				break;
			
			System.out.println(fibo.countFibo(num_0, num_1));
		}
		
		sc.close();
	}

}
