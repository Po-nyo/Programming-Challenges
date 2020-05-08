package Q73;

public class Freckles {
	private MyPoint[] points;
	final double MAX = Double.MAX_VALUE;

	
	public Freckles(MyPoint[] points) {
		this.points = points;
	}
	
	public void call() {
		System.out.printf("%.2f", prim(0));
		System.out.println();
	}
	
	// prim 알고리즘으로 점을 하나씩 이어나감
	private double prim(int start) {
		double total = 0;	// 거리의 총합
		boolean[] connected = new boolean[points.length];	// 연결여부
		connected[start] = true;	// 시작점 연결체크
			
		while(!isAllConnected(connected)) {	// 점들이 모두 연결될 때 까지
			double min = MAX;	// 최소 거리 초기화
			int v = -1;			// 최소 거리에 해당하는 점 
			
			for(int i=0; i<points.length; i++) {	// 연결되어있는 점에 대하여
				if(!connected[i])
					continue;
				
				for(int j=0; j<points.length; j++) {	// 점 i와 점j 의 거리중 최소인 값 찾기
					if(j!=i && !connected[j]) {
						double d = Math.sqrt(Math.pow(points[i].x-points[j].x, 2) + Math.pow(points[i].y-points[j].y, 2));
						if(d<min) {
							min = d;
							v = j;
						}
					}
				}
			}
			// 찾은 최소값을 total에 더하고 연결한 점 연결체크
			total += min;
			connected[v] = true;
		}
		return total;	
	}
	
	private boolean isAllConnected(boolean[] connected) {
		// connected 배열이 모두 true인지 확인
		for(boolean b : connected) {
			if(!b)
				return false;
		}
		return true;
	}


}
