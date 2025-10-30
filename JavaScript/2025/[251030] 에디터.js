const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let left = input[0].split("");
let right = [];
let n = Number(input[1]);

for (let i = 2; i < n+ 2; i++) {
  let command = input[i];

  if (command === 'L') {
    if (left.length) {
      right.push(left.pop());
    }
  } else if (command === 'D') {
     if (right.length) {
       left.push(right.pop());
     }
  } else if (command === 'B') {
    if (left.length) {
      left.pop();
    }
  } else {
    const [, letter] = command.split(" ");
    left.push(letter);
  }
}

console.log(left.join("") + right.reverse().join(""));
