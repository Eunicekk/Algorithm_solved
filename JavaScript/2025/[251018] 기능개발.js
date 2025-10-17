function solution(progresses, speeds) {
    const result = [];
    const days = progresses.map((progress, i) => Math.ceil((100 - progress) / speeds[i]));
    
    while (days.length > 0) {
        const current = days.shift();
        let count = 1;
        
        while (days.length > 0 && days[0] <= current) {
            days.shift();
            count++;
        }
        
        result.push(count);
    }
    
    return result;
}

// 테스트 1 〉	통과 (0.06ms, 33.4MB)
// 테스트 2 〉	통과 (0.16ms, 33.4MB)
// 테스트 3 〉	통과 (0.15ms, 33.5MB)
// 테스트 4 〉	통과 (0.15ms, 33.4MB)
// 테스트 5 〉	통과 (0.08ms, 33.5MB)
// 테스트 6 〉	통과 (0.06ms, 33.2MB)
// 테스트 7 〉	통과 (0.16ms, 33.1MB)
// 테스트 8 〉	통과 (0.06ms, 33.4MB)
// 테스트 9 〉	통과 (0.17ms, 33.4MB)
// 테스트 10 〉	통과 (0.19ms, 33.4MB)
// 테스트 11 〉	통과 (0.06ms, 33.4MB)
