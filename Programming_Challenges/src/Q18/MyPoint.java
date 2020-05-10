package Q18;

public class MyPoint {
	private int row;
	private int col;
	
	public MyPoint() { }
	public MyPoint(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public void setPoint(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getCol() {
		return this.col;
	}
}
