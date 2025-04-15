class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        int zero = 0;
        
        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                zero++;
                continue;
            }
    
            for (int j = 0; j < 6; j++) {
                if (lottos[i] == win_nums[j]) count++;
            }    
        }
        
        if (count + zero == 6) answer[0] = 1;
        else if (count + zero == 5) answer[0] = 2;
        else if (count + zero == 4) answer[0] = 3;
        else if (count + zero == 3) answer[0] = 4;
        else if (count + zero == 2) answer[0] = 5;
        else answer[0] = 6;
        
        if (count == 6) answer[1] = 1;
        else if (count == 5) answer[1] = 2;
        else if (count == 4) answer[1] = 3;
        else if (count == 3) answer[1] = 4;
        else if (count == 2) answer[1] = 5;
        else answer[1] = 6;
        
        return answer;
    }
}