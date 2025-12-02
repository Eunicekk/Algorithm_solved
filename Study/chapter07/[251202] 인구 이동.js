const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let dr = [-1, 1, 0, 0];
let dc = [0, 0, -1, 1];

let [N, L, R] = input[0].split(" ").map(Number);
let map = [];
let day = 0;

for (let i = 1; i <= N; i++) {
  map.push(input[i].split(" ").map(Number));
}

const bfs = (sr, sc, visit) => {
  let queue = [[sr, sc]];
  let union = [[sr, sc]];
  let sum = map[sr][sc];
  visit[sr][sc] = true;

  let head = 0;

  while (head < queue.length) {
    let [r, c] = queue[head++];

    for (let d = 0; d < 4; d++) {
      let nr = r + dr[d];
      let nc = c + dc[d];

      if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
        if (!visit[nr][nc]) {
          let diff = Math.abs(map[r][c] - map[nr][nc]);

          if (diff >= L && diff <= R) {
            visit[nr][nc] = true;
            queue.push([nr, nc]);
            union.push([nr, nc]);
            sum += map[nr][nc];
          }
        }
      }
    }
  }

  return { union, sum };
};

while (true) {
  let visit = Array.from({ length: N }, () => Array(N).fill(false));
  let move = false;

  for (let r = 0; r < N; r++) {
    for (let c = 0; c < N; c++) {
      if (!visit[r][c]) {
        let { union, sum } = bfs(r, c, visit);

        if (union.length >= 2) {
          let avg = Math.floor(sum / union.length);

          for (let [r, c] of union) {
            if (map[r][c] !== avg) {
              map[r][c] = avg;
              move = true;
            }
          }
        }
      }
    }
  }

  if (!move) {
    break;
  }

  day++;
}

console.log(day);
