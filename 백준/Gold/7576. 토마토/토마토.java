import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[][] tomato;
	static boolean[][] visit;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Point {
		int r;
		int c;
		int d;
		
		public Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M];
		visit = new boolean[N][M];
		
		Queue<Point> queue = new LinkedList<>();
		int one = 0;
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				tomato[r][c] = Integer.parseInt(st.nextToken());
				if (tomato[r][c] == 1) {
					one++;
					queue.offer(new Point(r, c, 0));
					visit[r][c] = true;
				}
			}
		}
		
		if (one == N * M) {
			System.out.println(0);
			return;
		}
		
		int day = bfs(queue);
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (tomato[r][c] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(day);
	}
	
	static int bfs(Queue<Point> queue) {
		int day = 0;
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = point.r + dr[i];
				int nc = point.c + dc[i];
				int nd = point.d + 1;
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visit[nr][nc] && tomato[nr][nc] == 0) {
					queue.offer(new Point(nr, nc, nd));
					visit[nr][nc] = true;
					tomato[nr][nc] = 1;
					day = Math.max(day, nd);
				}
			}
		}
		
		return day;
	}
	
}