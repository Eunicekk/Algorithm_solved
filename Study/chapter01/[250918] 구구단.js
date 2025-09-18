const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split(" ");
let text = "";

for (let i = 1; i <= 9; i++) {
  text += `${Number(input[0])} * ${i} = ${Number(input[0]) * i}\n`;
}

console.log(text);
