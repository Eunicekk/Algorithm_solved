class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] counting = new int[4];
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % first.length]) {
                counting[1]++;
            }
            if (answers[i] == second[i % second.length]) {
                counting[2]++;
            }
            if (answers[i] == third[i % third.length]) {
                counting[3]++;
            }
        }
        
        int max = Integer.MIN_VALUE;
        
        for (int i = 1; i < 4; i++) {
            max = Math.max(max, counting[i]);
        }
        
        int count = 0;
        
        for (int i = 0; i <= 3; i++) {
            if (max == counting[i]) {
               count++;
            }
        }
        
        int[] answer = new int[count];
        int index = 0;
        
        for(int i = 0; i <= 3; i++) {
            if (max == counting[i]) {
                answer[index++] = i;
            }
        }
        
        return answer;
    }
}