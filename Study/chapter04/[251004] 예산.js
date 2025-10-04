const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let n = Number(input[0]);
const budgets = input[1].split(" ").map(Number);
let money = Number(input[2]);

budgets.sort((a, b) => a - b);

let cap = 0;

for (let i = 0; i < n; i++) {
  const remain = n - i;
  const avg = parseInt(money / remain);

  if (budgets[i] > avg) {
    cap = avg;
    break;
  }

  money -= budgets[i];

  if (i === n - 1) {
    cap = budgets[n - 1];
  }
}

console.log(cap);
