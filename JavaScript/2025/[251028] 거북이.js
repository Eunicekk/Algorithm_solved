const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let T = Number(input[0]);
let dr = [1, 0, -1, 0];
let dc = [0, 1, 0, -1];

for (let t = 1; t < T + 1; t++) {
  let commands = input[t].split("");
  let [maxR, maxC] = [0, 0];
  let [minR, minC] = [0, 0];
  let [r, c] = [0, 0];
  let angle = 0;

  commands.forEach((command) => {
    if (command === "F") {
      r += dr[angle];
      c += dc[angle];
    } else if (command === "B") {
      r -= dr[angle];
      c -= dc[angle];
    } else if (command === "L") {
      angle = (angle + 3) % 4;
    } else if (command === "R") {
      angle = (angle + 1) % 4;
    }

    maxR = Math.max(maxR, r);
    minR = Math.min(minR, r);
    maxC = Math.max(maxC, c);
    minC = Math.min(minC, c);
  });

  let result = Math.abs(maxR - minR) * Math.abs(maxC - minC);
  console.log(result);
}
