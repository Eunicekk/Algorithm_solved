import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 인구 이동
public class Main {
	
	static int N; // 땅 크기
	static int L; // 이상
	static int R; // 이하
	static Point[][] A; // 국가
	static boolean[][] visit; // 방문 여부
	static int population;
	static int count;
	static int isWork;
	
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1};
	
	static class Point {
		int r;
		int c;
		int people;
		
		public Point(int r, int c, int people) {
			this.r = r;
			this.c = c;
			this.people = people;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		A = new Point[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int people = Integer.parseInt(st.nextToken());
				A[r][c] = new Point(r, c, people);
			}
		}
		
		int day  = 0;
		
		while (true) {
			visit = new boolean[N][N];
			population = 0;
			count = 0;
			isWork = 0;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!visit[r][c]) bfs(A[r][c]);
				}
			}
			
			if (isWork == 0) break;
			day++;
		}
		
		System.out.println(day);
	}
	
	static void bfs (Point p) {
		Queue<Point> queue = new LinkedList<>();
		Queue<Point> union = new LinkedList<>();
		
		queue.offer(new Point(p.r, p.c, p.people));
		union.offer(new Point(p.r, p.c, p.people));
		
		population = A[p.r][p.c].people;
		count = 1;
		visit[p.r][p.c] = true;
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = point.r + dr[d];
				int nc = point.c + dc[d];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visit[nr][nc]) {
					int value = Math.abs(A[point.r][point.c].people - A[nr][nc].people);
					if (value >= L && value <= R) {
						queue.offer(new Point(nr, nc, A[nr][nc].people));
						union.offer(new Point(nr, nc, A[nr][nc].people));
						
						visit[nr][nc] = true;
						population += A[nr][nc].people;
						count++;
						isWork++;
					}
				}
			}
		}
		
		for (Point pt : union) {
			A[pt.r][pt.c].people = population / count;
		}
	}
	
}
