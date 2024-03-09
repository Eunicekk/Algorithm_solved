import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 줄 세우기
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // 줄 서는 학생 수
		int[] line = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (num == 0) {
				line[i-1] = i;
			} else {
				for (int j = 1; j <= num; j++) {
					line[i-j] = line[i-1-j];
				}
				line[i-1-num] = i;
			}
		}
		
		for (int i = 0; i < N; i++) {
			bw.write(line[i] + " ");
		}
		
		bw.close();
		
	}
	
}