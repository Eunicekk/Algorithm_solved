const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let index = 0;

while (input.length !== index) {
  let n = Number(input[index++]);
  let set = new Set();

  for (let i = 0; i < n; i++) {
    let array = input[index++].split("").map(Number);
    let clearArray = new Set([...array].sort((a, b) => a - b));
    set.add([...clearArray].join(""));
  }

  console.log(set.size);
}
