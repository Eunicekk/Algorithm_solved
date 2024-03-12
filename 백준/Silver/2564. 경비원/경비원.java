import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 경비원
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		Position[] block = new Position[N];
		
		int sum = 0; // 최단 거리의 합
		
		// 상점 위치
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			block[i] = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		// 동근이 위치
		st = new StringTokenizer(br.readLine());
		Position dong = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		if (dong.direction == 1) {
			
			for (int i = 0; i < N; i++) {
				if (block[i].direction == 1) {
					sum += Math.abs(dong.distance - block[i].distance);
				} else if (block[i].direction == 2) {
					sum += h + Math.min(dong.distance + block[i].distance, (w - dong.distance) + (w - block[i].distance));
				} else if (block[i].direction == 3) {
					sum += dong.distance + block[i].distance;
				} else {
					sum += (w - dong.distance) + block[i].distance;
				}
			}
			
		} else if (dong.direction == 2) {
			
			for (int i = 0; i < N; i++) {
				if (block[i].direction == 1) {
					sum += h + Math.min(dong.distance + block[i].distance, (w - dong.distance) + (w - block[i].distance));
				} else if (block[i].direction == 2) {
					sum += Math.abs(dong.distance - block[i].distance);
				} else if (block[i].direction == 3) {
					sum += dong.distance + (h - block[i].distance);
				} else {
					sum += (w - dong.distance) + (h - block[i].distance);
				}
			}
			
		} else if (dong.direction == 3) {
			
			for (int i = 0; i < N; i++) {
				if (block[i].direction == 1) {
					sum += dong.distance + block[i].distance;
				} else if (block[i].direction == 2) {
					sum += (h - dong.distance) + block[i].distance;
				} else if (block[i].direction == 3) {
					sum += Math.abs(dong.distance - block[i].distance);
				} else {
					sum += w + Math.min(dong.distance + block[i].distance, (h - dong.distance) + (h - block[i].distance));
				}
			}
			
		} else {
			
			for (int i = 0; i < N; i++) {
				if (block[i].direction == 1) {
					sum += dong.distance + (w - block[i].distance);
				} else if (block[i].direction == 2) {
					sum += (h - dong.distance) + (w - block[i].distance);
				} else if (block[i].direction == 3) {
					sum += w + Math.min(dong.distance + block[i].distance, (h - dong.distance) + (h - block[i].distance));
				} else {
					sum += Math.abs(dong.distance - block[i].distance);
				}
			}
			
		}
		
		bw.write(sum + "");
		bw.close();
	}
	
}

class Position {
	int direction;
	int distance;
	
	public Position() {}

	public Position(int direction, int distance) {
		this.direction = direction;
		this.distance = distance;
	}
}