import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// ABCDE
public class Main {
	
	static int N; // 사람 수
	static int M; // 친구관계 수
	static List<Integer>[] adj;
	static boolean[] visit;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N];
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			adj[A].add(B);
			adj[B].add(A);
		}
		
		for (int i = 0; i < N; i++) {
			if (answer != 1) dfs(i, 1);
		}
		
		System.out.println(answer);
	}
	
	static void dfs (int v, int count) {
		if (count == 5) {
			answer = 1;
			return;
		}
		
		visit[v] = true;
		for (int w : adj[v]) {
			if (!visit[w]) {
				dfs(w, count + 1);
			}
		}
		visit[v] = false;
	}
}
