import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 알고리즘 수업 - 깊이 우선 탐색 1
public class Main {
	
	static int N; // 정점의 수
	static int M; // 간선의 수
	static int R; // 시작 정점
	
	static List<Integer>[] adj;
	static int[] visit;
	static int order;
	
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		visit = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			adj[A].add(B);
			adj[B].add(A);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(adj[i]);
		}
		
		order = 1;
		dfs(R);
		
		for (int i = 1; i <= N; i++) {
			sb.append(visit[i] + "\n");
		}
		
		System.out.print(sb);
	}
	
	static void dfs (int v) {
		visit[v] = order++;
		
		for (int w : adj[v]) {
			if (visit[w] == 0) {
				dfs(w);
			}
		}
	}
}
