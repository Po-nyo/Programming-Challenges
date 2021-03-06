package Q18;

import java.util.LinkedList;
import java.util.Queue;

public class WaldorfService {

	char[][] grid;
	
	public WaldorfService(char[][] grid) {
		this.grid = grid;
	}
	
	public void call(String line) {
		MyPoint p = findLocation(line);
		System.out.println((p.getRow()+1)+" "+(p.getCol()+1));
	}
	
	private MyPoint findLocation(String word) {
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
	
	private boolean isMatch(String word, int row, int col) {
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
					int movedRow = currentP.getRow() + rowDirection[i];
					int movedCol = currentP.getCol() + colDirection[i];
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
	
	private boolean isPromising(String word, MyPoint p, char nextChar) {
		int row = p.getRow();
		int col = p.getCol();
		return (row>=0 && row<grid.length && 
				col>=0 && col<grid[0].length &&
				this.grid[row][col] == nextChar);
	}
	
}
