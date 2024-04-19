import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 적록색약
public class Main {
	
	static int N;
	static int[][] section;
	static boolean[][] visit;
	static int count1;
	static int count2;
	
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
		
		section = new int[N][N];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				section[i][j] = temp.charAt(j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					bfs1(i, j);
				}
			}
		}
		
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					bfs2(i, j);
				}
			}
		}
		
		System.out.println(count1 + " " + count2);
	}
	
	// 적록색약 아닌 사람 bfs
	static void bfs1 (int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c));
		visit[r][c] = true;
		count1++;
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = point.r + dr[d];
				int nc = point.c + dc[d];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visit[nr][nc]) {
					if (section[r][c] == section[nr][nc]) {
						queue.offer(new Point(nr, nc));
						visit[nr][nc] = true;
					}
				}
			}
		}
	}
	
	// 적록색약 맞는 사람 bfs
	static void bfs2 (int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c));
		visit[r][c] = true;
		count2++;
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = point.r + dr[d];
				int nc = point.c + dc[d];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visit[nr][nc]) {
					if (section[r][c] == 'R' || section[r][c] == 'G') {
						if (section[nr][nc] != 'B') {
							queue.offer(new Point(nr, nc));
							visit[nr][nc] = true;
						}
					} else {
						if (section[r][c] == section[nr][nc]) {
							queue.offer(new Point(nr, nc));
							visit[nr][nc] = true;
						}
					}
				}
			}
		}
	}
	
}
