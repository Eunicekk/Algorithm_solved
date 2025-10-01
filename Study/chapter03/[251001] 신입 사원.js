const fs = require("fs");
const input = fs.readFileSync("input.txt").toString().trim().split("\n");

const T = Number(input[0]);
let line = 1;

for (let t = 1; t <= T; t++) {
  const n = Number(input[line]);
  let array = [];

  for (let i = line + 1; i <= line + n; i++) {
    let data = input[i].split(" ").map(Number);
    array.push(data);
  }

  array.sort((a, b) => a[0] - b[0]);

  let count = 0;
  let min = Number.MAX_SAFE_INTEGER;

  for (let [a, b] of array) {
    if (b < min) {
      min = b;
      count++;
    }
  }

  console.log(count);
  line += n + 1;
}
