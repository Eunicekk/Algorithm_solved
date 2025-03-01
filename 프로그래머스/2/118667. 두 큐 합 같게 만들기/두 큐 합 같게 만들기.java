import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long goal = 0;
        long sum1 = 0;
        long sum2 = 0;
        int count = 0;
        
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        
        long sum = sum1 + sum2;
        if (sum % 2 == 1) return -1;
        goal = (sum1 + sum2) / 2;
        
        int max = (queue1.length + queue2.length) * 2;
        while (count < max) {
            if (sum1 == goal) return count;
            
            if (sum1 > goal) {
                if (!q1.isEmpty()) {
                    int value = q1.poll();
                    sum1 -= value;
                    sum2 += value;
                    q2.offer(value);
                }
            } else {
                if (!q2.isEmpty()) {
                    int value = q2.poll();
                    sum1 += value;
                    sum2 -= value;
                    q1.offer(value);
                }
            }
            
            count++;
        }
        
        return -1;
    }
}