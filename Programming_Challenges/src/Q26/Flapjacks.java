package Q26;

import java.util.Collections;
import java.util.List;

public class Flapjacks {
	
	private List<Integer> radius;

	public void sort() {
		List<Integer> sub;
		int size = this.radius.size();
		
		for(int i=size-1; i>0; i--) {
			sub = this.radius.subList(0, i+1);
			int maxIndex = sub.indexOf(Collections.max(sub));
			
			if(maxIndex != sub.size()-1) {
				if(maxIndex != 0) {
					this.reverse(sub, 0, maxIndex);
					System.out.print((size-maxIndex)+" ");
				}
				
				Collections.reverse(sub);
				System.out.print((size-i)+" ");
			}
		}
		System.out.println("0");
	}
	
	public void reverse(List<Integer> list, int from, int to) {
		for(int i=0; i<=to/2; i++) {
			int temp = list.get(i);
			list.set(i, list.get(to-i));
			list.set(to-i, temp);
		}
	}
	
	public void setRadius(List<Integer> radius) {
		this.radius = radius;
	}
	
}
