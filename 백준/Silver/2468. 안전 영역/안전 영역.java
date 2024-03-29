import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 안전 영역
public class Main {
	
	static int N;
	static int[][] safe;
	static boolean[][] visit;
	static List<Integer>[] adj;
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1};
	
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		safe = new int[N][N];
		
		adj = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				safe[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 1; // 아무도 잠기지 않았을 때
		
		for (int k = 1; k <= 100; k++) {
			int count = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (safe[i][j] == k) {
						safe[i][j] = 0;
					}
				}
			}
			
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (safe[i][j] != 0 && visit[i][j] == false) {
						bfs(i, j);
						count++;
					}
				}
			}
			
			max = Math.max(max, count);
		}
		
		System.out.println(max);
	}
	
	static void bfs (int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c));
		visit[r][c] = true;
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = point.r + dr[i];
				int nc = point.c + dc[i];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < N && safe[nr][nc] != 0 && visit[nr][nc] == false) {
					queue.offer(new Point(nr, nc));
					visit[nr][nc] = true;
				}
			}
		}
	}
	
}
