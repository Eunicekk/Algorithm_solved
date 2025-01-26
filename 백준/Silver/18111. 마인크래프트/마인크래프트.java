import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		int B = Integer.parseInt(st.nextToken()); // 들어있는 블록
		int[][] house = new int[N][M];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				house[r][c] = Integer.parseInt(st.nextToken());
				min = Math.min(min, house[r][c]);
				max = Math.max(max, house[r][c]);
			}
		}
		
		int minTime = Integer.MAX_VALUE;
		int height = 0;
		
		for (int h = min; h <= max; h++) {
			int time = 0;
			int block = B;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					int diff = house[r][c] - h;
					
					if (diff > 0) {
						time += diff * 2;
						block += diff;
					} else if (diff < 0) {
						time -= diff;
						block += diff;
					}
				}
			}
			
			if (block >= 0 && time <= minTime) {
				minTime = time;
				height = h;
			}
		}
		
		System.out.println(minTime + " " + height);
	}
	
}