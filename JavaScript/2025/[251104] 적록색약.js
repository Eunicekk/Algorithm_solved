const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const dr = [-1, 1, 0, 0];
const dc = [0, 0, -1, 1];

let n = Number(input[0]);
let array = [];
let visit = Array.from({ length: n }, () => Array(n).fill(false));
let visit_blind = Array.from({ length: n }, () => Array(n).fill(false));

for (let i = 1; i < n + 1; i++) {
  array.push(input[i].split(""));
}

let bfs = (sr, sc) => {
  let queue = [[sr, sc]];
  let value = array[sr][sc];
  visit[sr][sc] = true;

  while (queue.length > 0) {
    let [r, c] = queue.shift();

    for (let d = 0; d < 4; d++) {
      let nr = r + dr[d];
      let nc = c + dc[d];

      if (
        nr >= 0 &&
        nc >= 0 &&
        nr < n &&
        nc < n &&
        !visit[nr][nc] &&
        array[nr][nc] === value
      ) {
        queue.push([nr, nc]);
        visit[nr][nc] = true;
      }
    }
  }
};

let bfs_blind = (sr, sc) => {
  let queue = [[sr, sc]];
  let value = array[sr][sc];
  visit_blind[sr][sc] = true;

  if (value === "R" || value === "G") {
    while (queue.length > 0) {
      let [r, c] = queue.shift();

      for (let d = 0; d < 4; d++) {
        let nr = r + dr[d];
        let nc = c + dc[d];

        if (
          nr >= 0 &&
          nc >= 0 &&
          nr < n &&
          nc < n &&
          !visit_blind[nr][nc] &&
          (array[nr][nc] === "R" || array[nr][nc] === "G")
        ) {
          queue.push([nr, nc]);
          visit_blind[nr][nc] = true;
        }
      }
    }
  } else {
    while (queue.length > 0) {
      let [r, c] = queue.shift();

      for (let d = 0; d < 4; d++) {
        let nr = r + dr[d];
        let nc = c + dc[d];

        if (
          nr >= 0 &&
          nc >= 0 &&
          nr < n &&
          nc < n &&
          !visit_blind[nr][nc] &&
          array[nr][nc] === "B"
        ) {
          queue.push([nr, nc]);
          visit_blind[nr][nc] = true;
        }
      }
    }
  }
};

let count = 0;
let count_blind = 0;

for (let i = 0; i < n; i++) {
  for (let j = 0; j < n; j++) {
    if (!visit[i][j]) {
      count++;
      bfs(i, j);
    }

    if (!visit_blind[i][j]) {
      count_blind++;
      bfs_blind(i, j);
    }
  }
}

console.log(count, count_blind);
