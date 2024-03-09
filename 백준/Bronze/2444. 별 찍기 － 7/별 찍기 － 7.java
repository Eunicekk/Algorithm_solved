import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 별 찍기 - 7
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N-1; j++) {
				bw.write(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				bw.write("*");
			}
			bw.write("\n");
		}
		
		for (int i = N-2; i >= 0; i--) {
			for (int j = i; j < N-1; j++) {
				bw.write(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				bw.write("*");
			}
			if (i != 0) {
				bw.write("\n");
			}
		}
		
		bw.close();
	}
	
}