import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 상수
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String tempA = st.nextToken();
		String tempB = st.nextToken();
		String a = "", b = "";
		
		for (int i = 2; i >= 0; i--) {
			a += tempA.charAt(i);
			b += tempB.charAt(i);
		}
		
		int numA = Integer.parseInt(a);
		int numB = Integer.parseInt(b);
		
		if (numA > numB) {
			bw.write(String.format("%d", numA));
		} else {
			bw.write(String.format("%d", numB));
		}
		bw.close();
	}
	
}