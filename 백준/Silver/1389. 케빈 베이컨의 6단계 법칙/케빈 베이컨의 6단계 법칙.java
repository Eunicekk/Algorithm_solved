import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

// 케빈 베이컨의 6단계 법칙
public class Main {
	
	static int N;
	static int M;
	static List<Integer>[] adj;
	static boolean[] visit;
	static int min = Integer.MAX_VALUE;
	static int answer = -1;
	
	static class Point {
		int index;
		int count;
		
		public Point(int index, int count) {
			super();
			this.index = index;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점의 수
		M = Integer.parseInt(st.nextToken()); // 간선의 수
		adj = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			adj[A].add(B);
			adj[B].add(A);
		}
		
		int count = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			bfs(i);
		}
		
		System.out.println(answer);
	}
	
	static void bfs (int start) {
		Queue<Point> queue = new LinkedList<>();
		visit = new boolean[N+1];
		
		queue.offer(new Point(start, 0));
		visit[start] = true;
		int result = 0;
		
		while (!queue.isEmpty()) {
			Point curr = queue.poll();
			
			for (int next : adj[curr.index]) {
				if (!visit[next]) {
					result += curr.count + 1;
					visit[next] = true;
					queue.add(new Point(next, curr.count + 1));
				}
			}
		}
		
		if (result < min) {
			min = result;
			answer = start;
		}
	}
}