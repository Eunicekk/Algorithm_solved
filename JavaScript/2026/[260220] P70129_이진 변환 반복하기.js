function solution(s) {
    let count = 0;
    let zero = 0;
    
    let string = s.split("");
    
    while (string.length !== 1) {
        let change = string.filter((i) => i === '1');
        count++;
        zero += string.length - change.length;
        string = change.length.toString(2).split("");
    }
    
    return [count, zero];
}

// 정확성  테스트
// 테스트 1 〉	통과 (0.08ms, 33.2MB)
// 테스트 2 〉	통과 (21.52ms, 36.3MB)
// 테스트 3 〉	통과 (0.07ms, 33MB)
// 테스트 4 〉	통과 (0.06ms, 33MB)
// 테스트 5 〉	통과 (0.06ms, 33.3MB)
// 테스트 6 〉	통과 (0.11ms, 33.5MB)
// 테스트 7 〉	통과 (0.15ms, 33.4MB)
// 테스트 8 〉	통과 (0.11ms, 33.3MB)
// 테스트 9 〉	통과 (25.53ms, 37.8MB)
// 테스트 10 〉	통과 (22.11ms, 38.1MB)
// 테스트 11 〉	통과 (4.33ms, 37.1MB)
