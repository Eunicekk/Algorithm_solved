import java.util.*;
import java.io.*;

public class Main {
	
	static int[] board = new int[101];
	static boolean[] visit = new boolean[101];
	
	static class Point {
		int index;
		int move;
		
		public Point(int index, int move) {
			this.index = index;
			this.move = move;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사다리의 수
		int M = Integer.parseInt(st.nextToken()); // 뱀의 수
		
		for (int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			board[from] = to;
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(1, 0));
		visit[1] = true;
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			int index = point.index;
			int move = point.move;
			
			if (index == 100) return move;
			
			for (int d = 1; d <= 6; d++) {
				int next = index + d;
				if (next <= 100 && !visit[next]) {
					visit[next] = true;
					
					if (board[next] != 0) {
						next = board[next];
					}
					
					queue.offer(new Point(next, move + 1));
				}
			}
		}
		
		return -1;
	}
	
}