function solution(n) {
    var array = [];
    for (let i = 0; i <= 10; i++) {
        array.push(factorial(i));
    }
    
    for (let i = 0; i <= 10; i++) {
        if (array[i] > n) return i - 1;
        else if (array[i] === n) return i;
    }
}

const factorial = (n) => {
    if (n === 0) return 0;
    if (n === 1) return 1;
    return n * factorial(n - 1);
}

// 테스트 1 〉	통과 (0.05ms, 33.4MB)
// 테스트 2 〉	통과 (0.06ms, 33.5MB)
// 테스트 3 〉	통과 (0.06ms, 33.6MB)
// 테스트 4 〉	통과 (0.13ms, 33.4MB)
// 테스트 5 〉	통과 (0.12ms, 33.4MB)
// 테스트 6 〉	통과 (0.05ms, 33.5MB)
