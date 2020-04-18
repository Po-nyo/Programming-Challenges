package Q27;

import java.util.List;

public class CrossBridgeService {
	
	private List<Integer> speeds;
	private String crossOrder;
	private int crossTime;
	
	public void printSolution() {
		if(this.crossOrder.equals(""))
			this.solve();
		
		System.out.println(this.crossTime);
		this.printOrder();
	}
	
	private void solve() {
		if(!this.crossOrder.equals(""))
			printOrder();
		else {
			while(speeds.size() >= 4) {	
				int A = speeds.get(0);	// fastest
				int B = speeds.get(1);	// second fastest
				int C = speeds.get(speeds.size()-2);	// second slowest
				int D = speeds.get(speeds.size()-1);	// slowest
				
				int t1 = 2*A + C + D;
				int t2 = A + 2*B + D;
				
				if(t1 < t2) {	// choice the best
					crossTime += t1; 
					this.crossOrder += A+" "+C+"/"+A+"/"+A+" "+D+"/"+A+"/";
				}
				else {
					crossTime += t2;
					this.crossOrder += A+" "+B+"/"+A+"/"+C+" "+D+"/"+B+"/";
				}
				
				// slowest 두 명 삭제
				speeds.remove(speeds.size()-1);
				speeds.remove(speeds.size()-1);
			}
			crossTime += solution_1();
		}
	}
	
	private int solution_1() {
		// 3명 이하인 경우의 solution
		if(speeds.size() == 3) {
			this.crossOrder += speeds.get(0)+" "+speeds.get(1)+"/"+
		speeds.get(0)+"/"+speeds.get(0)+" "+speeds.get(2)+"/"; 
			return speeds.get(0) + speeds.get(1) + speeds.get(2);
		}
		else if(speeds.size() == 2) {
			this.crossOrder += speeds.get(0)+" "+speeds.get(1)+"/";
			return speeds.get(1);
		}
		else {
			this.crossOrder += speeds.get(0)+"/";
			return speeds.get(0);
		}
	}
	
	public void setSpeeds(List<Integer> speeds) {
		this.speeds = speeds;
		this.crossOrder = "";
		this.crossTime = 0;
	}
	
	private void printOrder() {
		/* '/'를 기준으로 줄 띄움하여 출력 */
		String[] lines = this.crossOrder.split("/");
		
		for(String s : lines)
			System.out.println(s);
	}

}
