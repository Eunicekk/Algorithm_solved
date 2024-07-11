function solution(emergency) {
    var answer = [];
    var temp = [];
    
    for (const item of emergency) {
        temp.push(item);
    }
    
    temp.sort(function(a, b) {
        return b - a;
    });
    
    for (const item of emergency) {
        for (let i = 0; i < temp.length; i++) {
            if (item === temp[i]) {
                answer.push(i+1);
            } 
        }
    }
    
    return answer;
}

// 테스트 1 〉	통과 (0.10ms, 33.5MB)
// 테스트 2 〉	통과 (0.06ms, 33.5MB)
// 테스트 3 〉	통과 (0.08ms, 33.4MB)
// 테스트 4 〉	통과 (0.07ms, 33.5MB)
// 테스트 5 〉	통과 (0.08ms, 33.5MB)
// 테스트 6 〉	통과 (0.07ms, 33.5MB)
// 테스트 7 〉	통과 (0.07ms, 33.6MB)
// 테스트 8 〉	통과 (0.07ms, 33.5MB)
