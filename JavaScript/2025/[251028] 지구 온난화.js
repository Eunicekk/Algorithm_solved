const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let dr = [-1, 1, 0, 0];
let dc = [0, 0, -1, 1];

let [R, C] = input[0].split(" ").map(Number);
let board = [];
let copy = [];

for (let i = 1; i < R + 1; i++) {
  board.push(input[i].split(""));
  copy.push(input[i].split(""));
}

for (let r = 0; r < R; r++) {
  for (let c = 0; c < C; c++) {
    let sea = 0;

    for (let d = 0; d < 4; d++) {
      let nr = r + dr[d];
      let nc = c + dc[d];

      if (nr < 0 || nc < 0 || nr >= R || nc >= C || board[nr][nc] === ".") {
        sea++;
      }
    }

    if (sea >= 3) {
      copy[r][c] = ".";
    }
  }
}

let [maxR, maxC, minR, minC] = [0, 0, R, C];

for (let r = 0; r < R; r++) {
  for (let c = 0; c < C; c++) {
    if (copy[r][c] === "X") {
      minR = Math.min(minR, r);
      maxR = Math.max(maxR, r);
      minC = Math.min(minC, c);
      maxC = Math.max(maxC, c);
    }
  }
}

if (minR > maxR || minC > maxC) {
  console.log(".");
} else {
  for (let r = minR; r <= maxR; r++) {
    console.log(copy[r].slice(minC, maxC + 1).join(""));
  }
}
