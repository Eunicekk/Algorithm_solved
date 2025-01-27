import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static char[][] section;
	static boolean[][] visit1;
	static boolean[][] visit2;
	static int count1;
	static int count2;
	
	static int[] dr = {-1, 1, 0, 0};
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
		section = new char[N][N];
		visit1 = new boolean[N][N];
		visit2 = new boolean[N][N];
		
		for (int r = 0; r < N; r++) {
			String temp = br.readLine();
			for (int c = 0; c < N; c++) {
				section[r][c] = temp.charAt(c);
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visit1[r][c]) {
					bfs1(r, c);
					count1++;
				}
				
				if (!visit2[r][c]) {
					bfs2(r, c);
					count2++;
				}
			}
		}
		
		System.out.println(count1 + " " + count2);
	}
	
	// 적록색약 아닌 사람
	static void bfs1(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c));
		char ch = section[r][c];
		visit1[r][c] = true;
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = point.r + dr[d];
				int nc = point.c + dc[d];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visit1[nr][nc]) {
					if (section[nr][nc] == ch) {
						queue.offer(new Point(nr, nc));
						visit1[nr][nc] = true;
					}
				}
			}
		}
	}
	
	// 적록색약인 사람
	static void bfs2(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c));
		char ch = section[r][c];
		visit2[r][c] = true;
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = point.r + dr[d];
				int nc = point.c + dc[d];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visit2[nr][nc]) {
					if (ch == 'R' || ch == 'G') {
						if (section[nr][nc] == 'R' || section[nr][nc] == 'G') {
							queue.offer(new Point(nr, nc));
							visit2[nr][nc] = true;
						}
					} else {
						if (section[nr][nc] == 'B') {
							queue.offer(new Point(nr, nc));
							visit2[nr][nc] = true;
						}
					}
				}
			}
		}
	}
	
}