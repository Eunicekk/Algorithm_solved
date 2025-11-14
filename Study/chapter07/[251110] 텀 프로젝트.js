const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let T = Number(input[0]);
let index = 1;
let result = [];

for (let t = 0; t < T; t++) {
  let n = Number(input[index++]);
  let array = [0, ...input[index++].split(" ").map(Number)];
  let visit = Array(n + 1).fill(false);
  let finish = Array(n + 1).fill(false);
  let count = 0;

  const dfs = (node) => {
    visit[node] = true;
    let next = array[node];

    if (!visit[next]) {
      dfs(next);
    } else if (!finish[next]) {
      let temp = next;

      while (temp !== node) {
        count++;
        temp = array[temp];
      }

      count++;
    }

    finish[node] = true;
  };

  for (let i = 1; i <= n; i++) {
    if (!visit[i]) {
      dfs(i);
    }
  }

  result.push(n - count);
}

console.log(result.join("\n"));
