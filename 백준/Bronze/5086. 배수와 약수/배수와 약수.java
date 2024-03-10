import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 배수와 약수
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = -1, b = -1;
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if (a == 0 && b == 0) {
				break;
			}
			
			if (a < b) {
				if (b % a == 0) {
					bw.write("factor");
				} else {
					bw.write("neither");
				}
			} else {
				if (a % b == 0) {
					bw.write("multiple");
				} else {
					bw.write("neither");
				}
			}
			bw.write("\n");
		}
		
		bw.close();
	}
	
}