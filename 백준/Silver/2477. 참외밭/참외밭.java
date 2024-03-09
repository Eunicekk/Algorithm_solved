import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 참외밭
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int K = Integer.parseInt(br.readLine()); // 참외의 개수
		int[] direction = new int[6]; // 방향
		int[] size = new int[6]; // 길이
		
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			direction[i] = Integer.parseInt(st.nextToken());
			size[i] = Integer.parseInt(st.nextToken());
		}
		
		int width = 1;
		int[] count = new int[5];
		for (int i = 0; i < 6; i++) {
			count[direction[i]]++;
		}
		
		for(int i = 0; i < 6; i++) {
			if (count[direction[i]] == 1) {
				width *= size[i];
			}
		}
		
		int subWidth = 1;
		for (int i = 0; i < 6; i++) {
			if (i == 0) {
				if (direction[5] == direction[1]) {
					subWidth *= size[0];
				}
			} else if (i == 5) {
				if (direction[4] == direction[0]) {
					subWidth *= size[5];
				}
			} else {
				if (direction[i - 1] == direction[i + 1]) {
					subWidth *= size[i];
				}
			}
		}
		
		bw.write((width - subWidth) * K + "");
		bw.close();
	}
}