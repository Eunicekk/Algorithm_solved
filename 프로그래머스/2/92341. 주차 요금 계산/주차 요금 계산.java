import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> car_in = new HashMap<>();
        Map<String, Integer> car_out = new HashMap<>();
        
        for (String record : records) {
            String time = record.split(" ")[0];
            String car = record.split(" ")[1];
            String command = record.split(" ")[2];
            
            if (command.equals("IN")) {
                car_in.put(car, time);
            } else if (command.equals("OUT")) {
                int inTime = calculateTime(car_in.get(car));
                int outTime = calculateTime(time);
                int totalTime = outTime - inTime;
                
                car_out.put(car, car_out.getOrDefault(car, 0) + totalTime);
                car_in.remove(car);
            }
        }
        
        for (String car : car_in.keySet()) {
            int inTime = calculateTime(car_in.get(car));
            int outTime = calculateTime("23:59");
            int totalTime = outTime - inTime;

            car_out.put(car, car_out.getOrDefault(car, 0) + totalTime);
        }
        
        List<String> cars = new ArrayList<>(car_out.keySet());
        List<Integer> list = new ArrayList<>();
        Collections.sort(cars);
        
        for (String car : cars) {
            int totalTime = car_out.get(car);
            int fee = fees[1];
            
            if (totalTime > fees[0]) {
                fee += Math.ceil((totalTime - fees[0]) / (double)fees[2]) * fees[3];
            }
            
            list.add(fee);
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    static int calculateTime(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        
        return hour * 60 + minute;
    }
}