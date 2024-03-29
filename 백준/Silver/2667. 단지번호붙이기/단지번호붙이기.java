import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 단지번호붙이기
public class Main {

	static int N;
	static List<Point>[] adj;
	static int[][] map;
	static boolean[][] visit;	
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
		map = new int[N][N];
		visit = new boolean[N][N];
		
		int complex = 0;
		List<Integer> countList = new ArrayList<>();
		
		adj = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				adj[i] = new ArrayList<>();
			}
		}
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == false && map[i][j] == 1) {
					int num = bfs(i, j);
					countList.add(num);
					complex++;
				}
			}
		}
		
		Collections.sort(countList);
		
		System.out.println(complex);
		for (int i = 0; i < countList.size(); i++) {
			System.out.println(countList.get(i));
		}
	}
	
	static int bfs (int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c));
		visit[r][c] = true;
		int count = 1;
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = point.r + dr[i];
				int nc = point.c + dc[i];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] == 1 && !visit[nr][nc]) {
					queue.offer(new Point(nr, nc));
					visit[nr][nc] = true;
					count++;
				}
			}
		}
		
		return count;
	}
	
}