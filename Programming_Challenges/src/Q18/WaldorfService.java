package Q18;

import java.util.LinkedList;
import java.util.Queue;

public class WaldorfService {

	char[][] grid;
	
	public WaldorfService(char[][] grid) {
		this.grid = grid;
	}
	
	public MyPoint findLocation(String word) {
		// word와 일치하는 단어의 시작 포인트를 반환
		MyPoint p = new MyPoint();
		char firstChar = word.charAt(0);
		
		for(int i=0; i<this.grid.length; i++) {
			for(int j=0; j<this.grid[0].length; j++) {
				if(grid[i][j] == firstChar) {
					if(isMatch(word, i, j)) {
						p.setPoint(i, j);
						return p;
					}
				}
			}
		}
		
		return p;
	}
	
	public boolean isMatch(String word, int row, int col) {
		// 8 개의 방향으로 탐색
		int[] rowDirection = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] colDirection = { -1, 0, 1, -1, 1, -1, 0, 1 };
		
		Queue<MyPoint> pointQ = new LinkedList<>();
		pointQ.add(new MyPoint(row, col));
		
		int wordIndex = 1;
			
		while(!pointQ.isEmpty()) {
			int currentSize = pointQ.size();
			char nextChar = word.charAt(wordIndex++);
			
			for(int j=0; j<currentSize; j++) {
				MyPoint currentP = pointQ.poll();
				
				for(int i=0; i<rowDirection.length; i++) {
					int movedRow = currentP.row + rowDirection[i];
					int movedCol = currentP.col + colDirection[i];
					MyPoint movedP = new MyPoint(movedRow, movedCol);
					
					if(isPromising(word, movedP, nextChar))
						pointQ.add(movedP);
				}
			}
			if(wordIndex == word.length() && !pointQ.isEmpty())
				return true;
		}
		return false;
	}
	
	public boolean isPromising(String word, MyPoint p, char nextChar) {
		return (p.row>=0 && p.row<grid.length && 
				p.col>=0 && p.col<grid[0].length &&
				this.grid[p.row][p.col] == nextChar);
	}
	
	
}
