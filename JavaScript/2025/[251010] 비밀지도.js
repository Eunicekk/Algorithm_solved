function solution(n, arr1, arr2) {
    const result = [];
    
    for (let i = 0; i < n; i++) {
        const row = (arr1[i] | arr2[i]).toString(2).padStart(n, "0");
        
        const line = row.replace(/1/g, "#").replace(/0/g, " ");
        result.push(line);
    }
    
    return result;
}

// 테스트 1 〉	통과 (0.14ms, 33.5MB)
// 테스트 2 〉	통과 (0.18ms, 33.7MB)
// 테스트 3 〉	통과 (0.06ms, 33.4MB)
// 테스트 4 〉	통과 (0.15ms, 33.5MB)
// 테스트 5 〉	통과 (0.07ms, 33.5MB)
// 테스트 6 〉	통과 (0.16ms, 33.5MB)
// 테스트 7 〉	통과 (0.07ms, 33.5MB)
// 테스트 8 〉	통과 (0.11ms, 33.5MB)
