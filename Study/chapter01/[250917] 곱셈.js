let fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const num1 = Number(input[0]);
const str2 = input[1];

console.log(num1 * Number(str2[2]));
console.log(num1 * Number(str2[1]));
console.log(num1 * Number(str2[0]));
console.log(num1 * Number(str2));
