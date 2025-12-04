const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let t = Number(input[0]);
let dp = Array(101).fill(1);

for (let i = 4; i <= 100; i++) {
  dp[i] = dp[i - 2] + dp[i - 3];
}

for (let i = 1; i <= t; i++) {
  let n = Number(input[i]);
  console.log(dp[n]);
}
