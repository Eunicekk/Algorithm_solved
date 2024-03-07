import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 프린터 큐
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			Queue<Priority> queue = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 문서의 개수
			int M = Integer.parseInt(st.nextToken()); // 몇 번째로 인쇄되었는지 궁금한 것 위치			
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				queue.add(new Priority(i, Integer.parseInt(st2.nextToken())));
			}
			
			bw.write(findOrder(queue, M) + "\n");
			
		} // tc
		
		bw.close();
	}
	
	static int findOrder(Queue<Priority> queue, int m) {
		int order = 0;
		
		while (!queue.isEmpty()) {
			Priority current = queue.poll();
			boolean canPrint = true;
			
			for (Priority q : queue) {
				if (q.priority > current.priority) {
					canPrint = false;
					break;
				}
			}
			
			if (canPrint) {
				order++;
				if (current.index == m) {
					break;
				}
			} else {
				queue.add(current);
			}
		}
		
		return order;
	}
	
	static class Priority {
		int index;
		int priority;
		
		public Priority() {}

		public Priority(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
	}
	
}