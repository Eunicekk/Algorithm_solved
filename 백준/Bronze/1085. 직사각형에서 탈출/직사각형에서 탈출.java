import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 직사각형에서 탈출
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken()); // 한수
		int y = Integer.parseInt(st.nextToken()); // 한수
		int w = Integer.parseInt(st.nextToken()); // 너비
		int h = Integer.parseInt(st.nextToken()); // 높이
		
		int[] distance = new int[4]; // 상 하 좌 우
		int min = Integer.MAX_VALUE;
		
		distance[0] = Math.abs(x - w);
		distance[1] = Math.abs(x - 0);
		distance[2] = Math.abs(y - 0);
		distance[3] = Math.abs(y - h);
		
		for (int i = 0; i < 4; i++) {
			min = Math.min(min, distance[i]);
		}
		
		bw.write(min + "");
		bw.close();
	}
	
}