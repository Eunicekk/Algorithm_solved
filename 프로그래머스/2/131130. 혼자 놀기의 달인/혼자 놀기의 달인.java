import java.util.*;

class Solution {
    public int solution(int[] cards) {
        List<Integer> list = new ArrayList<Integer>();
        boolean[] visit = new boolean[cards.length];
        
        for (int i = 0; i < cards.length; i++) {
            if (!visit[i]) {
                int count = 0;
                int index = i;

                while (!visit[index]) {
                    visit[index] = true;
                    index = cards[index] - 1;
                    count++;
                }

                list.add(count);
            }
        }

        list.sort(Collections.reverseOrder());

        if (list.size() < 2) {
            return 0;
        }

        return list.get(0) * list.get(1);
    }
}