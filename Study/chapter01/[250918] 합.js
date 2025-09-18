const fs = require("fs");
const input = fs.readFileSync("input.txt").toString().split(" ");

const n = Number(input[0]);
let sum = 0;

for (let i = 1; i <= n; i++) {
  sum += i;
}

console.log(sum);
