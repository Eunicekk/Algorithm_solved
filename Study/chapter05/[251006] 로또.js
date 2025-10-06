const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let index = 0;
let result = [];

function dfs(start, depth, array, select, rule) {
  if (depth === 6) {
    result.push(select.join(" "));
    return;
  }

  for (let i = start; i < rule; i++) {
    select.push(array[i]);
    dfs(i + 1, depth + 1, array, select, rule);
    select.pop();
  }
}

while (input[index] !== "0") {
  const numbers = input[index].split(" ").slice(1);
  const rule = Number(input[index].split(" ")[0]);
  let select = [];

  dfs(0, 0, numbers, select, rule);
  result.push("");
  index++;
}

console.log(result.join("\n"));
