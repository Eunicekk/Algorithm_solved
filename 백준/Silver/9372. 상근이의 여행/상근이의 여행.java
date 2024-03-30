import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static List<Integer>[] adj;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 정점 수 (국가 수)
			int M = Integer.parseInt(st.nextToken()); // 간선 수 (비행기 수)
			
			adj = new ArrayList[N+1];
			visit = new boolean[N+1];
			
			for (int i = 1; i <= N; i++) {
				adj[i] = new ArrayList<Integer>();
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				adj[a].add(b);
				adj[b].add(a);
			}
			
			System.out.println(bfs(1));
		}
	}
	
	static int bfs (int x) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(x);
		visit[x] = true;
		int count = 0;
		
		while (!queue.isEmpty()) {
			int point = queue.poll();

			for (int w : adj[point]) {
				if (!visit[w]) {
					queue.offer(w);
					visit[w] = true;
					count++;
				}
			}
		}
		
		return count;
	}
}