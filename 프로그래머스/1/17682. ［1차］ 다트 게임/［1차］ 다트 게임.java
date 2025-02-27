class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3]; // 점수 배열
        int scoreIndex = 0; // 점수 저장 인덱스
        int num = 0; // 현재 점수 저장
        
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            
            if (Character.isDigit(c)) {
                if (c == '1' && dartResult.charAt(i+1) == '0') {
                    num = 10;
                    i++;
                } else {
                    num = c - '0';
                }
            } else if (c == 'S' || c == 'D' || c == 'T') {
                if (c == 'S') {
                    num = (int) Math.pow(num, 1);
                } else if (c == 'D') {
                    num = (int) Math.pow(num, 2);
                } else if (c == 'T') {
                    num = (int) Math.pow(num, 3);
                }
                
                scores[scoreIndex++] = num;
            } else if (c == '*' || c == '#') {
                if (c == '*') {
                    scores[scoreIndex - 1] *= 2;
                    if (scoreIndex - 2 >= 0) {
                        scores[scoreIndex - 2] *= 2;
                    }
                } else if (c == '#') {
                    scores[scoreIndex - 1] *= -1;
                }
            }
        }
        
        return scores[0] + scores[1] + scores[2];
    }
}