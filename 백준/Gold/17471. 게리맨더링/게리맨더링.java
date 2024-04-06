import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 게리맨더링
public class Main {
	
	static int N; // 지역 수
	static int[] people; // 지역 별 인구 수
	static int[] area; // 선거구
	static boolean[] visit; // 방문 체크
	static List<Integer>[] adj; // 인접 리스트
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		people = new int[N+1];
		adj = new ArrayList[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			adj[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < T; j++) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		area = new int[N+1]; // 지역구의 선거구 저장
		dfs(1);
		
		if (min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}
	
	static void dfs (int v) {
		if (v == N + 1) {
			int area1 = 0;
			int area2 = 0;
			for (int i = 1; i <= N; i++) {
				if (area[i] == 1) area1 += people[i];
				else area2 += people[i];
			}
			
			visit = new boolean[N+1];
			int link = 0;
			for (int i = 1; i <= N; i++) {
				if (!visit[i]) {
					bfs(i, area[i]); // 연결된 지역 탐색
					link++;
				}
			}
			
			if (link == 2) {
				min = Math.min(min, Math.abs(area1 - area2));
			}
			
			return;
		}

		// 1번 선거구 할당
		area[v] = 1;
		dfs(v + 1);
		
		// 2번 선거구 할당
		area[v] = 2;
		dfs(v + 1);
	}
	
	static void bfs (int idx, int areaNum) {
		Queue<Integer> queue = new LinkedList<>();
		visit[idx] = true;
		queue.offer(idx);
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			
			for (int i = 0; i < adj[curr].size(); i++) {
				int next = adj[curr].get(i);
				if (area[next] == areaNum && !visit[next]) {
					queue.offer(next);
					visit[next] = true;
				}
			}
		}
	}
	
}
