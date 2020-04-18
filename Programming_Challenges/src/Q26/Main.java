package Q26;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author wkj11
 * Programming Challenges Q26. Stacks of Flapjacks (팬 케이크)
 *
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Integer> radius = new ArrayList<>();
		Flapjacks f = new Flapjacks();
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			
			for(String s : line.split(" "))
				radius.add(Integer.parseInt(s));
			
			for(int i : radius)
				System.out.print(i+" ");
			System.out.println();
			
			f.setRadius(radius);
			f.sort();
			
			radius.clear();
		}
		sc.close();
	}
}
