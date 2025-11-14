const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let n = Number(input[0]);
let numbers = input[1].split(" ").map(Number);

let max = 0;
let visit = Array(n).fill(false);
let select = Array(n).fill(0);

const calculation = (array) => {
  let sum = 0;

  for (let i = 0; i < n - 1; i++) {
    sum += Math.abs(array[i] - array[i + 1]);
  }

  return sum;
};

const dfs = (depth) => {
  if (depth === n) {
    max = Math.max(max, calculation(select));
    return;
  }

  for (let i = 0; i < n; i++) {
    if (!visit[i]) {
      visit[i] = true;
      select[depth] = numbers[i];
      dfs(depth + 1);
      visit[i] = false;
    }
  }
};

dfs(0);
console.log(max);
