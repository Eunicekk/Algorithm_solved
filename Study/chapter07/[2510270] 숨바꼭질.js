const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split(" ");

let [n, k] = input.map(Number);

const bfs = (start) => {
  let queue = [start];
  let visit = new Array(100000).fill(false);
  visit[start] = true;

  let count = 0;

  while (queue.length > 0) {
    let size = queue.length;

    for (let i = 0; i < size; i++) {
      let node = queue.shift();

      if (node === k) {
        return count;
      }

      let nexts = [node - 1, node + 1, node * 2];

      for (let next of nexts) {
        if (next >= 0 && next <= 100000 && !visit[next]) {
          queue.push(next);
          visit[next] = true;
        }
      }
    }

    count++;
  }
};

let result = bfs(n);
console.log(result);
