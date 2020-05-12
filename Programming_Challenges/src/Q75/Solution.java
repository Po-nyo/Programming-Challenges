package Q75;

public class Solution {
	private int[][] graph;
	private int[] fireStation;
	private int n;
	
	private final int MAX_VALUE = Integer.MAX_VALUE;
	
	public Solution(int[][] graph, int[] fireStation, int n) {
		this.graph = graph;
		this.fireStation = fireStation;
		this.n = n;
	}
	
	public void solution() {
		int[] shortest;  // 최단거리
		int currentMax;
		int loc = 0;	// 새로 지을 소방서 위치
		
		if(n == 0) {	// 소방서 갯수가 0일 때
			shortest = new int[graph.length];
			for(int j=0; j<shortest.length; j++)
				shortest[j] = MAX_VALUE;
			currentMax = MAX_VALUE;
		}
		else {	// 소방서 갯수가 0이 아닐 때
			// shortest를 첫번째 소방서에서 모든 교차로까지의 거리로 초기화
			shortest = dijkstra(fireStation[0]);	
			// 각 소방서에서 모든 교차로까지의 최단거리를 구한 후 distance에 저장
			// 각 교차로에서 가장 가까운 소방서까지의 거리를 shortest에 갱신
			for(int j=1; j<n; j++) {
				int[] distance = dijkstra(fireStation[j]);
				update(shortest, distance);
			}
			currentMax = max(shortest);	// 현재 최단거리 중 가장 먼 거리
		}
			
		// 각 교차로에 소방서를 짓는다고 했을 때 최단거리 중 가장 먼 거리가 
		// 최소화되는 교차로 선택
		for(int j=0; j<graph.length; j++) {
			int[] newShortest = shortest.clone();	// 기존 소방서로부터 각 교차로까지 최단거리
			int[] distance = dijkstra(j);	       // j위치에 소방서를 세운다고 가정
			update(newShortest, distance);		// 최단거리 업데이트
			int newMax = max(newShortest);		// 갱신된 최단거리 중 가장 큰 값
			if(currentMax > newMax) { // currentMax보다 작으면 새로 지을 소방서위치로 선택
				currentMax = newMax;
				loc = j;
			}
		}
		System.out.println(loc+1);
		System.out.println();
	}
	
	private int[] dijkstra(int start) {
		int[] distance = new int[graph.length];	// 최단거리 저장
		boolean[] visited = new boolean[graph.length]; // 방문여부 저장
		visited[start] = true;
			
		// 기본 distance를 최댓값으로 초기화, 만약 start vertex와 연결되어있으면 초기거리 설정
		for(int i=0; i<distance.length; i++) {
			if(graph[start][i]!=0) {
				distance[i] = graph[start][i];
			}
			else
				distance[i] = MAX_VALUE;
		}
		distance[start] = 0;	// 자기자신까지의 거리는 0
			
		// dijkstra 알고리즘 수행
		while(!isAllFound(visited)) {
			// 최소 index와 최소 거리 초기화
			int minIndex = -1;
			int min = MAX_VALUE;
			
			// visited에 포함된 vertex중에서 거리가 가장 가까운 vertex를 선택하여
			// minIndex에 저장
			for(int i=0; i<distance.length; i++) {
				if(!visited[i] && min>distance[i]) {
					minIndex = i;
					min = distance[i];
				}
			}
			
			// 선택한 vertex로 갈 수 있는 곳 중 더 빠른경로가 있으면 갱신
			for(int i=0; i<graph.length; i++) {
				if(graph[minIndex][i]!=0) {
					// 현재 추가한 vertex를 통해 갈 수 있는 vertex중에서 기존 경로보다 더 빠르면 업데이트
					distance[i] = Math.min(distance[i], distance[minIndex]+graph[minIndex][i]);
				}
			}
			visited[minIndex] = true; // 선택한 vertex 사용체크
		}
		return distance;
	}
	
	private void update(int[] shortest, int[] distance) {
		// 최단거리 업데이트
		for(int i=0; i<shortest.length; i++) {
			if(shortest[i]>distance[i])
				shortest[i] = distance[i];
		}
	}
	
	private int max(int[] shortest) {
		// 최단거리중 가장 큰 값
		int max = shortest[0];
		for(int i : shortest)
			if(max < i)
				max = i;
		return max;
	}
	
	private boolean isAllFound(boolean[] visited) {
		for(boolean b : visited)
			if(!b)
				return false;
		return true;
	}
}
