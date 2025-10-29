const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

for (let value of input) {
  if (value === ".") {
    break;
  }

  let stack = [];
  let words = value.split("");

  for (let word of words) {
    if (word === "(" || word === "[") {
      stack.push(word);
    } else if (word === ")") {
      if (stack.length === 0 || stack[stack.length - 1] !== "(") {
        stack.push(word);
        break;
      }

      stack.pop();
    } else if (word === "]") {
      if (stack.length === 0 || stack[stack.length - 1] != "[") {
        stack.push(word);
        break;
      }

      stack.pop();
    }
  }

  console.log(stack.length === 0 ? "yes" : "no");
}
