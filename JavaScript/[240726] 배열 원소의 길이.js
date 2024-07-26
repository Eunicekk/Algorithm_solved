function solution(strlist) {
    var answer = [];
    
    for (const item of strlist) {
        var num = 0;
        
        for (let i = 0; i < item.length; i++) {
            num++;
        }
        
        answer.push(num);
    }

    
    return answer;
}

// 테스트 1 〉	통과 (0.05ms, 33.4MB)
// 테스트 2 〉	통과 (0.13ms, 33.4MB)
// 테스트 3 〉	통과 (0.13ms, 33.5MB)
// 테스트 4 〉	통과 (0.04ms, 33.5MB)
// 테스트 5 〉	통과 (0.05ms, 33.4MB)
// 테스트 6 〉	통과 (0.06ms, 33.6MB)
