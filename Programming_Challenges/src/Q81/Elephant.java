package Q81;

public class Elephant implements Comparable<Elephant> {
	int weight;	// ������
	int iq;		// iq
	int n;

	public Elephant(int weight, int iq, int count) {
		this.weight = weight;
		this.iq = iq;
		this.n = count;
	}

	@Override
	public int compareTo(Elephant o) {	
		// ������ �������� ����
		return this.weight - o.weight;
	}

}
