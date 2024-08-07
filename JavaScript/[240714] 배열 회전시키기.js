function solution(numbers, direction) {
    if (direction === "right") {
        var right = numbers.pop();
        numbers.unshift(right);
    } else if (direction === "left") {
        var left = numbers.shift();
        numbers.push(left);
    }
    
    return numbers;
}

// 테스트 1 〉	통과 (0.04ms, 33.5MB)
// 테스트 2 〉	통과 (0.03ms, 33.4MB)
// 테스트 3 〉	통과 (0.03ms, 33.4MB)
// 테스트 4 〉	통과 (0.03ms, 33.4MB)
// 테스트 5 〉	통과 (0.03ms, 33.5MB)
