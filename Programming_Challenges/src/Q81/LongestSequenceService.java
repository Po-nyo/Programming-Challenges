package Q81;

import java.util.ArrayList;
import java.util.Collections;

public class LongestSequenceService {
	ArrayList<Elephant> elephants;

	public LongestSequenceService(ArrayList<Elephant> elephants) {
		Collections.sort(elephants);	// 몸무게 오름차순으로 정렬
		this.elephants = elephants;
	}
	
	public void call() {
		longestSequence();
	}
	
	private void longestSequence() {
		int[] dp = new int[elephants.size()];	// 수열길이 저장
		int[] parent = new int[elephants.size()];	// parentIndex 저장
		dp[0] = 1;	// 처음 길이는 1
			
		for(int i=0; i<dp.length; i++) {
			int max = -1;
			int maxIndex = -1;
			for(int j=0; j<i; j++) {	// iq는 내림차순, weight는 오름차순이되도록
				if(elephants.get(i).iq < elephants.get(j).iq && max<dp[j] && elephants.get(i).weight > elephants.get(j).weight) {
					max = dp[j];	// 가장 긴 길이 저장
					maxIndex = j;	// 가장 긴 길이를 가지는 인덱스 저장
				}
			}
			if(max == -1) {	// max가 -1 이면 자기 자신 혼자가 가장 긴 수열
				dp[i] = 1;
				parent[i] = i;
			}
			else {			// max+1을 현재 번호에 저장, 해당 인덱스를 parent로 저장
				dp[i] = max+1;
				parent[i] = maxIndex;
			}
		}
		// 가장 긴 수열의 길이
		int max = dp[0]; 
		int maxIndex = 0;
		for(int i=1; i<dp.length; i++) {
			if(max <= dp[i]) {
				max = dp[i];
				maxIndex = i;
			}
		}
		// 출력
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
