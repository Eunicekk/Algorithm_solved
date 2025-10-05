const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const T = Number(input[0]);

function solve(n) {
  let result = [];

  function dfs(num, expr) {
    if (num === n) {
      let calc = expr.replace(/ /g, "");

      if (eval(calc) === 0) {
        result.push(expr);
      }

      return;
    }

    let next = num + 1;

    dfs(next, expr + " " + next);
    dfs(next, expr + "+" + next);
    dfs(next, expr + "-" + next);
  }

  dfs(1, "1");
  return result;
}

let combineResult = [];

for (let t = 1; t <= T; t++) {
  let n = Number(input[t]);
  combineResult.push(solve(n).join("\n"));
}

console.log(combineResult.join("\n\n"));
