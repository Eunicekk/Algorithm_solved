const fs = require("fs");
const input = fs.readFileSync("/dev/stdub").toString().trim().split("\n");

const C = Number(input[0]);
let result = "";

for (let c = 1; c <= C; c++) {
  const line = input[c].split(" ").map(Number);
  let sum = 0;
  let avg = 0;
  let count = 0;

  for (let i = 1; i <= line[0]; i++) {
    sum += line[i];
  }

  avg = sum / line[0];

  for (let i = 1; i <= line[0]; i++) {
    if (line[i] > avg) {
      count++;
    }
  }

  result += `${((count / line[0]) * 100).toFixed(3)}%\n`;
}

console.log(result);
