import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 알고리즘 수업 - 알고리즘의 수행 시간 5
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long N = Integer.parseInt(br.readLine());
		
		bw.write(N * N * N + "\n");
		bw.write(3 + "\n");
		
		bw.close();
	}
	
}