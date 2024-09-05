function solution(my_string) {
    let array = my_string.split("");
    let num = "";
    let sum = 0;
    
    for (const item of array) {
        if (item === "0" || item === "1" || item === "2" || item === "3" || item === "4" || item === "5" || item === "6" || item === "7" || item === "8" || item === "9") {
            num += item;
        } else {
            sum += Number(num);
            num = "";
        }
    }
    
    if (num !== "") {
        sum += Number(num);
    }
    
    return sum;
}

// 테스트 1 〉	통과 (0.15ms, 33.6MB)
// 테스트 2 〉	통과 (0.08ms, 33.5MB)
// 테스트 3 〉	통과 (0.14ms, 33.5MB)
// 테스트 4 〉	통과 (0.15ms, 33.4MB)
// 테스트 5 〉	통과 (0.06ms, 33.5MB)
// 테스트 6 〉	통과 (0.06ms, 33.5MB)
// 테스트 7 〉	통과 (0.06ms, 33.5MB)
// 테스트 8 〉	통과 (0.06ms, 33.5MB)
// 테스트 9 〉	통과 (0.07ms, 33.6MB)
// 테스트 10 〉	통과 (0.06ms, 33.5MB)
