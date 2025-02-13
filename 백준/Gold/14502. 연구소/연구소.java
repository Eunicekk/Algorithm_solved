import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[][] section;
	static List<Point> list = new ArrayList<>();
	static int max;
	
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		section = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				section[r][c] = Integer.parseInt(st.nextToken());
				
				if (section[r][c] == 0) {
					list.add(new Point(r, c));
				}
			}
		}

		combination(0, 0);
		System.out.println(max);
	}
	
	static void combination(int depth, int start) {
		if (depth == 3) {
			bfs();
			return;
		}
		
		for (int i = start; i < list.size(); i++) {
			Point point = list.get(i);
			section[point.r][point.c] = 1;
			combination(depth + 1, i + 1);
			section[point.r][point.c] = 0;
		}
	}
	
	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		int[][] temp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			temp[i] = section[i].clone();
			for (int j = 0; j < M; j++) {
				if (temp[i][j] == 2) {
					queue.add(new Point(i, j));
				}
			}
		}
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = point.r + dr[d];
				int nc = point.c + dc[d];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && temp[nr][nc] == 0) {
					temp[nr][nc] = 2;
					queue.add(new Point(nr, nc));
				}
			}
		}
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] == 0) count++;
			}
		}
		
		max = Math.max(max, count);
	}
	
}