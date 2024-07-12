function solution(hp) {
    var answer = 0;
    var remain = 0;
    
    if (hp >= 5) {
        answer += parseInt(hp / 5);
        hp = hp % 5;
    }
    
    if (hp >= 3) {
        answer += parseInt(hp / 3);
        hp = hp % 3;
    }
    
    if (hp >= 1) {
        answer += hp;
    }
    
    return answer;
}

// 테스트 1 〉	통과 (0.03ms, 33.4MB)
// 테스트 2 〉	통과 (0.03ms, 33.5MB)
// 테스트 3 〉	통과 (0.03ms, 33.4MB)
// 테스트 4 〉	통과 (0.05ms, 33.5MB)
// 테스트 5 〉	통과 (0.03ms, 33.3MB)
// 테스트 6 〉	통과 (0.04ms, 33.2MB)
// 테스트 7 〉	통과 (0.03ms, 33.4MB)
