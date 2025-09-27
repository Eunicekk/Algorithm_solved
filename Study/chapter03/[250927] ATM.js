const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const compare = (a, b) => {
  return a - b;
};

const n = Number(input[0]);
const times = input[1].split(" ").map(Number).sort(compare);
let result = 0;

for (let i = 0; i < n; i++) {
  result += times[i] * (n - i);
}

console.log(result);
