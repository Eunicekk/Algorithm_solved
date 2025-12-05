const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const mod = 10007;

let [N, M, H] = input[0].split(" ").map(Number);
let students = input.slice(1).map((line) => {
  return line.split(" ").map(Number);
});

let dp = Array(H + 1).fill(0);
dp[0] = 1;

for (let i = 0; i < N; i++) {
  let next = Array(H + 1).fill(0);

  for (let h = 0; h <= H; h++) {
    if (dp[h] === 0) {
      continue;
    }

    next[h] = (next[h] + dp[h]) % mod;

    for (let block of students[i]) {
      if (h + block <= H) {
        next[h + block] = (next[h + block] + dp[h]) % mod;
      }
    }
  }

  dp = next;
}

console.log(dp[H] % mod);
