import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// DFS와 BFS
public class Main {
	
	static int N; // 정점의 개수
	static boolean[] visited; // 방문 여부 확인
	static List<Integer>[] adj; // 인접 리스트
	
	static StringBuilder sb1 = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 시작점
		
		adj = new ArrayList[N+1];
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
		
		for (int i = 1; i <= N; i++) {
			adj[i].sort(null);
	    }
		
		visited = new boolean[N+1];
		dfs(V);
		visited = new boolean[N+1];
		bfs(V);
		
		System.out.println(sb1);
		System.out.println(sb2);
	}
	
	static void dfs (int k) {
		visited[k] = true;
		sb1.append(k + " ");
		
		for (int w : adj[k]) {
			if (!visited[w]) {
				dfs(w);
			}
		}
	}
	
	static void bfs (int k) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(k);
		visited[k] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			sb2.append(curr + " ");
			
			for (int w : adj[curr]) {
				if (!visited[w]) {
					q.add(w);
					visited[w] = true;
				}
			}
		}
	}
	
}
