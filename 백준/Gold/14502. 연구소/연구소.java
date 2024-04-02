import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 연구실
public class Main {
	
	static int N;
	static int M;
	static int[][] lab;
	static int[][] temp; // lab을 deep copy할 임시 배열
	static boolean[][] visit;
	static int max = Integer.MIN_VALUE;
	
	static List<Position> list = new ArrayList<>(); // 벽을 둘 수 있는 공간을 담는 리스트
	static Position[] select = new Position[3];
	
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1 ,1};
	
	static class Position {
		int r;
		int c;
		
		public Position(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Position [r=" + r + ", c=" + c + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][M];
		temp = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				
				if (lab[i][j] == 0) {
					list.add(new Position(i, j));
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = lab[i][j];
			}
		}
		
		comb(0, 0);
		
		System.out.println(max);
	}
	
	static void comb (int idx, int sidx) {
		if (sidx == 3) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[i][j] = lab[i][j];
				}
			}
			
			visit = new boolean[N][M];
			bfs(select);
			return;
		}
		
		if (idx == list.size()) {
			return;
		}
		
		select[sidx] = list.get(idx);
		comb(idx + 1, sidx + 1);
		comb(idx + 1, sidx);
	}
	
	static void bfs (Position[] select) {
		int count = 0; // 안전영역 개수 세기
		
		for (int i = 0; i < 3; i++) {
			temp[select[i].r][select[i].c] = 1;
		}
		
		Queue<Position> queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				if (temp[i][j] == 2 && visit[i][j] == false) {
					queue.offer(new Position(i, j));
					visit[i][j] = true;
					
					while (!queue.isEmpty()) {
						Position pos = queue.poll();
						
						for (int d = 0; d < 4; d++) {
							int nr = pos.r + dr[d];
							int nc = pos.c + dc[d];
							
							if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visit[nr][nc] && temp[nr][nc] == 0) {
								temp[nr][nc] = 2;
								visit[nr][nc] = true;
								queue.offer(new Position(nr, nc));
							}
						}
					}
				}
				
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] == 0) {
					count++;
				}
			}
		}
		
		max = Math.max(max, count);
	}
	
}
