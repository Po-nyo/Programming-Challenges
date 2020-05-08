package Q81;

public class Elephant implements Comparable<Elephant> {
	int weight;	// 몸무게
	int iq;		// iq
	int n;

	public Elephant(int weight, int iq, int count) {
		this.weight = weight;
		this.iq = iq;
		this.n = count;
	}

	@Override
	public int compareTo(Elephant o) {	
		// 몸무게 오름차순 정렬
		return this.weight - o.weight;
	}

}
