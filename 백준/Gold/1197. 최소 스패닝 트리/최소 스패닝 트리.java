import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최소 스패닝 트리
public class Main {
	
	static class Point implements Comparable<Point> {
		int st, ed, w;

		public Point(int st, int ed, int w) {
			this.st = st;
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); // 정점 수
		int E = Integer.parseInt(st.nextToken()); // 간선 수
		
		List<Point>[] adj = new ArrayList[V+1];
		for (int i = 0; i < V+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			adj[A].add(new Point(A, B, W));
			adj[B].add(new Point(B, A, W));
		}
		
		boolean[] visit = new boolean[V+1];
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		visit[1] = true;
		
		for (int i = 0; i < adj[1].size(); i++) {
			pq.add(adj[1].get(i));
		}
		
		int pick = 1; // 뽑은 간선 수
		int sum = 0; // 최소비용 합
		
		while (pick != V) {
			Point p = pq.poll();
			if (visit[p.ed]) continue;
			
			sum += p.w;
			visit[p.ed] = true;
			pick++;
			
			pq.addAll(adj[p.ed]);
		}
		
		System.out.println(sum);
	}

}