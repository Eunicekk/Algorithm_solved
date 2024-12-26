import java.util.*;

class Solution {
    static char[][] classroom;
    static boolean[][] visit;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Point {
        int r;
        int c;
        int w;

        public Point(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }
    }
    
    public int[] solution(String[][] places) {
        int[] answer = {1, 1, 1, 1, 1};
        
        out: for (int t = 0; t < 5; t++) {
            classroom = new char[5][5];
            
            for (int r = 0; r < 5; r++) {
                String temp = places[t][r];
                
                for (int c = 0; c < 5; c++) {
                    classroom[r][c] = temp.charAt(c);
                }
            }
            
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if (classroom[r][c] == 'P') {
                        if (bfs(r, c, 0) == 0) {
                            answer[t] = 0;
                            continue out;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    public int bfs(int r, int c, int w) {
        visit = new boolean[5][5];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r, c, 0));
        visit[r][c] = true;
        
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = point.r + dr[d];
                int nc = point.c + dc[d];
                
                if (nr >= 0 && nc >= 0 && nr < 5 && nc < 5 && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    
                    if (classroom[nr][nc] == 'P') {
                        if (point.w + 1 <= 2) return 0;
                    } else if (classroom[nr][nc] == 'O') {
                        queue.offer(new Point(nr, nc, point.w + 1));
                    }
                }
            }
        }
        
        return 1;
    }
}