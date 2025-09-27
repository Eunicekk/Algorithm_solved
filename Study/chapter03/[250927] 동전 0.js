const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const compare = (a, b) => {
  return b - a;
};

const n = Number(input[0].split(" ")[0]);
let k = Number(input[0].split(" ")[1]);
const coins = input.slice(1).sort(compare);
let result = 0;

coins.forEach((coin) => {
  if (k !== 0) {
    result += parseInt(k / coin);
    k = k % coin;
  } else {
    return;
  }
});

console.log(result);
