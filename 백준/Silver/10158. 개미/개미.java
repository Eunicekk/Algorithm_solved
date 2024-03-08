import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 개미
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st1.nextToken()); // 격자 너비
		int h = Integer.parseInt(st1.nextToken()); // 격자 높이
		int p = Integer.parseInt(st2.nextToken()); // 좌표
		int q = Integer.parseInt(st2.nextToken());
		long t = Integer.parseInt(br.readLine()); // 시간

		int x = (int) (t % (w * 2));
		int y = (int) (t % (h * 2));

		int dx = 1;
		int dy = 1;

		for (int i = 0; i < x; i++) {
			if (p == 0 || p == w) {
				dx *= -1;
			}

			p += dx;
		}

		for (int i = 0; i < y; i++) {
			if (q == 0 || q == h) {
				dy *= -1;
			}

			q += dy;
		}

		bw.write(p + " " + q);
		bw.close();

	}

}