import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // 기둥의 개수
		int[] col = new int[1001];

		int maxIdx = 0;
		int max = 0;
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			col[index] = value;
			
			if (max < value) {
				max = value;
				maxIdx = index;
			}
		}
		
		 // 왼쪽 구간에서 가장 높은 기둥까지의 넓이 계산
        int leftMax = 0;
        for (int i = 0; i < maxIdx; i++) {
            leftMax = Math.max(leftMax, col[i]);
            sum += leftMax;
        }

        // 오른쪽 구간에서 가장 높은 기둥까지의 넓이 계산
        int rightMax = 0;
        for (int i = col.length - 1; i > maxIdx; i--) {
            rightMax = Math.max(rightMax, col[i]);
            sum += rightMax;
        }
		
        // 가장 높은 기둥의 넓이 추가
        sum += max;
        
		bw.write(sum + "");
		bw.close();
	}
	
}