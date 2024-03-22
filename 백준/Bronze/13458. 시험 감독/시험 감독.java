import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 시험 감독
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // 시험장의 개수
		int[] A = new int[N]; // 시험장 안에 있는 응시자 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st2.nextToken()); // 총감독관 - 감시 가능한 수
		int C = Integer.parseInt(st2.nextToken()); // 부감독관 - 감시 가능한 수
		
		long count = 0;
		
		for (int i = 0; i < N; i++) {
			A[i] -= B;
			count++;
			
			if (A[i] > 0) {
				if (A[i] % C == 0) {
					count += A[i] / C;
				} else {
					count += A[i] / C + 1;
				}
			}
		}
		
		bw.write(count + "");
		bw.close();
	}
	
}