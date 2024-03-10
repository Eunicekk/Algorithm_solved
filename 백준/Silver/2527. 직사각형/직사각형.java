import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 직사각형
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int t = 1; t <= 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()); // 직사각형 1 정보
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken()); // 직사각형 2 정보
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			if ((p1 < x2) || (x1 > p2) || (q1 < y2) || (y1 > q2)) {
				bw.write("d" + "\n");
			} else if ((x1 == p2 && y1 == q2) || (x1 == p2 && q1 == y2) || (p1 == x2 && y1 == q2) || (p1 == x2 && q1 == y2)) {
				bw.write("c" + "\n");
			} else if ((x1 == p2) || (p1 == x2) || (y1 == q2) || (q1 == y2)) {
				bw.write("b" + "\n");
			} else {
				bw.write("a" + "\n");
			}
		}
		
		bw.close();
	}
	
}