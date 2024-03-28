import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 연결 요소의 개수
public class Main {

	static int N;
	static int M;
	static List<Integer>[] adj;
	static boolean[] visit;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		visit = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	static void dfs (int start) {
		visit[start] = true;
		
		for (int w : adj[start]) {
			if (!visit[w]) {
				dfs(w);
				visit[w] = true;
			}
		}
	}
	
}