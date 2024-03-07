import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 평균
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		double[] scores = new double[N];
		double max = Double.MIN_VALUE;
		double sum = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < scores.length; i++) {
			scores[i] = Double.parseDouble(st.nextToken());
		}
		
		for (int i = 0; i < scores.length; i++) {
			max = Math.max(max, scores[i]);
		}
		
		for (int i = 0; i < scores.length; i++) {
			scores[i] = scores[i] / max * 100;
		}
		
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		
		bw.write(sum / N + "");
		bw.close();
	}
	
}