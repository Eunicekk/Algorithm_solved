import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 회의실 배정
public class Main {
	
	static class Meet {
		int start;
		int fin;
		
		public Meet(int start, int fin) {
			this.start = start;
			this.fin = fin;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Meet[] meet = new Meet[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int fin = Integer.parseInt(st.nextToken());
			meet[i] = new Meet(start, fin);
		}
		
		Arrays.sort(meet, new Comparator<Meet>() {
			@Override
			public int compare(Meet o1, Meet o2) {
				if (o1.fin == o2.fin) {
					return o1.start - o2.start;
				}
				return o1.fin - o2.fin;
			}
		});
		
		int count = 0;
		int prevFin = 0;
		
		for (int i = 0; i < N; i++) {
			if (prevFin <= meet[i].start) {
				prevFin = meet[i].fin;
				count++;
			}
		}

		System.out.println(count);
	}
	
}