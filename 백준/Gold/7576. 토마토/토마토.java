import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
public class Main {
	
	static int N; // 상자 가로
	static int M; // 상자 세로
	static int[][] tomato;
	static boolean[][] visit;
	static List<Integer>[] adj;
	static int count;
	
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M];
		visit = new boolean[N][M];
		adj = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 1) {
					queue.offer(new Point(i, j));
					visit[i][j] = true;
				}
			}
		}
		
		bfs(queue);
		
		out : for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 0) {
					count = -1;
					break out;
				} else {
					count = Math.max(count, tomato[i][j] - 1);				
				}
			}
		}
		
		System.out.println(count);
	}
	
	static void bfs(Queue<Point> queue) {
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = point.r + dr[i];
				int nc = point.c + dc[i];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && tomato[nr][nc] == 0 && visit[nr][nc] == false) {
					queue.offer(new Point(nr, nc));
					tomato[nr][nc] = tomato[point.r][point.c] + 1;
					visit[nr][nc] = true;
				}
			}
		}
	}
	
}
