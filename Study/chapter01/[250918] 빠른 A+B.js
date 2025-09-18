const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

let sum = "";
const t = Number(input[0]);

for (let i = 1; i <= t; i++) {
  const a = Number(input[i].split(" ")[0]);
  const b = Number(input[i].split(" ")[1]);

  sum += `${a + b}\n`;
}

console.log(sum);
