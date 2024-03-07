import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 소수 찾기
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		
		for (int n = 0; n < N; n++) {
			List<Integer> list = new ArrayList<>();
			int num = Integer.parseInt(st.nextToken());
			
			for (int i = 1; i <= num; i++) {
				if (num % i == 0) {
					list.add(i);
				}
			}
			
			if (list.size() == 2) {
				answer++;
			}
		}
		
		bw.write(answer + "");
		bw.close();
	}
	
}