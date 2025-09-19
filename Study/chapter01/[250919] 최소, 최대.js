const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const n = Number(input[0]);
const array = input[1].split(" ");

const max = array.reduce((a, b) => Math.max(Number(a), Number(b)));
const min = array.reduce((a, b) => Math.min(Number(a), Number(b)));

console.log(min, max);
