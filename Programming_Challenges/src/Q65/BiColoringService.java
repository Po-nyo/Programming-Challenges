package Q65;

public class BiColoringService {
	
	private int[][] graph;
	private int[] colored;
	private boolean cannotBiColoring;
	private boolean[] visited;
	
	public BiColoringService() {
	}
	
	public boolean BiColoring() {
		dfs(0, 0);
		
		return !cannotBiColoring;
	}
	
	private void dfs(int v, int prevColor) {
		if(cannotBiColoring)
			return;
		
		visited[v] = true;
		colored[v] = prevColor ^ 1;
		
		if(!isBiColored(v)) {
			cannotBiColoring = true;
			return;
		}
		
		for(int i=0; i<graph.length; i++) {
			if(graph[v][i] == 1 && !visited[i])
				dfs(i, colored[v]);
		}
	}
	
	private boolean isBiColored(int v) {
		for(int i=0; i<graph.length; i++) {
			if(graph[v][i]==1 && visited[i] && colored[v] == colored[i])
				return false;
		}
		
		return true;
	}
	
	public void setGraph(int[][] graph) {
		this.graph = graph;
		this.cannotBiColoring = false;
		colored = new int[graph.length];
		visited = new boolean[graph.length];
	}

}
