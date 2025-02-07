package softeer;

import java.util.*;
import java.io.*;

public class Main_장애물인식프로그램 {

	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int count;
	static List<Integer> list = new ArrayList<>();
	
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
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for (int r = 0; r < N; r++) {
			String temp = br.readLine();
			
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(temp.split("")[c]);
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1 && !visit[r][c]) bfs(r, c, 1);
			}
		}
		
		Collections.sort(list);
		
		System.out.println(count);
		for (int number : list) {
			System.out.println(number);
		}
	}
	
	static void bfs(int r, int c, int block) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c));
		visit[r][c] = true;
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = point.r + dr[d];
				int nc = point.c + dc[d];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visit[nr][nc] && map[nr][nc] == 1) {
					queue.offer(new Point(nr, nc));
					visit[nr][nc] = true;
					block++;
				}
			}
		}
		
		list.add(block);
		count++;
	}
	
}
