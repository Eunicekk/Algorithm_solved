const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("");

let set = new Set(["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]);
let result = 0;

for (let i = 0; i < input.length; i++) {
  let word = input[i] + input[i + 1];

  if (word === "dz") {
    if (input[i + 2] === "=") {
      result++;
      i += 2;
      continue;
    }
  }

  if (set.has(word)) {
    result++;
    i++;
    continue;
  }

  result++;
}

console.log(result);
