function solution(s){
    let string = s.split("");
    let stack = [];
    
    for (let i = 0; i < string.length; i++) {
        if (stack.length === 0) {
            if (string[i] === '(') {
                stack.push(string[i]);
            } else {
                return false;
            }
        } else {
            if (string[i] === ')') {
                stack.pop();
            } else {
                stack.push(string[i]);
            }
        }
    }
    
    return stack.length === 0 ? true : false;
}

// 정확성  테스트
// 테스트 1 〉	통과 (0.05ms, 33.4MB)
// 테스트 2 〉	통과 (0.05ms, 33.5MB)
// 테스트 3 〉	통과 (0.07ms, 33.4MB)
// 테스트 4 〉	통과 (0.05ms, 33.4MB)
// 테스트 5 〉	통과 (0.05ms, 33.4MB)
// 테스트 6 〉	통과 (0.05ms, 33.5MB)
// 테스트 7 〉	통과 (0.05ms, 33.5MB)
// 테스트 8 〉	통과 (0.05ms, 33.4MB)
// 테스트 9 〉	통과 (0.12ms, 33.5MB)
// 테스트 10 〉	통과 (0.05ms, 33.6MB)
// 테스트 11 〉	통과 (0.05ms, 33.4MB)
// 테스트 12 〉	통과 (0.14ms, 33.5MB)
// 테스트 13 〉	통과 (0.13ms, 33.4MB)
// 테스트 14 〉	통과 (0.13ms, 33.5MB)
// 테스트 15 〉	통과 (0.13ms, 33.4MB)
// 테스트 16 〉	통과 (0.15ms, 33.5MB)
// 테스트 17 〉	통과 (0.14ms, 33.4MB)
// 테스트 18 〉	통과 (0.13ms, 33.6MB)

// 효율성  테스트
// 테스트 1 〉	통과 (28.56ms, 37.7MB)
// 테스트 2 〉	통과 (29.19ms, 37.7MB)
