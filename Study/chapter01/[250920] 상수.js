const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split(" ");

const str1 = input[0];
const str2 = input[1];

let num1 = "";
let num2 = "";

for (let i = 2; i >= 0; i--) {
  num1 += str1.split("")[i];
  num2 += str2.split("")[i];
}

console.log(Math.max(Number(num1), Number(num2)));
