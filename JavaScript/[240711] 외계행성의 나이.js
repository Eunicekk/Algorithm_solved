function solution(age) {
    var alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'];
    var array = String(age).split("");
    var answer = "";
    
    for (const item of array) {
        answer += alphabet[Number(item)];
    }
    
    return answer;
}

// 테스트 1 〉	통과 (0.05ms, 33.5MB)
// 테스트 2 〉	통과 (0.05ms, 33.4MB)
// 테스트 3 〉	통과 (0.05ms, 33.5MB)
// 테스트 4 〉	통과 (0.05ms, 33.4MB)
// 테스트 5 〉	통과 (0.06ms, 33.4MB)
// 테스트 6 〉	통과 (0.05ms, 33.4MB)
