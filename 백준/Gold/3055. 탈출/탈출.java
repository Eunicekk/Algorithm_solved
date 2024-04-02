import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 탈출
public class Main {
	
	static int R;
	static int C;
	static char[][] map;
	
	static Queue<Point> sq = new LinkedList<>();
	static Queue<Point> wq = new LinkedList<>();
	static int min = Integer.MAX_VALUE;
	
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1};
	
	static class Point {
		int r;
		int c;
		int time;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		public Point(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		Point start = null;
		Point water = null;
		
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
				
				if (map[i][j] == '*') {
					wq.offer(new Point(i, j));
				} else if (map[i][j] == 'S') {
					sq.offer(new Point(i, j, 0));
				}
			}
		}
		
		bfs();
		
		if (min == Integer.MAX_VALUE) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(min);
		}
	}
	
	static void bfs () {
		int count = 0;
		
		while (!sq.isEmpty()) {
			// 홍수 이동
			int w_len = wq.size();
			
			for (int i = 0; i < w_len; i++) {
				Point w_point = wq.poll();
				
				for (int d = 0; d < 4; d++) {
					int wr = w_point.r + dr[d];
					int wc = w_point.c + dc[d];
					
					if (wr >= 0 && wc >= 0 && wr < R && wc < C && map[wr][wc] == '.') {
						map[wr][wc] = '*';
						wq.offer(new Point(wr, wc));
					}
				}
			}
			
			// 고슴도치 이동
			int s_len = sq.size();
			
			for (int i = 0; i < s_len; i++) {
				Point s_point = sq.poll();
				
				for (int d = 0; d < 4; d++) {
					int sr = s_point.r + dr[d];
					int sc = s_point.c + dc[d];
					int st = s_point.time;
					
					if (sr >= 0 && sc >= 0 && sr < R && sc < C) {
						// 비버 굴에 도착했을 때
						if (map[sr][sc] == 'D') {
							min = Math.min(min, st + 1);
							return;
						}
						
						// 고슴도치가 움직일 수 있을 때
						else if (map[sr][sc] == '.') {
							map[sr][sc] = 'S';
							sq.offer(new Point(sr, sc, st + 1));
						}
					}
				}
			}
		}
	}
}