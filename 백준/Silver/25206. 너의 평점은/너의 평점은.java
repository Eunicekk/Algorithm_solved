import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 너의 평점은
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int timeSum = 0;
		double scoreSum = 0;
		
		for (int t = 0; t < 20; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String dum = st.nextToken();
			double time = Double.parseDouble(st.nextToken());
			String subScore = st.nextToken();
			double score = 0;
			
			if (subScore.equals("A+")) {
				score = 4.5;
			} else if (subScore.equals("A0")) {
				score = 4;
			} else if (subScore.equals("B+")) {
				score = 3.5;
			} else if (subScore.equals("B0")) {
				score = 3;
			} else if (subScore.equals("C+")) {
				score = 2.5;
			} else if (subScore.equals("C0")) {
				score = 2;
			} else if (subScore.equals("D+")) {
				score = 1.5;
			} else if (subScore.equals("D0")) {
				score = 1;
			} else if (subScore.equals("F")) {
				score = 0;
			} else {
				score = -1;
			}
			
			if (score >= 0) {
				scoreSum += score * time;
				timeSum += time;
			}
			
		}
		
		bw.write(String.format("%f", scoreSum / timeSum));
		bw.close();
	}
	
}