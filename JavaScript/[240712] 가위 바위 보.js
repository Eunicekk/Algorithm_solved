function solution(rsp) {
    var array = rsp.split("");
    var answer = '';
    
    for (const item of array) {
        if (item === "0") {
            answer += "5";
        } else if (item === "2") {
            answer += "0";
        } else {
            answer += "2"
        }
    }
    
    return answer;
}

// 테스트 1 〉	통과 (0.05ms, 33.4MB)
// 테스트 2 〉	통과 (0.05ms, 33.4MB)
// 테스트 3 〉	통과 (0.05ms, 33.5MB)
// 테스트 4 〉	통과 (0.07ms, 33.3MB)
// 테스트 5 〉	통과 (0.04ms, 33.4MB)
// 테스트 6 〉	통과 (0.04ms, 33.4MB)
// 테스트 7 〉	통과 (0.13ms, 33.5MB)
