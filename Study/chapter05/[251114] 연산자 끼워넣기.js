const fs = require("fs");
const input = fs.readFileSync("input.txt").toString().trim().split("\n");

const symbol = ["+", "-", "*", "/"];

let n = Number(input[0]);
let numbers = input[1].split(" ").map(Number);
let values = input[2].split(" ").map(Number);
let visit = Array(n - 1).fill(false);

let operator = [];
let select = Array(n - 1).fill("");
let max = -Infinity;
let min = Infinity;

for (let i = 0; i < 4; i++) {
  for (let j = 0; j < values[i]; j++) {
    operator.push(symbol[i]);
  }
}

const calculation = (select) => {
  let result = numbers[0];

  for (let i = 0; i < n - 1; i++) {
    if (select[i] === "+") {
      result += numbers[i + 1];
    } else if (select[i] === "-") {
      result -= numbers[i + 1];
    } else if (select[i] === "*") {
      result *= numbers[i + 1];
    } else if (select[i] === "/") {
      result =
        result > 0
          ? Math.trunc(result / numbers[i + 1])
          : -Math.trunc(Math.abs(result) / numbers[i + 1]);
    }
  }

  return result;
};

const dfs = (depth) => {
  if (depth === n - 1) {
    max = Math.max(max, calculation(select));
    min = Math.min(min, calculation(select));
    return;
  }

  for (let i = 0; i < n - 1; i++) {
    if (!visit[i]) {
      visit[i] = true;
      select[depth] = operator[i];
      dfs(depth + 1);
      visit[i] = false;
    }
  }
};

dfs(0);

// 자바스크립트는 0과 -0이 다르다
console.log(max ? max : 0);
console.log(min ? min : 0);
