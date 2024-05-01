import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질
public class Main {
	
	static int N;
	static int K;
	static int visit[] = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int result = bfs(N);
		System.out.println(result);
	}
	
	static int bfs (int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(node);
		int index = node;
		visit[index] = 1;
		
		while (!queue.isEmpty()) {
			int p = queue.poll();
			
			if (p == K) return visit[p] - 1;
			if (p-1 >= 0 && visit[p-1] == 0) {
				visit[p-1] = visit[p] + 1;
				queue.offer(p-1);
			}
			if (p+1 <= 100000 && visit[p+1] == 0) {
				visit[p+1] = visit[p] + 1;
				queue.offer(p+1);
			}
			if (2*p <= 100000 && visit[2*p] == 0) {
				visit[2*p] = visit[p] + 1;
				queue.offer(2 * p);
			}
		}
		
		return -1;
	}
}
