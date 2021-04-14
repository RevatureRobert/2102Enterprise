function print(str) {
  console.log(str);
}

function onlyStrings(str) {
  if (typeof str == "String") {
    return true;
  } else {
    false;
  }
}

let happy = true;
happy = function () {
    return "be happy";
}
happy = onlyStrings;
console.log(typeof happy);

let arr = [
  "hey",
  "there",
  "you",
  "I",
  "am",
  "not",
  "an",
  "error",
  55,
  true,
  undefined,
  NaN,
  "\b",
];
arr.filter((str) => !str); //.forEach(print);

const nested = [
  ["hey", "im", "first"],
  ["hey", "im", "second"],
  ["hey", "im", "third"],
];
nested
  .map((ar) => ar.filter((el) => !(el == "hey" || el == "im")))
//   .forEach((val, index, fullArray) =>
//     console.log("val = " + val, "index = " + index, "full array = " + fullArray)
//   );
// console.log(arr);
// console.log(!![]);
// console.log(!!{});

for (const item in arr) { // keys or indexes
  console.log("strings: ",arr[item]);
}

for (const item of arr) { // values
  console.log("all values: ",item);
}
console.log(typeof []);


// pass by value
let obj1 = {};
let obj2 = obj1; // same object, not the same reference
obj2.name = "sammy"; // affects both references due to same object
obj2={}; // does not change reference on obj1
console.log(obj1); // { name: 'sammy' } because obj1 did not change