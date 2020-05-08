package Q81;

import java.util.ArrayList;
import java.util.Collections;

public class LongestSequenceService {
	ArrayList<Elephant> elephants;

	public LongestSequenceService(ArrayList<Elephant> elephants) {
		Collections.sort(elephants);	// ������ ������������ ����
		this.elephants = elephants;
	}
	
	public void call() {
		longestSequence(this.elephants);
	}
	
	private void longestSequence(ArrayList<Elephant> elephant) {
		int[] dp = new int[elephant.size()];	// �������� ����
		int[] parent = new int[elephant.size()];	// parentIndex ����
		dp[0] = 1;	// ó�� ���̴� 1
			
		for(int i=0; i<dp.length; i++) {
			int max = -1;
			int maxIndex = -1;
			for(int j=0; j<i; j++) {	// iq�� ��������, weight�� ���������̵ǵ���
				if(elephant.get(i).iq < elephant.get(j).iq && max<dp[j] && elephant.get(i).weight > elephant.get(j).weight) {
					max = dp[j];	// ���� �� ���� ����
					maxIndex = j;	// ���� �� ���̸� ������ �ε��� ����
				}
			}
			if(max == -1) {	// max�� -1 �̸� �ڱ� �ڽ� ȥ�ڰ� ���� �� ����
				dp[i] = 1;
				parent[i] = i;
			}
			else {			// max+1�� ���� ��ȣ�� ����, �ش� �ε����� parent�� ����
				dp[i] = max+1;
				parent[i] = maxIndex;
			}
		}
		// ���� �� ������ ����
		int max = dp[0]; 
		int maxIndex = 0;
		for(int i=1; i<dp.length; i++) {
			if(max <= dp[i]) {
				max = dp[i];
				maxIndex = i;
			}
		}
		// ���
		System.out.println(max);
		printSubsequence(elephant, parent, maxIndex);
	}

	private void printSubsequence(ArrayList<Elephant> elephant, int[] parent, int maxIndex) {
		int index = maxIndex;
		String sub = ""+elephant.get(index).n;
			
		while(parent[index] != index) {
			sub = elephant.get(parent[index]).n + "\n" + sub;
			index = parent[index];
		}
			
		System.out.println(sub);
	}


}
