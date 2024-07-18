function solution(n) {
    var answer = 0;
    
    for (let i = 2; i <= n; i++) {
        if (!isPrime(i)) answer++;
    }
    
    return answer;
}

const isPrime = (num) => {
    if (num === 2) return true;
    for (let i = 2; i <= parseInt(Math.sqrt(num)); i++) {
        if (num % i === 0) return false;
    }
    
    return true;
}

// 테스트 1 〉	통과 (0.15ms, 33.4MB)
// 테스트 2 〉	통과 (0.03ms, 33.5MB)
// 테스트 3 〉	통과 (0.08ms, 33.4MB)
// 테스트 4 〉	통과 (0.07ms, 33.5MB)
// 테스트 5 〉	통과 (0.23ms, 33.5MB)
// 테스트 6 〉	통과 (0.06ms, 33.4MB)
