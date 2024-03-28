import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 바이러스
public class Main {
	
	static List<Integer>[] adj;
	static boolean[] visit;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		int M = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 쌍의 수
		
		adj = new ArrayList[N+1];
		visit = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		dfs(1);
		System.out.println(count);
	}
	
	static void dfs (int start) {
		visit[start] = true;
		
		for (int w : adj[start]) {
			if (!visit[w]) {
				count++;
				dfs(w);
				visit[w] = true;
			}
		}
	}
}