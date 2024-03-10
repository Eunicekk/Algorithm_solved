import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 킹, 퀸, 룩, 비숍, 나이트, 폰
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int king = Integer.parseInt(st.nextToken());
		int queen = Integer.parseInt(st.nextToken());
		int look = Integer.parseInt(st.nextToken());
		int bishop = Integer.parseInt(st.nextToken());
		int knight = Integer.parseInt(st.nextToken());
		int pawn = Integer.parseInt(st.nextToken());
		
		bw.write(1 - king + " ");
		bw.write(1 - queen + " ");
		bw.write(2 - look + " ");
		bw.write(2 - bishop + " ");
		bw.write(2 - knight + " ");
		bw.write(8 - pawn + " ");
		bw.close();
	}
	
}