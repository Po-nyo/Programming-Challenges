package Q66;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PlayingWithWheels {
	private int[] initial_state;
	private int[] final_state;
	private Set<String> banList;
	
	public PlayingWithWheels(int[] initial_state, int[] final_state, Set<String> banList) {
		this.initial_state = initial_state;
		this.final_state = final_state;
		this.banList = banList;
	}
	
	public void run() {
		System.out.println(bfs());
	}
	
	private int bfs() {
		Queue<Wheel> q = new LinkedList<>();	// bfs를 위한 큐
		HashSet<String> visited = new HashSet<>();	// 이미 도달했던 상태 저장
		visited.add(Arrays.toString(initial_state));	// 초기값 도달입력
		q.add(new Wheel(initial_state));	// 처음 상태 큐에 입력
			
		while(!q.isEmpty()) {	// bfs 시작
			Wheel current = q.poll();	// 큐에서 하나 꺼냄
				
			for(int i=0; i<4; i++) {	// i 번째 자리 수에 대한 실행
				int[] rightArrow = current.nums.clone();
				int[] leftArrow = current.nums.clone();
				rightArrow[i] = (rightArrow[i]+1)%10;	// 오른쪽 화살표
				leftArrow[i] = (leftArrow[i]+9)%10;	// 왼쪽 화살표
					
				// rightArrow 또는 leftArrow 가 목표상태에 도달하면 현재cnt + 1 반환
				if(Arrays.toString(rightArrow).equals(Arrays.toString(final_state)) || Arrays.toString(leftArrow).equals(Arrays.toString(final_state)))
					return current.cnt+1;
					
				if(!visited.contains(Arrays.toString(rightArrow)) && !banList.contains(Arrays.toString(rightArrow))) {
					// rightArrow가 아직 도달하지 못한 상태이고 금지 리스트에 없으면 큐에 입력
					Wheel w = new Wheel(rightArrow);
					w.cnt = current.cnt+1;
					q.add(w);
					visited.add(Arrays.toString(rightArrow));
				}
				
				if(!visited.contains(Arrays.toString(leftArrow)) && !banList.contains(Arrays.toString(leftArrow))) {
					// leftArrow가 아직 도달하지 못한 상태이고 금지 리스트에 없으면 큐에 입력
					Wheel w = new Wheel(leftArrow);
					w.cnt = current.cnt+1;
					q.add(w);
					visited.add(Arrays.toString(leftArrow));
				}
			}
		}
		return -1;
	}

}
