import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] time_array = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length; i++) {
            int start = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end = Integer.parseInt(book_time[i][1].replace(":", ""));
            
            end += 10;
            
            if (end % 100 >= 60) end += 40;
            
            time_array[i][0] = start;
            time_array[i][1] = end;
        }
        
        Arrays.sort(time_array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                else return Integer.compare(o1[0], o2[0]);
            }
        });
        
        ArrayList<Integer> rooms = new ArrayList<>();
        for (int i = 0; i < time_array.length; i++) {
            Collections.sort(rooms);
            boolean isAdd = false;
            
            for (int j = 0; j < rooms.size(); j++) {
                if (time_array[i][0] >= rooms.get(j)) {
                    rooms.set(j, time_array[i][1]);
                    isAdd = true;
                    break;
                }
            }
            
            if (!isAdd) rooms.add(time_array[i][1]);
        }
        
    return rooms.size();
    }
}