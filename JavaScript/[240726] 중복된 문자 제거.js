function solution(my_string) {
    var set = new Set();
    var answer = "";
    
    var temp = my_string.split("");
    for (const item of temp) set.add(item);
    for (const item of set) answer += item;
    
    return answer;
}

// 테스트 1 〉	통과 (0.16ms, 33.6MB)
// 테스트 2 〉	통과 (0.05ms, 33.5MB)
// 테스트 3 〉	통과 (0.15ms, 33.6MB)
// 테스트 4 〉	통과 (0.05ms, 33.4MB)
// 테스트 5 〉	통과 (0.05ms, 33.5MB)
// 테스트 6 〉	통과 (0.07ms, 33.5MB)
// 테스트 7 〉	통과 (0.05ms, 33.6MB)
