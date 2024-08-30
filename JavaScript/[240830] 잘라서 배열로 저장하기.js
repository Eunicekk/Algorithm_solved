function solution(my_str, n) {
    var answer = [];
    let array = my_str.split("");
    let word = "";
    
    for (const item of array) {
        word += item;
        
        if (word.length === n) {
            answer.push(word);
            word = ''
        }
    }
    
    if (word !== '') answer.push(word);
    
    return answer;
}

// 테스트 1 〉	통과 (0.15ms, 33.4MB)
// 테스트 2 〉	통과 (0.15ms, 33.5MB)
// 테스트 3 〉	통과 (0.15ms, 33.4MB)
// 테스트 4 〉	통과 (0.15ms, 33.5MB)
// 테스트 5 〉	통과 (0.05ms, 33.4MB)
// 테스트 6 〉	통과 (0.14ms, 33.5MB)
// 테스트 7 〉	통과 (0.16ms, 33.5MB)
// 테스트 8 〉	통과 (0.15ms, 33.5MB)
