import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static List<Integer>[] graph;
	static int[] parent;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		parent = new int[N+1];
		visit = new boolean[N+1];
		
		for (int i = 1; i <=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		dfs(1);
		
		for (int i = 2; i <= N; i++) {
			sb.append(parent[i]).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void dfs(int node) {
		visit[node] = true;
		
		for (int next : graph[node]) {
			if (!visit[next]) {
				parent[next] = node;
				dfs(next);
			}
		}
	}
	
}
