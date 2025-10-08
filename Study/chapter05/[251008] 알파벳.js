const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const dr = [-1, 1, 0, 0];
const dc = [0, 0, -1, 1];

const [R, C] = input[0].split(" ").map(Number);
let board = [];

for (let i = 1; i <= R; i++) {
  board.push(input[i].split(""));
}

let visit = new Array(26).fill(false);
let max = 0;

function dfs(r, c, count) {
  max = Math.max(count, max);

  for (let d = 0; d < 4; d++) {
    const nr = r + dr[d];
    const nc = c + dc[d];

    if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
      const code = board[nr][nc].charCodeAt(0) - 65;

      if (!visit[code]) {
        visit[code] = true;
        dfs(nr, nc, count + 1);
        visit[code] = false;
      }
    }
  }
}

visit[board[0][0].charCodeAt(0) - 65] = true;
dfs(0, 0, 1);

console.log(max);
