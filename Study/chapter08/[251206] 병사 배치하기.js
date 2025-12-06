const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let N = Number(input[0]);
let array = input[1].split(" ").map(Number);

let dp = Array(N).fill(1);

for (let i = 0; i < N; i++) {
  for (let j = 0; j < i; j++) {
    if (array[j] > array[i]) {
      dp[i] = Math.max(dp[i], dp[j] + 1);
    }
  }
}

let lds = Math.max(...dp);
console.log(N - lds);
