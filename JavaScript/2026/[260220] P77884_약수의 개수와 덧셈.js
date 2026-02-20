function solution(left, right) {
    let result = 0;
    
    for (let rule = left; rule <= right; rule++) {
        let count = 1;
        
        for (let i = 2; i <= rule; i++) {
            if (rule % i === 0) {
                count++;
            }
        }
        
        if (count % 2 === 1) {
            result -= rule;
        } else {
            result += rule;
        }
    }
    
    return result;
}

// 정확성  테스트
// 테스트 1 〉	통과 (3.98ms, 36.3MB)
// 테스트 2 〉	통과 (2.20ms, 36.3MB)
// 테스트 3 〉	통과 (2.23ms, 36.3MB)
// 테스트 4 〉	통과 (1.87ms, 36.3MB)
// 테스트 5 〉	통과 (3.92ms, 36.3MB)
// 테스트 6 〉	통과 (0.53ms, 33.6MB)
// 테스트 7 〉	통과 (0.28ms, 33.5MB)
