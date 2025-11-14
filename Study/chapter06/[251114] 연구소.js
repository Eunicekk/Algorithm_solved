const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const dr = [-1, 1, 0, 0];
const dc = [0, 0, -1, 1];

let [n, m] = input[0].split(" ").map(Number);
let map = [];
let result = 0;

for (let i = 1; i < n + 1; i++) {
  map.push(input[i].split(" ").map(Number));
}

const bfs = (copy) => {
  let queue = [];
  let visit = Array.from({ length: n }, () => Array(m).fill(false));

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (copy[i][j] == 2) {
        queue.push([i, j]);
        visit[i][j] = true;
      }
    }
  }

  while (queue.length > 0) {
    let [r, c] = queue.shift();

    for (let d = 0; d < 4; d++) {
      let nr = r + dr[d];
      let nc = c + dc[d];

      if (
        nr >= 0 &&
        nc >= 0 &&
        nr < n &&
        nc < m &&
        !visit[nr][nc] &&
        copy[nr][nc] === 0
      ) {
        copy[nr][nc] = 2;
        visit[nr][nc] = true;
        queue.push([nr, nc]);
      }
    }
  }

  let safe = 0;

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (copy[i][j] === 0) {
        safe++;
      }
    }
  }

  return safe;
};

const combination = (count) => {
  if (count === 3) {
    let copy = map.map((row) => [...row]);
    result = Math.max(result, bfs(copy));
    return;
  }

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (map[i][j] === 0) {
        map[i][j] = 1;
        combination(count + 1);
        map[i][j] = 0;
      }
    }
  }
};

combination(0);
console.log(result);
