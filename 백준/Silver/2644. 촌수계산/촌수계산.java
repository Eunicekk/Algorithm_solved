import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int num1, num2;
	static List<Integer>[] graph;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		visit = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		num1 = Integer.parseInt(st.nextToken());
		num2 = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		int count = dfs(num1, 0);
		
		System.out.println(count);
	}
	
	static int dfs(int node, int count) {
		if (node == num2) return count;
		
		visit[node] = true;
		
		for (int next : graph[node]) {
			if (!visit[next]) {
				int result = dfs(next, count + 1);
				if (result != -1) return result;
			}
		}
		
		return -1;
	}
	
}