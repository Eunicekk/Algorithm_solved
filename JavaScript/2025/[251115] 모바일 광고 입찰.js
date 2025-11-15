const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let [n, k] = input[0].split(" ").map(Number);
let need = [];

for (let i = 1; i <= n; i++) {
  let [a, b] = input[i].split(" ").map(Number);
  let diff = b - a;
  need.push(Math.max(0, diff));
}

if (k === 0) {
  console.log(k);
  return;
}

need.sort((a, b) => a - b);

console.log(need[k - 1]);
