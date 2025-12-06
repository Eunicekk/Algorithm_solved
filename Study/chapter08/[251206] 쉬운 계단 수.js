const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

let mod = 1_000_000_000;

let N = Number(input);
let dp = Array.from({ length: N + 1 }, () => Array(10).fill(0));

for (let d = 1; d <= 9; d++) {
  dp[1][d] = 1;
}

for (let i = 2; i <= N; i++) {
  dp[i][0] = dp[i - 1][1] % mod;
  dp[i][9] = dp[i - 1][8] % mod;

  for (let d = 1; d <= 8; d++) {
    dp[i][d] = (dp[i - 1][d - 1] + dp[i - 1][d + 1]) % mod;
  }
}

let result = dp[N].reduce((acc, val) => (acc + val) % mod, 0);
console.log(result);
