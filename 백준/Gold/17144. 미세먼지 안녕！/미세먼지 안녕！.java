import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 미세먼지 안녕!
public class Main {
	
	static int R;
	static int C;
	static int T;
	static int[][] room;
	static int[][] temp;
	static int airCleaner;
	
	static int[] dr = {0, -1, 0, 1}; // 우 상 좌 하
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken()); // 시간
		room = new int[R][C];
		
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				room[r][c] = Integer.parseInt(st.nextToken());
				if (room[r][c] == -1) airCleaner = r; // 공기 청정기 아래 위치
			}
		}
		
		for (int i = 0; i < T; i++) {
			temp = new int[R][C];
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (room[r][c] > 0) {
						dust(r, c);
					}
				}
			}
			spread();
			cleanUp();
			cleanDown();
		}
		
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] == -1) {
					continue;
				} else {
					sum += room[i][j];
				}
			}
		}
		
		System.out.println(sum);
	}
	
	static void dust (int r, int c) {
		int amount = room[r][c] / 5;
		int count = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr >= 0 && nc >= 0 && nr < R && nc < C && room[nr][nc] != -1) {
				temp[nr][nc] += amount;
				count++;
			}
		}

		room[r][c] -= (amount * count);
	}
	
	static void spread () {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				room[r][c] += temp[r][c];
			}
		}
	}
	
	static void cleanUp () {
		// 위쪽 공기청정기
		for (int i = airCleaner-1; i > 0; i--) {
			if (room[i][0] != -1) {
				room[i][0] = room[i-1][0];
			}
		}
		
		for (int i = 0; i < C-1; i++) {
			room[0][i] = room[0][i+1];
		}
		
		for (int i = 0; i < airCleaner-1; i++) {
			room[i][C-1] = room[i+1][C-1];
		}
		
		for (int i = C-1; i > 1; i--) {
			room[airCleaner-1][i] = room[airCleaner-1][i-1];
		}
		
		room[airCleaner-1][1] = 0;
	}
	
	static void cleanDown () {
		// 아래쪽 공기정청기
		for (int i = airCleaner+1; i < R - 1; i++) {
            room[i][0] = room[i + 1][0];
        }
		
        for (int i = 0; i < C - 1; i++) {
            room[R - 1][i] = room[R - 1][i + 1];
        }
        
        for (int i = R - 1; i > airCleaner; i--) {
            room[i][C - 1] = room[i - 1][C - 1];
        }
        
        for (int i = C - 1; i > 1; i--) {
            room[airCleaner][i] = room[airCleaner][i - 1];
        }
        
        room[airCleaner][1] = 0;
	}
}
