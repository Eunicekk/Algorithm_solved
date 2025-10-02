const fs = require("fs");
const input = fs
  .readFileSync("input.txt")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

for (let n of input.slice(1)) {
  const fibo = [1, 2];

  while (fibo[fibo.length - 1] <= n) {
    fibo.push(fibo[fibo.length - 1] + fibo[fibo.length - 2]);
  }

  const result = [];
  let remain = n;

  for (let i = fibo.length - 1; i >= 0; i--) {
    if (fibo[i] <= remain) {
      result.push(fibo[i]);
      remain -= fibo[i];
    }
  }

  console.log(result.sort((a, b) => a - b).join(" "));
}
