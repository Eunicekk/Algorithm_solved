function solution(my_string) {
    const array = my_string.split(" ");
    var answer = Number(array[0]);
    
    for (let i = 1; i < array.length; i+=2) {
        if (array[i] === "+") {
            answer += Number(array[i+1]);
        } else if (array[i] === "-") {
            answer -= Number(array[i+1]);
        }
    }
    
    return answer;
}

// 테스트 1 〉	통과 (0.05ms, 33.5MB)
// 테스트 2 〉	통과 (0.05ms, 33.4MB)
// 테스트 3 〉	통과 (0.06ms, 33.4MB)
// 테스트 4 〉	통과 (0.09ms, 33.5MB)
// 테스트 5 〉	통과 (0.05ms, 33.5MB)
// 테스트 6 〉	통과 (0.05ms, 33.4MB)
// 테스트 7 〉	통과 (0.05ms, 33.4MB)
// 테스트 8 〉	통과 (0.05ms, 33.4MB)
// 테스트 9 〉	통과 (0.05ms, 33.3MB)
// 테스트 10 〉	통과 (0.05ms, 33.4MB)
