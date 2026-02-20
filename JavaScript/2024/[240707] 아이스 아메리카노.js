function solution(money) {
    var answer = [];
    answer.push(parseInt(money / 5500));
    answer.push(money % 5500)
    
    return answer;
}

// 테스트 1 〉	통과 (0.03ms, 33.4MB)
// 테스트 2 〉	통과 (0.03ms, 33.4MB)
// 테스트 3 〉	통과 (0.05ms, 33.3MB)
// 테스트 4 〉	통과 (0.03ms, 33.5MB)
// 테스트 5 〉	통과 (0.03ms, 33.5MB)
