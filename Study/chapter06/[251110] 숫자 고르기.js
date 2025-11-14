const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let n = Number(input[0]);
let visit = Array(n + 1).fill(false);
let finish = Array(n + 1).fill(false);
let array = [0];
let result = [];

for (let i = 1; i <= n; i++) {
  array.push(Number(input[i]));
}

const dfs = (node) => {
  visit[node] = true;
  let next = array[node];

  if (!visit[next]) {
    dfs(next);
  } else if (!finish[next]) {
    let temp = next;

    while (temp !== node) {
      result.push(temp);
      temp = array[temp];
    }

    result.push(node);
  }

  finish[node] = true;
};

for (let i = 1; i <= n; i++) {
  if (!visit[i]) {
    dfs(i);
  }
}

result.sort((a, b) => a - b);
console.log(result.length);
console.log(result.join("\n"));
