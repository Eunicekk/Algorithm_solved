const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let n = Number(input[0]);
let m = Number(input[1]);
let array = Array.from({ length: n + 1 }, () => []);
let visit = Array(n + 1).fill(false);
let result = 0;

for (let i = 2; i < m + 2; i++) {
  let [a, b] = input[i].split(" ").map(Number);
  array[a].push(b);
  array[b].push(a);
}

const bfs = (start) => {
  let queue = [];
  queue.push([start, 0]);
  visit[start] = true;

  while (queue.length > 0) {
    let [current, depth] = queue.shift();

    if (depth >= 2) {
      continue;
    }

    for (let friend of array[current]) {
      if (!visit[friend]) {
        visit[friend] = true;
        result++;
        queue.push([friend, depth + 1]);
      }
    }
  }
};

bfs(1);
console.log(result);
