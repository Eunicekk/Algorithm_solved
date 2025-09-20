const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const T = Number(input[0]);
let result = "";

for (let t = 1; t <= T; t++) {
  const r = Number(input[t].split(" ")[0]);
  const str = input[t].split(" ")[1];

  for (let s of str) {
    result += s.repeat(r);
  }

  result += "\n";
}

console.log(result);
