const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const n = Number(input[0]);
const soldiers = input[1].split(" ").map(Number);

soldiers.reverse();

let lis = [0];

const lowerBound = (array, target) => {
  let left = 0;
  let right = array.length;

  while (left < right) {
    let mid = parseInt((left + right) / 2);

    if (array[mid] >= target) {
      right = mid;
    } else {
      left = mid + 1;
    }
  }

  return left;
};

for (const soldier of soldiers) {
  if (lis[lis.length - 1] < soldier) {
    lis.push(soldier);
  } else {
    let index = lowerBound(lis, soldier);
    lis[index] = soldier;
  }
}

console.log(n - (lis.length - 1));
