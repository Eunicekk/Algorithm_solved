function solution(polynomial) {
    let array = polynomial.split(" + ");
    let first = 0;
    let second = 0;
    
    for (const item of array) {
        if (item.includes("x")) {
            let num = item.replace("x", "");
            first += (num === "" ? 1 : parseInt(num));
        } else {
            second += parseInt(item);
        }
    }
    
    if (first === 0) {
        return second.toString();
    } else if (first === 1) { 
        return second !== 0 ? "x + " + second : "x";
    } else { 
        return second !== 0 ? first + "x + " + second : first + "x";
    }
}

// 테스트 1 〉	통과 (0.08ms, 33.5MB)
// 테스트 2 〉	통과 (0.08ms, 33.5MB)
// 테스트 3 〉	통과 (0.07ms, 33.1MB)
// 테스트 4 〉	통과 (0.08ms, 33MB)
// 테스트 5 〉	통과 (0.07ms, 33.5MB)
// 테스트 6 〉	통과 (0.10ms, 33.6MB)
// 테스트 7 〉	통과 (0.07ms, 33.5MB)
// 테스트 8 〉	통과 (0.07ms, 33.4MB)
// 테스트 9 〉	통과 (0.07ms, 33.4MB)
// 테스트 10 〉	통과 (0.07ms, 33.6MB)
// 테스트 11 〉	통과 (0.07ms, 33.6MB)
// 테스트 12 〉	통과 (0.07ms, 33.5MB)
