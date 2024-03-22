import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 방 배정
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] room = new int[2][7]; // 세로가 성별, 가로가 학년
		int count = 0; // 방 개수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 참가 학생 수
		int K = Integer.parseInt(st.nextToken()); // 배정 가능한 최대 인원 수
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st2.nextToken());
			int grade = Integer.parseInt(st2.nextToken());
			
			room[gender][grade]++;
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 7; j++) {
				if (room[i][j] / K == 1 && room[i][j] % K == 0) {
					count++;
				} else if (room[i][j] / K == 1 && room[i][j] % K != 0) {
					count += 2;
				} else if (room[i][j] / K > 1 && room[i][j] % K == 0) {
					count += room[i][j] / K;
				} else if (room[i][j] / K > 1 && room[i][j] % K != 0) {
					count += room[i][j] / K + 1;
				} else if (room[i][j] / K == 0 && room[i][j] % K != 0) {
					count++;
				}
 			}
		}
		
		bw.write(count + "");
		bw.close();
	}
	
}