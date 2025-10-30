const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let n = Number(input[0]);
let dp = new Array(12);

dp[1] = 1;
dp[2] = 2;
dp[3] = 4;

for (let i = 4; i < 12; i++) {
  dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
}

for (let i = 1; i < n + 1; i++) {
  let num = Number(input[i]);
  console.log(dp[num]);
}
