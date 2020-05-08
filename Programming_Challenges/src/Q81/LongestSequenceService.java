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
		longestSequence();
	}
	
	private void longestSequence() {
		int[] dp = new int[elephants.size()];	// �������� ����
		int[] parent = new int[elephants.size()];	// parentIndex ����
		dp[0] = 1;	// ó�� ���̴� 1
			
		for(int i=0; i<dp.length; i++) {
			int max = -1;
			int maxIndex = -1;
			for(int j=0; j<i; j++) {	// iq�� ��������, weight�� ���������̵ǵ���
				if(elephants.get(i).iq < elephants.get(j).iq && max<dp[j] && elephants.get(i).weight > elephants.get(j).weight) {
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
		printSubsequence(parent, maxIndex);
	}

	private void printSubsequence(int[] parent, int maxIndex) {
		int index = maxIndex;
		String sub = ""+elephants.get(index).n;
			
		while(parent[index] != index) {
			sub = elephants.get(parent[index]).n + "\n" + sub;
			index = parent[index];
		}
			
		System.out.println(sub);
	}


}
